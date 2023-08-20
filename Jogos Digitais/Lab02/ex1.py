from os import _exit as exit

import pygame
import pygame.locals as pg


def main():
    SCREEN_SIZE = (800, 600)

    pygame.init()
    screen = pygame.display.set_mode(SCREEN_SIZE, 0, 32)

    tank = pygame.image.load('tanque.jpg').convert()

    x, y = 0, 0
    move_x, move_y = 0, 0

    while True:
        for event in pygame.event.get():
            match event.type:
                case pg.QUIT:
                    pygame.quit()
                    exit(0)

                case pg.KEYDOWN:
                    match event.key:
                        case pg.K_LEFT:
                            move_x = -1

                        case pg.K_RIGHT:
                            move_x = 1

                        case pg.K_DOWN:
                            move_y = 1

                        case pg.K_UP:
                            move_y = -1

                        case _:
                            pass

                case pg.KEYUP:
                    if event.key in [pg.K_LEFT, pg.K_RIGHT]:
                        move_x = 0

                    elif event.key in [pg.K_UP, pg.K_DOWN]:
                        move_y = 0

                case _:
                    pass

            x += move_x
            y += move_y
            x, y = abs(x%SCREEN_SIZE[0]), abs(y%SCREEN_SIZE[1])

            screen.fill((255, 255, 255))
            screen.blit(tank, (x, y))

            pygame.display.update()


if __name__ == '__main__':
    main()
