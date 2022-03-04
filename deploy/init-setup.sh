# 
# Copyright (C) 2022. Smart Bits GmbH. All rights reserved.
# Created by Arbër Pllana on 03/03/2022.
#

docker network create ucx
docker volume create --name=postgres
docker volume create --name=postgres-data

mkdir /.docker-conf/rabbitmq/data/
mkdir /.docker-conf/rabbitmq/log/
sudo chmod 666 .docker-conf

docker-compose up -d