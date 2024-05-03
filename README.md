# Reservation Service
This service lists restaurants and checks reservation availability

## Installation
To install run
`mvn clean install`

## Run
To run the service, with 3 instances for load balancing, launch
`export SERVER_PORT=9091;mvn spring-boot:run`
`export SERVER_PORT=9092;mvn spring-boot:run`
`export SERVER_PORT=9999;mvn spring-boot:run`

