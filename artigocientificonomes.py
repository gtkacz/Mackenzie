from pyperclip import copy

def main():
    names = (
        ('Matheus Henrique de Oliveira Santos', '42251419'),
        ('Gabriel Sanches Tofanello', '42251631'),
        ('Gabriel Mitelman Tkacz', '42230446'),
        ('Cleide Lustosa', '42218772'),
        ('João Pedro Fragoso', '42251419'),
        ('Pedro Mastandrea', '42204933'),
        ('Vitor Sampaio', '32249497'),
        ('Tales Hernandes', '42202639'),
        ('Felipe Lessa Trolli', '42223547'),
        # ('', ''),
    )

    output = ''
    names = sorted(names, key=lambda x: x[0])

    for index, (name, _) in enumerate(names):
        output += f'{name.title()}{index+1}, '

    output += '\n'
    
    for index, (_, tia) in enumerate(names):
        output += f'{tia}@mackenzista.com.br{index+1}, '

    copy(output)

if __name__ == '__main__':
    main()