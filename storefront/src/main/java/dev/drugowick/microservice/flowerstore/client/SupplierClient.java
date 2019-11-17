package dev.drugowick.microservice.flowerstore.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.drugowick.microservice.flowerstore.dto.CartItemDTO;
import dev.drugowick.microservice.flowerstore.dto.OrderInfoDTO;
import dev.drugowick.microservice.flowerstore.dto.SupplierInfoDTO;

@FeignClient("supplier")
public interface SupplierClient {

	@RequestMapping("/info/{province}")
	SupplierInfoDTO getInfoByProvince(@PathVariable String province);

	@RequestMapping(method = RequestMethod.POST, value = "/order")
	OrderInfoDTO makeOrder(List<CartItemDTO> items);
	
}
