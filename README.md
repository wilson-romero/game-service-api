# Game  Service API

## Description

The Game Service API is a RESTful application developed in Java using Spring Boot. It provides a comprehensive CRUD (Create, Read, Update, Delete) functionality for managing game records, which are stored in a PostgreSQL database.

## Requirements

- Java 17 or higher
- Maven 3.3.1 or higher
- Docker and Docker Compose (optional)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/wilson-romero/game-service-api.git
```

2. Navigate to the project directory:

```bash
cd game-service-api
```

3. Change the database configuration in the `application.yaml` file:

```properties
spring:
    datasource:
    url: jdbc:postgresql://localhost:5432/game-db
    username: user
    password: insecure-password
    driver-class-name: org.postgresql.Driver
```

4. Start services using Docker Compose (optional):

```bash
docker compose up -d
```

5. Change permissions for the `mvnw` file:

```bash
chmod +x mvnw
```

6. Compile and run the application using Maven:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

7. The application will be available at `http://localhost:8080`.


## API Endpoints Documentation

The API documentation is available at `http://localhost:8080/swagger-ui/index.html`.


## License

This project is licensed under the MIT License .
```