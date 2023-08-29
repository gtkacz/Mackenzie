from random import randrange

import pygame

WIDTH = 800
HEIGHT = 600
BG_COLOR = (255, 255, 255)
N_SQUARES = 6
COLORS = [(randrange(0, 255), randrange(0, 255), randrange(0, 255)) for _ in range(N_SQUARES)]

LERP_FACTOR = 0.05

def lerp_color(color1: tuple[int, int, int], color2: tuple[int, int, int], factor: float = LERP_FACTOR) -> tuple[int, int, int]:
    r = int(color1[0] + (color2[0] - color1[0]) * factor)
    g = int(color1[1] + (color2[1] - color1[1]) * factor)
    b = int(color1[2] + (color2[2] - color1[2]) * factor)

    return r, g, b


def main():
    pygame.init()
    screen = pygame.display.set_mode((WIDTH, HEIGHT))
    pygame.display.set_caption("Jogos Digitais - Lab03")

    interpolated_colors = COLORS.copy()
    rectangles = [pygame.Rect(i * WIDTH // N_SQUARES, 0, WIDTH // N_SQUARES, HEIGHT) for i in range(N_SQUARES)]

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                raise SystemExit

        screen.fill(BG_COLOR)

        mouse_x, mouse_y = pygame.mouse.get_pos()

        for i, rect in enumerate(rectangles):
            if rect.collidepoint(mouse_x, mouse_y):
                interpolated_colors[i] = lerp_color(interpolated_colors[i], COLORS[i])

            else:
                interpolated_colors[i] = lerp_color(interpolated_colors[i], BG_COLOR)

            pygame.draw.rect(screen, interpolated_colors[i], rect)

        pygame.display.flip()
        pygame.time.Clock().tick(60)


if __name__ == '__main__':
    main()
