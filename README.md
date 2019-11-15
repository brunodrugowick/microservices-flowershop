# Flower Store

This project is based on an Alura course on Microservices with Spring Cloud.

## Components

- Store Front (the Store itself, like a website where a user buys flowers and stuff). `storefront` folder.
- Supplier (someone who provides products on different locations). `supplier` folder.
- Carrier (someone who delivers stuff to clients from the suppliers). `carrier` folder.
- Eureka server (handles service registry, discovery and routing (?)). `eureka-server` folder.

## Running

Run each of them separately using `./mvnw spring-boot:run` on each folder.

## Domain

![Domain](README/domain.png)

## Endpoints and Services

![Endpoints and Services V1](README/endpoints.png)
