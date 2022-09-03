#!/usr/bin/bash
# ========================================
#
# Arquivo: ex6
#
# Autor: Gabriel Tkacz
#
# ========================================
clear
echo "Exercício 6"
echo "======================"
echo "Insira o valor inicial do intervalo: "
read inicio
echo "Insira o valor final do intervalo: "
read fim
target=$(($fim+1))
sum=0
interval="[$inicio, $fim]"

while [ $inicio != $target ]; do
    sum=`expr $sum + $inicio`
    inicio=`expr $inicio + 1`
done
echo "A soma do intervalo $interval é" $sum