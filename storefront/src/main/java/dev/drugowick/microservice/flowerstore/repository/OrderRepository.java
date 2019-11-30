package dev.drugowick.microservice.flowerstore.repository;

import org.springframework.data.repository.CrudRepository;

import dev.drugowick.microservice.flowerstore.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
