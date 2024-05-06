# Reservation Service
This service lists restaurants and checks reservation availability

## Components
This service uses:
- Java 21
- Maven
- Spring Boot
    - Starter web
    - Starter JPA
    - Starter WebFlux
    - Starter Cloud LoadBalancer
    - Starter Test
- H2 Database
- Liquibase
- OpenApi

## Installation
To install run
`mvn clean install`

## Run
To run the service, with 3 instances for load balancing, launch

`./run-load-balancer.sh 9091`

`./run-load-balancer.sh 9092`

`./run-load-balancer.sh 9999`

or :

`export SERVER_PORT=9091;mvn spring-boot:run`

`export SERVER_PORT=9092;mvn spring-boot:run`

`export SERVER_PORT=9999;mvn spring-boot:run`

each command must be launched in its own console.

## Swagger
The Swagger page for his service is reachable at
http://localhost:9091/swagger-ui/index.html
