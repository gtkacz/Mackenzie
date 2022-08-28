#!/usr/bin/bash 
# ========================================
# 
# Arquivo: 06_monitora_disco
#
# Objetivo: monitorar espaço disponivel em disco
#
# Autor: Jamilson Bispo
#
# Implantado: 15/02/2022
#
# Ultima alteração: 15/02/2022
#
# ========================================	
clear
df -H | grep -vE '^Filesystem|tmpfs|cdrom|loop|Disp' | awk '{ print $5 " " $1 }' | while read output;
do
  echo $output
  usep=$(echo $output | awk '{ print $1}' | cut -d'%' -f1  )
  partition=$(echo $output | awk '{ print $2 }' )
  if [ $usep -ge 50 ]; then
    echo "Ficando sem espaço em disco \"$partition ($usep%)\" on $(hostname) as on $(date)" 
  fi
done
