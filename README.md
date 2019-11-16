# Flower Store

This project is based on an Alura course on Microservices with Spring Cloud.

## Components

### Store Front 

`storefront` folder. 
The Store itself, like a website where a user buys flowers and stuff.

### Supplier 

`supplier` folder.
Someone who provides products on different locations.

### Carrier 

`carrier` folder.
Someone who delivers stuff to clients from the suppliers.

### Eureka server 

`eureka-server` folder.
Handles service registry and discovery.
Balancing is on the client-side, via a RestTemplate bean configured to user Eureka client.

### Config Server 

`config-server` folder.
Provides configuration for the microservices.  The `config-repo` folder is used to store the configuration files.

## Running

Run each of them separately using `./mvnw spring-boot:run` on each folder.

## Domain

![Domain](README/domain.png)

## Endpoints and Services

![Endpoints and Services V1](README/endpoints.png)
