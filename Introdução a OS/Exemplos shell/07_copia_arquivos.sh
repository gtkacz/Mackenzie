#!/usr/bin/bash 
# ========================================
# 
# Arquivo: 07_copia_arquivos
#
# Objetivo: copiar arquivos a partir de informações passadas via parametro
#
# Autor: Jamilson Bispo
#
# Implantado: 15/02/2022
#
# Ultima alteração: 15/02/2022
#
echo "$1"
echo "$2"

if [ ! -d "$1" ]; then
echo "Entre com um diretório de entrada válido !"
exit
fi

if [ ! -d "$2" ]; then
echo "Entre com um diretório de saida válido !"
exit
fi

path_src=$1
path_dst=$2

date=$(date +"%m%d%y")
for file_src in $path_src/*; do
  file_dst="$path_dst/$(basename $file_src | \
    sed "s/^\(.*\)\.\(.*\)/\1$date.\2/")"
  cp "$file_src" "$file_dst"
  echo cp "$file_src" "$file_dst"
done
