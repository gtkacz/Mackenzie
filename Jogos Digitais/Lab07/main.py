from pathlib import Path
from random import choice as randchoice, uniform as randfloat

import pygame


def solve_path(path: str | Path) -> Path:
    return Path(path).resolve()


class Entity(pygame.Rect):
    def __init__(self, x: int, y: int, width: int, height: int, speed: tuple[float, float]):
        super().__init__(x, y, width, height)
        self.speed = speed

    def move(self):
        self.x += self.speed[0]
        self.y += self.speed[1]

    def check_bounds(self, *, height=None, width=None, auto_bounce=True, auto_reset=True):
        if height:
            if self.y <= 0:
                if auto_reset:
                    self.y = 0

                if auto_bounce:
                    self.speed = (self.speed[0], self.speed[1] * -1)

                return True

            elif self.y >= height - self.height:
                if auto_reset:
                    self.y = height - self.height

                if auto_bounce:
                    self.speed = (self.speed[0], self.speed[1] * -1)

                return True
            
        if width:
            if self.x <= 0:
                if auto_reset:
                    self.x = 0

                if auto_bounce:
                    self.speed = (self.speed[0] * -1, self.speed[1])

                return True

            elif self.x >= width - self.width:
                if auto_reset:
                    self.x = width - self.width

                if auto_bounce:
                    self.speed = (self.speed[0] * -1, self.speed[1])

                return True

        return False


def main():
    pygame.init()

    WIDTH, HEIGHT = 1280, 720
    FPS = 60
    SOUND_DIR = './static/sounds/'
    PLAYER_HEIGHT = 30
    DEFAULT_SPEED = WIDTH // 128

    SCREEN = pygame.display.set_mode((WIDTH, HEIGHT))
    CLOCK = pygame.time.Clock()
    HIT = pygame.mixer.Sound(solve_path(f'{SOUND_DIR}/colision.wav'))
    SCORE = pygame.mixer.Sound(solve_path(f'{SOUND_DIR}/point.wav'))

    game_score = [0, 0]

    pygame.display.set_caption('Jogos Digitais - Lab07')

    player1 = Entity(0, 0, PLAYER_HEIGHT, 150, (0, DEFAULT_SPEED))
    player2 = Entity(WIDTH-PLAYER_HEIGHT, 0, PLAYER_HEIGHT, 150, (0, DEFAULT_SPEED))
    ball = Entity(600, 350, 15, 15, (DEFAULT_SPEED*0.75, DEFAULT_SPEED*0.75))

    while True:
        for event in pygame.event.get():
            match event.type:
                case pygame.QUIT:
                    pygame.quit()
                    raise SystemExit

                case pygame.KEYDOWN:
                    match event.key:
                        case pygame.K_a:
                            pygame.quit()
                            raise SystemExit

                        case pygame.K_w:
                            player1.speed = (0, -DEFAULT_SPEED)
                        case pygame.K_s:
                            player1.speed = (0, DEFAULT_SPEED)

                        case pygame.K_o | pygame.K_UP:
                            player2.speed = (0, -DEFAULT_SPEED)
                        case pygame.K_l | pygame.K_DOWN:
                            player2.speed = (0, DEFAULT_SPEED)

        player1.move()
        player2.move()
        ball.move()

        if ball.colliderect(player1) or ball.colliderect(player2):
            ball.speed = (ball.speed[0] * -1, ball.speed[1] * -1)
            HIT.play()

        player1.check_bounds(height=HEIGHT)
        player2.check_bounds(height=HEIGHT)

        if ball.check_bounds(height=HEIGHT, auto_bounce=False, auto_reset=False):
            ball.speed = (ball.speed[0], ball.speed[1] * -1)

        elif ball.check_bounds(width=WIDTH, auto_bounce=False):
            SCORE.play()

            if ball.speed[0] < 0:
                game_score[1] += 1
            else:
                game_score[0] += 1

            ball = Entity(600, 350, 15, 15, (DEFAULT_SPEED*randchoice((-1, 1))*randfloat(0.5, 1.5), DEFAULT_SPEED*randchoice((-1, 1))*randfloat(0.5, 1.5)))

            print(f'Player 1: {game_score[0]} | Player 2: {game_score[1]}')

        SCREEN.fill((0, 255, 0))
        pygame.draw.rect(SCREEN, "black", player1)
        pygame.draw.rect(SCREEN, "black", player2)
        pygame.draw.circle(SCREEN, "black", ball.center, 8)
        CLOCK.tick(FPS)
        pygame.display.flip()


if __name__ == '__main__':
    main()
