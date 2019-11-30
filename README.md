# Flower Store

This project is based on an Alura course on Microservices with Spring Cloud.

## Requirements to develop

- You must configure the config-server `application.yml` file with at least the `search-locations` property. You may change to the location of your own config repo on your local machine or use the commented configuration to use a github repository.
- A MariaDB instance running with the following schemas already created:
  - supplier
  - storefront
  - Note: you can configure the database, connection info and schema name on the configuration files on the config-server.

## Test Stuff

- There's a [cartRequests.jmx](README/cartRequests.jmx) to be imported on JMeter and test Hystrix.
- There's a [insomnia_requests.json](README/insomnia_requests.json) to be imported on Insomnia and test all endpoints.

## Components

### Store Front 

`storefront` folder. 

- The Store itself, like a website where a user buys flowers and stuff.
- Balances the requests to suppliers and carriers locally (client-side load-balancing) by fetching and caching Eureka server information (ribbon).
- Uses Hystrix to control timeout on methods that use other microservices.
- Uses Bulkhead (from Hystrix) to separate a group of threads for each operation managed by Hystrix.

### Supplier 

`supplier` folder.

- Someone who provides products on different locations.

### Carrier 

`carrier` folder.

- Someone who delivers stuff to clients from the suppliers.

### Eureka server 

`eureka-server` folder.

- Handles service registry and discovery.
- Balancing is on the client-side, via a RestTemplate bean configured to use Eureka server as a client.

### Config Server 

`config-server` folder.

- Provides configuration for the microservices.  The `config-repo` folder is used to store the configuration files.

### Other Stuff

- I've configured to log to papertrail (a log aggregator as a service) and used Spring Cloud Sleuth to add a traceId to every user request, being able to trace  the request across microservices.

## Running

- Run each of them separately using `./mvnw spring-boot:run` on each folder.

## Domain

![Domain](README/domain.png)

## Endpoints and Services

![Endpoints and Services V1](README/endpoints.png)
