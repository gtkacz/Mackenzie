#!/usr/bin/bash 
# ========================================
# 
# Arquivo: 03_info.sh
#
# Objetivo: informacoes do ambiente
#
# Autor: Jamilson Bispo
#
# Implantado: 13/02/2022
#
# Ultima alteração: 13/02/2022
#
# ========================================	
clear
echo "Informaçoes do usuario"
echo "======================"
echo "Data $(date '+%d/%m/%Y Hora %H:%M:%S')"
echo "Usuario: $USER"
echo "Home   : $HOME"
echo "Host   : $HOSTNAME"
echo "Sessao : $TERM"

