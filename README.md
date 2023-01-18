# Job List Test API

This is a simple API for getting job using spring-boot.

Tested on :

- openjdk 17.0.5 2022-10-18 LTS

- 10.4.24-MariaDB

## How to Install

1. Create database then import db-example.sql file to the MySQL database server.

2. Configure application.yml file at src/main/resources directory or you can configure these environment variables :

| Name       | Description       | Default          |
| ---------- | ----------------- |------------------|
| DB_HOST    | Database Host     | localhost        |
| DB_PORT    | Database Port     | 3306             |
| DB_NAME    | Database Name     | dmp              |
| DB_USER    | Database User     | root             |
| DB_PASS    | Database Password | -                |


3. Run the application (development).

```bash
mvnw spring-boot:run
```

Open the swagger docs at this URL for a list of available API endpoints. To get an authorization token, use register API then login,
or if you import db-example.sql you can use these login credential user: ilham and password: ilham12345

```bash
http://localhost:8080/swagger-ui/index.html
```

3. Debugging : Configure your IDE to debug the main class (DmpApplication.java).

## How to build

1. Build project.

```bash
mvnw clean install
```

2. Run the application after build finished.

```bash
java -jar target/dmp-1.0.0.jar
```

## TODO

- Unit Testing
