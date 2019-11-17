package dev.drugowick.microservice.flowersupplier.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.drugowick.microservice.flowersupplier.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByProvince(String province);
	
	List<Product> findByIdIn(List<Long> ids);
	
}
