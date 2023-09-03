from random import uniform as randfloat

import pygame
from pygame.math import Vector2


def main():
    WIDTH, HEIGHT, FPS = 800, 600, 60

    pygame.init()

    pygame.mixer.init()

    screen = pygame.display.set_mode((WIDTH, HEIGHT))
    pygame.display.set_caption('Jogos Digitais - Lab04')

    background = pygame.transform.scale(pygame.image.load('mar.jpeg'), (WIDTH, HEIGHT))
    background_music = pygame.mixer.Sound('underwater-movement-66914.mp3')
    background_music.play(-1)

    sprite_1 = pygame.transform.flip(pygame.image.load('peixe.png'), True, False)
    position_1 = Vector2(WIDTH // 2, HEIGHT // 2.5)
    velocity_1 = Vector2(randfloat(-2, -5), 0)

    sprite_2 = pygame.image.load('peixe.png')
    position_2 = Vector2(WIDTH // 2, HEIGHT // 1.5)
    velocity_2 = Vector2(randfloat(2, 5), 0)

    sprite_3 = pygame.image.load('peixe.png')
    position_3 = Vector2(WIDTH // 2, HEIGHT // 4.5)
    velocity_3 = Vector2(randfloat(2, 5), 0)

    clock = pygame.time.Clock()

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                raise SystemExit

        position_1 += velocity_1
        position_1.x %= WIDTH
        position_1.y %= HEIGHT

        position_2 += velocity_2
        position_2.x %= WIDTH
        position_2.y %= HEIGHT

        position_3 += velocity_3
        position_3.x %= WIDTH
        position_3.y %= HEIGHT

        screen.blit(background, (0, 0))
        screen.blit(sprite_1, position_1)
        screen.blit(sprite_2, position_2)
        screen.blit(sprite_3, position_3)

        pygame.display.flip()

        clock.tick(FPS)


if __name__ == '__main__':
    main()
