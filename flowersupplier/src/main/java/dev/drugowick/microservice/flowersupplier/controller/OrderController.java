package dev.drugowick.microservice.flowersupplier.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.drugowick.microservice.flowersupplier.dto.OrderItemDTO;
import dev.drugowick.microservice.flowersupplier.model.Order;
import dev.drugowick.microservice.flowersupplier.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Order makeOrder(@RequestBody List<OrderItemDTO> products) {
		return orderService.makeOrder(products);
	}
	
	@RequestMapping("/{id}")
	public Order getOrderById(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}
	
}
