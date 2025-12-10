# docker-spring-boot-demo


# Spring Boot Docker Demo

A simple Spring Boot application running with MySQL in Docker containers.

## Technologies
- Java 21
- Spring Boot 3.5.8
- MySQL 8.0
- Docker

## Quick Start

### 1. Create Network
```bash
docker network create java-mysql-app-network
```

### 2. Run MySQL
```bash
docker run -d \
  --name mysql-container \
  --network java-mysql-app-network \
  -p 3306:3306 \
  -e MYSQL_ROOT_PASSWORD=P@ssw0rd \
  -e MYSQL_DATABASE=java_app_db \
  mysql:latest
```

### 3. Build & Run Application
```bash
mvn clean package
docker build -t java-web-app:1.0 .
docker run -d \
  --name java-app \
  --network java-mysql-app-network \
  -p 8080:8080 \
  java-web-app:1.0
```

### 4. Access
```
http://localhost:8080
```

## Useful Commands

**View logs:**
```bash
docker logs java-app
```

**Stop & remove:**
```bash
docker stop java-app mysql-container
docker rm java-app mysql-container
