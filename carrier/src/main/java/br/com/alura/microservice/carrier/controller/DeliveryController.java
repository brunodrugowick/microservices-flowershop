package br.com.alura.microservice.carrier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.carrier.dto.DeliveryDto;
import br.com.alura.microservice.carrier.dto.VoucherDTO;
import br.com.alura.microservice.carrier.model.Delivery;
import br.com.alura.microservice.carrier.service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	
	@Autowired
	private DeliveryService deliveryService;

	@RequestMapping(method = RequestMethod.POST)
	public VoucherDTO scheduleDelivery(@RequestBody DeliveryDto pedidoDTO) {
		return deliveryService.scheduleDelivery(pedidoDTO);
	}
}
