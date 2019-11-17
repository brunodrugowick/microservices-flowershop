package dev.drugowick.microservice.flowersupplier.repository;

import org.springframework.data.repository.CrudRepository;

import dev.drugowick.microservice.flowersupplier.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
