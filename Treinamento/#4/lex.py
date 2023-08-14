# -*- coding: utf-8 -*-

'''
Escreva a sua solução aqui
Code your solution here
Escriba su solución aquí
'''

prioridades = {
    '^': 6,
    '*': 5,
    '/': 5,
    '+': 4,
    '-': 4,
    '>': 3,
    '<': 3,
    '=': 3,
    '#': 3,
    '.': 2,
    '|': 1
}


def eh_operador(caractere):
    return caractere in prioridades.keys()


def eh_operando(caractere):
    return caractere.isalnum()


def avaliar_expressao(expressao):
    pilha = []
    posfixa = []
    for caractere in expressao:
        if eh_operando(caractere):
            posfixa.append(caractere)
        elif eh_operador(caractere):
            while len(pilha) > 0 and pilha[-1] != '(' and prioridades[caractere] <= prioridades[pilha[-1]]:
                posfixa.append(pilha.pop())
            pilha.append(caractere)
        elif caractere == '(':
            pilha.append(caractere)
        elif caractere == ')':
            while pilha[-1] != '(':
                posfixa.append(pilha.pop())
            pilha.pop()
        else:
            return "Lexical Error!"
    while len(pilha) > 0:
        if pilha[-1] == '(' or pilha[-1] == ')':
            return "Syntax Error!"
        posfixa.append(pilha.pop())
    return "".join(posfixa)


def main():
    while True:
        try:
            expressao = input()
        except:
            break
        resultado = avaliar_expressao(expressao)
        print(resultado)


main()
