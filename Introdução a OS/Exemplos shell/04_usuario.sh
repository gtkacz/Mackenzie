#!/usr/bin/bash 
# ========================================
# 
# Arquivo: 04_usuario
#
# Objetivo: informacoes do usuario
#
# Autor: Jamilson Bispo
#
# Implantado: 15/02/2022
#
# Ultima alteração: 15/02/2022
#
# ========================================	
clear
echo "Informaçoes do usuario"
echo "======================"
echo "Data $(date '+%d/%m/%Y Hora %H:%M:%S')"
echo "Informe o nome: "
read nome
echo "Informe o curso: "
read curso
echo "Informe sua idade: "
read idade
echo ""
echo "Seu nome é $nome e voce esta fazendo o curso $curso"
echo "O ano que vem voce tera `expr $idade + 1` anos "
echo ""

