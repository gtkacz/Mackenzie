from dataclasses import dataclass
from math import sqrt
from random import choice, randint
from typing import NoReturn

import pygame


@dataclass
class Point:
    x: int
    y: int


@dataclass
class Asteroid(Point):
    radius: float
    size: str
    is_alive: bool = True
    velocity_x: int = 0
    velocity_y: int = 0

    def __str__(self) -> str:
        return f'Asteroide(x={self.x}, y={self.y}, radius={self.radius})'


def point_distance(p1: Point, p2: Point) -> float:
    return sqrt(((p1.x - p2.x) ** 2) + ((p1.y - p2.y) ** 2))


def asteroid_collision(a1: Asteroid, a2: Asteroid) -> bool:
    return point_distance(a1, a2) <= a1.radius + a2.radius


def main() -> NoReturn:
    BG_COLOR = (255, 255, 255)
    SCREEN_SIZE = (600, 400)
    FPS = 30

    asteroid_map = {'small': {'radius': randint(5, 10), 'color': (255, 0, 0)}, 'medium': {'radius': randint(10, 20), 'color': (0, 255, 0)}, 'large': {'radius': randint(20, 30), 'color': (0, 0, 255)}}

    asteroids: list[Asteroid] = []

    for _ in range(10):
        curr_size = choice(list(asteroid_map.keys()))
        asteroids.append(Asteroid(randint(0, SCREEN_SIZE[0]-asteroid_map[curr_size]['radius']), randint(0, SCREEN_SIZE[1]-asteroid_map[curr_size]['radius']), asteroid_map[curr_size]['radius'], curr_size, True, randint(-5, 5), randint(-5, 5)))

    pygame.init()

    screen = pygame.display.set_mode(SCREEN_SIZE)
    clock = pygame.time.Clock()

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                raise SystemExit

        screen.fill(BG_COLOR)

        for asteroid in asteroids:
            if asteroid.is_alive:
                color = asteroid_map[asteroid.size]['color']
                pygame.draw.circle(screen, color, (int(asteroid.x), int(asteroid.y)), asteroid.radius, 1)

                asteroid.x += asteroid.velocity_x
                asteroid.y += asteroid.velocity_y

                if asteroid.x + asteroid.radius >= SCREEN_SIZE[0] or asteroid.x - asteroid.radius <= 0:
                    asteroid.velocity_x *= -1

                if asteroid.y + asteroid.radius >= SCREEN_SIZE[1] or asteroid.y - asteroid.radius <= 0:
                    asteroid.velocity_y *= -1

            else:
                pygame.draw.circle(screen, (0, 0, 0), (int(asteroid.x), int(asteroid.y)), asteroid.radius, 1)

        for i in range(len(asteroids)):
            for j in range(i + 1, len(asteroids)):
                if (asteroids[i].is_alive or asteroids[j].is_alive) and asteroid_collision(asteroids[i], asteroids[j]):
                    print(f'Colisão entre {asteroids[i]} e {asteroids[j]}!')
                    asteroids[i].is_alive = False
                    asteroids[j].is_alive = False

        if all(not asteroid.is_alive for asteroid in asteroids):
            print('Todos os asteroides foram destruídos!')
            pygame.quit()
            raise SystemExit

        pygame.display.flip()
        clock.tick(FPS)


if __name__ == '__main__':
    main()
