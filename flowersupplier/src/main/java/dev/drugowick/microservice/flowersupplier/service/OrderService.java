package dev.drugowick.microservice.flowersupplier.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.drugowick.microservice.flowersupplier.dto.OrderItemDTO;
import dev.drugowick.microservice.flowersupplier.model.Order;
import dev.drugowick.microservice.flowersupplier.model.OrderItem;
import dev.drugowick.microservice.flowersupplier.model.Product;
import dev.drugowick.microservice.flowersupplier.repository.OrderRepository;
import dev.drugowick.microservice.flowersupplier.repository.ProductRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	private ProductRepository productRepository;
	
	public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
	}
	
	public Order makeOrder(List<OrderItemDTO> items) {
		
		if (items == null) {
			return null;
		}
		
		List<OrderItem> orderItems = toOrderItem(items);
		Order order = new Order(orderItems);
		order.setFulfillmentTime(items.size());
		return orderRepository.save(order);
	}
	
	public Order getOrderById(Long id) {
		return orderRepository.findById(id).orElse(new Order());
	}

	/**
	 * This is a DTO do Domain converter
	 * 
	 * @param items
	 * @return the list of {@link OrderItem}.
	 */
	private List<OrderItem> toOrderItem(List<OrderItemDTO> items) {
		
		List<Long> productIds = items
				.stream()
				.map(item -> item.getId())
				.collect(Collectors.toList());
		
		List<Product> orderProducts = productRepository.findByIdIn(productIds);
		
		List<OrderItem> orderItems = items
				.stream()
				.map(item -> {
					Product product = orderProducts
							.stream()
							.filter(p -> p.getId() == item.getId())
							.findFirst().get();
					
					OrderItem orderItem = new OrderItem();
					orderItem.setProduct(product);
					orderItem.setAmount(item.getAmount());
					return orderItem;
				})
				.collect(Collectors.toList());
		return orderItems;
	}
	
}
