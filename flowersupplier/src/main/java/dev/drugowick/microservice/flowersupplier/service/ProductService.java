package dev.drugowick.microservice.flowersupplier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.drugowick.microservice.flowersupplier.model.Product;
import dev.drugowick.microservice.flowersupplier.repository.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	public List<Product> getProductByProvince(String province) {
		return productRepository.findByProvince(province);
	}

}
