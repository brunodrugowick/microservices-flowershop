package dev.drugowick.microservice.flowersupplier.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.drugowick.microservice.flowersupplier.model.Product;
import dev.drugowick.microservice.flowersupplier.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/{province}")
	public List<Product> getProductByProvince (@PathVariable String province) {
		return productService.getProductByProvince(province);
	}
	
}
