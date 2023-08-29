from random import randrange

import pygame


def gera_cor():
    red = randrange(0, 255)
    green = randrange(0, 255)
    blue = randrange(0, 255)

    return red, green, blue


def retangulo(screen):
    altura = randrange(0, 70)
    largura = randrange(0, 70)
    pos_x = randrange(0, 600)
    pos_y = randrange(0, 600)

    return pygame.draw.rect(screen, gera_cor(), (pos_x, pos_y, altura, largura))


def circulo(screen):
    raio = randrange(0, 100)
    pos_x = randrange(0, 600)
    pos_y = randrange(0, 600)

    return pygame.draw.circle(screen, gera_cor(), (pos_x, pos_y), raio)


def main():
    pygame.init()
    screen = pygame.display.set_mode((640, 480))

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                raise SystemExit

        retangulo(screen)
        circulo(screen)

        pygame.display.update()


if __name__ == '__main__':
    main()
