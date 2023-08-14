# -*- coding: utf-8 -*-

'''
Escreva a sua solução aqui
Code your solution here
Escriba su solución aquí
'''
while True:
    n, k = map(int, input().split())
    if n == 0 and k == 0:
        break

    stack = []
    possible = True

    for i in range(n):
        try:
            c, s = map(int, input().split())

        except EOFError:
            possible = False
            break

        while stack and stack[-1] <= c:
            stack.pop()

        if len(stack) == k:
            if stack[0] > s:
                possible = False
                break
            else:
                stack.pop(0)

        stack.append(s)

    if possible:
        print("Sim")
    else:
        print("Nao")
