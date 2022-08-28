#!/usr/bin/bash 
# ========================================
# 
# Arquivo: ex2
#
# Autor: Gabriel Tkacz
#
# ========================================	
clear
echo "Exercício 2"
echo "======================"
echo "Insira seu nome: "
read nome
echo "Insira o valor de x: "
read xvar
echo ""
echo "`expr $nome`, com o valor de x = `expr $xvar` a função y = 3x - 1 retorna o valor de `expr $xvar * 3`"