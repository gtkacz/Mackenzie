#!/usr/bin/bash
# ========================================
#
# Arquivo: ex4
#
# Autor: Gabriel Tkacz
#
# ========================================
clear
echo "Exercício 4"
echo "======================"
echo "Insira o nome que deseja checar: "
read nome

if [ -d $nome ];
then
    echo $nome "é um diretorio"
    
fi
if [ -f $nome ];
then
    echo $nome "é um arquivo"
fi