package br.com.alura.microservice.carrier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.carrier.dto.DeliveryDto;
import br.com.alura.microservice.carrier.dto.VoucherDTO;
import br.com.alura.microservice.carrier.model.Delivery;
import br.com.alura.microservice.carrier.repository.DeliveryRepository;

@Service
public class DeliveryService {
	
	@Autowired
	private DeliveryRepository repository;

	public VoucherDTO scheduleDelivery(DeliveryDto deliveryDto) {
		
		Delivery delivery = new Delivery();
		delivery.setPickupEstimatedDate(deliveryDto.getDeliveryEstimatedDate());
		delivery.setDeliveryEstimatedDate(deliveryDto.getDeliveryEstimatedDate().plusDays(1l));
		delivery.setToAddress(deliveryDto.getToAddress());
		delivery.setFromAddress(deliveryDto.getFromAddress());
		delivery.setOrderId(deliveryDto.getOrderId());
		
		repository.save(delivery);
		
		VoucherDTO voucher = new VoucherDTO();
		voucher.setNumber(delivery.getId());
		voucher.setDeliveryEstimatedDate(delivery.getDeliveryEstimatedDate());
		return voucher;
	}

}
