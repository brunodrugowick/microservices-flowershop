package dev.drugowick.microservice.carrier.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.drugowick.microservice.carrier.dto.DeliveryDto;
import dev.drugowick.microservice.carrier.dto.VoucherDTO;
import dev.drugowick.microservice.carrier.service.DeliveryService;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	
	private static final Logger LOG = LoggerFactory.getLogger(DeliveryController.class);
	
	@Autowired
	private DeliveryService deliveryService;

	@RequestMapping(method = RequestMethod.POST)
	public VoucherDTO scheduleDelivery(@RequestBody DeliveryDto deliveryDTO) {
		LOG.info("Controller got a new delivery {}", deliveryDTO);
		return deliveryService.scheduleDelivery(deliveryDTO);
	}
}
