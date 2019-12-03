package dev.drugowick.microservice.flowerstore.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.drugowick.microservice.flowerstore.dto.DeliveryInfoDto;
import dev.drugowick.microservice.flowerstore.dto.VoucherDto;

@FeignClient("carrier")
public interface CarrierClient {

	@RequestMapping(path = "/delivery", method = RequestMethod.POST)
	public VoucherDto scheduleDelivery(DeliveryInfoDto deliveryInfoDto);
	
}
