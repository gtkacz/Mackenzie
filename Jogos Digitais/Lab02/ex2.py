from os import _exit as exit

import pygame
import pygame.locals as pg


def main():
    SCREEN_SIZE = (800, 600)

    pygame.init()
    screen = pygame.display.set_mode(SCREEN_SIZE, 0, 32)

    tank = pygame.image.load('tanque.jpg').convert()

    x, y = 0, 0

    while True:
        for event in pygame.event.get():
            match event.type:
                case pg.QUIT:
                    pygame.quit()
                    exit(0)

                case pg.MOUSEMOTION:
                    x, y = pygame.mouse.get_pos()

                case _:
                    pass

            x, y = abs(x%SCREEN_SIZE[0]), abs(y%SCREEN_SIZE[1])

            screen.fill((255, 255, 255))
            screen.blit(tank, (x, y))

            pygame.display.update()


if __name__ == '__main__':
    main()
