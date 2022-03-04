# 
# Copyright (C) 2022. Smart Bits GmbH. All rights reserved.
# Created by Arbër Pllana on 03/03/2022.
#

cd "$(dirname "$0")"

cd ../UsersManager

./gradlew clean build -x test

docker build -t manageusers .