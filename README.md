## What You Will build

This is a simple Java project made  spring boot framework and uses postgreSQL and RabbitMQ which are built in & runs on docker environment.

## Building application

### Pre-requisites
- docker CLI

### Step 1: Building Executable JAR and docker image
To create an `executable jar`  of the project also to build `image on docker`, simply run the command:

```sh
./deploy/init-setup.sh
```

### Step 2: Building docker network and volumes
To create the network on docker, needed volumes for services and to initialize the creation of all needed services for the project, simply run the command:

```sh
./deploy/build-image.sh
```

## Application & Routing

Now, that we built the images and services are running on our machine, we can explore how services are behaving.

#### Spring boot service url

```
http://localhost:8080
```

#### RabbitMQ Management UI url

```
http://localhost:15672
```

Use the following credentials for login:

```
Username: guest
Password: guest
```

#### PgAdmin4 panel url

```
http://localhost:8854
```

Use the following credentials for login:

```
Username: arbbista@gmail.com
Password: rnEO0tOCjiMy2h34
```

#### PostgreSQL credentials

```
Username: postgres
Password: 123456
```

#### API documentation url

```
http://localhost:8080/docs
```