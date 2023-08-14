from __future__ import annotations

from random import randint, choice as randchoice, shuffle


class Tank:
    def __init__(self, name: str):
        self.name = name
        self.alive = True
        self.ammo = 5
        self.armor = 60

    def __str__(self):
        if self.alive:
            return "%s (%i armor, %i shells)" % (self.name, self.armor, self.ammo)
        else:
            return "%s (DEAD)" % self.name

    def explode(self):
        self.alive = False
        print(self.name, "explodes!")

    def hit(self):
        self.armor -= 20
        print(self.name, "is hit!")

        if self.armor <= 0:
            self.explode()

    def fire_at(self, enemy: Tank):
        if self.ammo >= 1:
            self.ammo -= 1
            print(self.name, "fires on", enemy.name)
            enemy.hit()

        else:
            print(self.name, "has no shells!")


def main():
    exercise_number = int(input('Which exercise do you want to run? '))
    
    if exercise_number == 1:
        tanks = [Tank('Leopard'), Tank('Abrams'), Tank('T-34'), Tank('Sherman'), Tank('Panther')]

        while len(tanks) > 1:
            shooter = randint(0, len(tanks) - 1)
            target = randchoice(list(range(0, shooter)) + list(range(shooter + 1, len(tanks))))

            tanks[shooter].fire_at(tanks[target])

            if not tanks[target].alive:
                tanks.remove(tanks[target])

        print(tanks[0], 'wins the battle!')

    
    elif exercise_number == 2:
        num_tanks = int(input('How many tanks? '))

        if num_tanks < 2:
            print('There must be at least 2 tanks.')
            num_tanks = 2

        elif num_tanks > 10:
            print('There must be at most 10 tanks.')
            num_tanks = 10

        tanks = {}

        for i in range(ord('a'), ord('a')+num_tanks):
            tank_name = input(f'Name of tank #{i-ord("a")+1}: ')
            tanks[chr(i)] = Tank(tank_name)

        while len(tanks) > 1:
            play_order = list(tanks.keys())
            shuffle(play_order)
            print('\nPlay order for this round: ', *play_order)

            for shooter in play_order:
                if not tanks[shooter].alive:
                    continue

                if len(tanks) == 1:
                    break

                print(f'\nWho should {tanks[shooter]} fire at?')
                print(*list(f'{key}: {tanks[key].name},' for key in tanks.keys() if key != shooter and tanks[key].alive), end=' ')
                target = input().lower().strip()

                if target not in tanks.keys():
                    target = input(f'Invalid target. Who should {tanks[shooter]} fire at? ').lower().strip()

                tanks[shooter].fire_at(tanks[target])

                if not tanks[target].alive:
                    tanks.pop(target)
                    play_order.remove(target)

            print('\nCurrent status:')
            for tank in tanks.values():
                print(tank)

        print(f'\n\n{tanks[play_order[0]]} wins the battle!')

    else:
        print('Invalid exercise number.')


if __name__ == '__main__':
    main()
