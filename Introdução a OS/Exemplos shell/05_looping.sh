#!/usr/bin/bash 
# ========================================
# 
# Arquivo: 05_looping
#
# Objetivo: listar informacoes de um array com looping
#
# Autor: Jamilson Bispo
#
# Implantado: 15/02/2022
#
# Ultima alteração: 15/02/2022
#
# ========================================	
clear
MAQUINAS=("MACK01" "MACK02" "MACK03" "MACK04" "MACK05")
CONTADOR=0
for INDEX in ${MAQUINAS[@]}; do
    echo "Maquina: ${MAQUINAS[CONTADOR]}"
    CONTADOR="`expr $CONTADOR + 1`"
done
