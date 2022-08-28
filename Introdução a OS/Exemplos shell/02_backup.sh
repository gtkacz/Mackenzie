#!/usr/bin/bash 
# ========================================
# 
# Arquivo: 02_backup.sh
#
# Objetivo: copia da area home do usuario
#
# Autor: Jamilson Bispo
#
# Implantado: 13/02/2022
#
# Ultima alteração: 13/02/2022
#
# ========================================	
cd /home/aluno/Backup
nome='backup_'
data=$(date '+%Y-%m-%d_%H-%M-%S')
nome=$nome$data.tar.gz
tar -cvf $nome /home/aluno/Scripts
