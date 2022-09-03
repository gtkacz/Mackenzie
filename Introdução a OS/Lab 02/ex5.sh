#!/usr/bin/bash
# ========================================
#
# Arquivo: ex5
#
# Autor: Gabriel Tkacz
#
# ========================================
clear
echo "Exercício 5"
echo "======================"
echo "Insira o nome que deseja checar: "
read nome

if [ -d $nome ];
then
    echo $nome "é um diretorio com o seguinte conteúdo:"
    ls -la $nome
    
fi
if [ -f $nome ];
then
    echo $nome "é um arquivo com o seguinte conteúdo:"
    cat $nome
fi