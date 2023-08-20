from math import atan2, degrees
from os import _exit as exit

import pygame
import pygame.locals as pg


def __get_rotation_angle(p1: tuple[int, int], p2: tuple[int, int]) -> float:
    x_diff = p2[0] - p1[0]
    y_diff = p2[1] - p1[1]

    return degrees(-atan2(y_diff, x_diff))


def main():
    SCREEN_SIZE = (800, 600)

    pygame.init()
    screen = pygame.display.set_mode(SCREEN_SIZE, 0, 32)

    tank = pygame.image.load('tanque.jpg').convert()
    rot_tank = tank

    x, y = 0, 0

    while True:
        for event in pygame.event.get():
            match event.type:
                case pg.QUIT:
                    pygame.quit()
                    exit(0)

                case pg.MOUSEMOTION:
                    _x, _y = x, y
                    x, y = pygame.mouse.get_pos()
                    rot_tank = pygame.transform.rotate(tank, __get_rotation_angle((x, y), (_x, _y)))

                case _:
                    pass

            x, y = abs(x % SCREEN_SIZE[0]), abs(y % SCREEN_SIZE[1])

            screen.fill((255, 255, 255))
            screen.blit(rot_tank, rot_tank.get_rect(center=(x, y)))

            pygame.display.update()


if __name__ == '__main__':
    main()
