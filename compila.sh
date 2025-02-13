#!/bin/bash
set -e

clear
echo "###############################################################"
echo "### 1. Docker compose DOWN"
sudo docker compose down --volumes
sleep 1

echo "###############################################################"
echo "### 2. Compilar"
clear;mvn clean install -DskipTests
sleep 1

echo "###############################################################"
echo "### 3 Docker build da imagem"
sudo docker build -t kbroker:0.0.1 .
sleep 1

echo "###############################################################"
echo "### 4. Docker compose UP"
sudo docker compose up --build