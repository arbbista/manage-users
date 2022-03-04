# 
# Copyright (C) 2022. Smart Bits GmbH. All rights reserved.
# Created by Arbër Pllana on 03/03/2022.
#

docker network create ucx
docker volume create --name=postgres
docker volume create --name=postgres-data

# chmod 777 .docker-conf

docker-compose up -d