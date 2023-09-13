import pygame

def main():
    FPS = 30
    SCREEN_SIZE = (400, 300)
    BG_COLOR = (255, 255, 255)
    VELOCITY = 5

    pygame.init()
    pygame.display.set_caption('Jogos Digitais - Lab05')
    display = pygame.display.set_mode(SCREEN_SIZE)

    fpsClock = pygame.time.Clock()
    catImg = pygame.image.load('gato.png')

    catx = caty = 10
    direction = 'right'

    while True:
        display.fill(BG_COLOR)

        match direction:
            case 'right':
                catx += VELOCITY
                if catx == round(SCREEN_SIZE[0] * 0.7):
                    direction = 'down'

            case 'down':
                caty += VELOCITY
                if caty == round(SCREEN_SIZE[1] * 0.7333333333333333):
                    direction = 'left'

            case 'left':
                catx -= VELOCITY
                if catx == round(SCREEN_SIZE[0] * 0.025):
                    direction = 'up'

            case 'up':
                caty -= VELOCITY
                if caty == round(SCREEN_SIZE[1] * 0.03333333333333333):
                    direction = 'right'
        
        display.blit(catImg, (catx, caty))

        for event in pygame.event.get():
            match event.type:
                case pygame.QUIT:
                    pygame.quit()
                    raise SystemExit
            
                case pygame.KEYDOWN:
                    match event.key:
                        case pygame.K_d:
                            catImg = pygame.transform.rotate(catImg, -90)

                        case pygame.K_e:
                            catImg = pygame.transform.rotate(catImg, 90)
        
        pygame.display.update()
        fpsClock.tick(FPS)

if __name__ == "__main__":
    main()