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
resultado=$((y=3*$xvar-1))
echo "$nome, com o valor de x = $xvar a função y = 3x - 1 retorna o valor de $resultado"