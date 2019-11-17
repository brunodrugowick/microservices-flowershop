package dev.drugowick.microservice.flowerstore.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import dev.drugowick.microservice.flowerstore.client.SupplierClient;
import dev.drugowick.microservice.flowerstore.dto.CartDTO;
import dev.drugowick.microservice.flowerstore.dto.OrderInfoDTO;
import dev.drugowick.microservice.flowerstore.dto.SupplierInfoDTO;
import dev.drugowick.microservice.flowerstore.model.Order;

@Service
public class CartService {

    @Value("${supplier.url:#{'http://supplier'}}")
    private String supplierUrl;
    
    private SupplierClient supplierClient;
        
	public CartService(SupplierClient supplierClient) {
		this.supplierClient = supplierClient;
	}

	public Order finishCart(CartDTO cartDTO) {
		
		SupplierInfoDTO supplierInfoDTO = supplierClient.getInfoByProvince(cartDTO.getAddress().getProvince());
		System.out.println(supplierInfoDTO.getAddress());
		
		OrderInfoDTO supplierOrder = supplierClient.makeOrder(cartDTO.getItems());
		System.out.println(supplierOrder.toString());
		
		Order savedOrder = new Order();
		savedOrder.setSupplierOrderId(supplierOrder.getId());
		savedOrder.setFulfillmentTime(supplierOrder.getFulfillmentTime());
		savedOrder.setDestinationAddress(cartDTO.getAddress().toString());
		
        return savedOrder;
    }
}
