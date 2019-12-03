package dev.drugowick.microservice.flowerstore.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import dev.drugowick.microservice.flowerstore.client.CarrierClient;
import dev.drugowick.microservice.flowerstore.client.SupplierClient;
import dev.drugowick.microservice.flowerstore.controller.CartController;
import dev.drugowick.microservice.flowerstore.dto.CartDTO;
import dev.drugowick.microservice.flowerstore.dto.DeliveryInfoDto;
import dev.drugowick.microservice.flowerstore.dto.OrderInfoDTO;
import dev.drugowick.microservice.flowerstore.dto.SupplierInfoDTO;
import dev.drugowick.microservice.flowerstore.dto.VoucherDto;
import dev.drugowick.microservice.flowerstore.model.Order;
import dev.drugowick.microservice.flowerstore.repository.OrderRepository;

@Service
public class CartService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CartController.class);

    @Value("${supplier.url:#{'http://supplier'}}")
    private String supplierUrl;
    
    private SupplierClient supplierClient;
    private OrderRepository orderRepository;
    private CarrierClient carrierClient;
        
	public CartService(SupplierClient supplierClient, OrderRepository orderRepository, CarrierClient carrierClient) {
		this.supplierClient = supplierClient;
		this.orderRepository = orderRepository;
		this.carrierClient = carrierClient;
	}
	
	@HystrixCommand(threadPoolKey = "getCart")
	public Order get(Long id) {
		return orderRepository.findById(id).orElse(null);
	}

	@HystrixCommand(fallbackMethod = "finishCartFallback",
			threadPoolKey = "finishCart")
	public Order finishCart(CartDTO cartDTO) {
		
		SupplierInfoDTO supplierInfoDTO = supplierClient.getInfoByProvince(cartDTO.getAddress().getProvince());
		LOG.info("Got supplier info from {}", cartDTO);
		
		OrderInfoDTO supplierOrder = supplierClient.makeOrder(cartDTO.getItems());
		LOG.info("Got order from supplier {}", supplierOrder);
		
		DeliveryInfoDto deliveryInfoDto = new DeliveryInfoDto();
		deliveryInfoDto.setOrderId(supplierOrder.getId());
		deliveryInfoDto.setDeliveryEstimatedDate(LocalDate.now().plusDays(supplierOrder.getFulfillmentTime()));
		deliveryInfoDto.setFromAddress(supplierInfoDTO.getAddress());
		deliveryInfoDto.setToAddress(cartDTO.getAddress().toString());
		VoucherDto voucher = carrierClient.scheduleDelivery(deliveryInfoDto);
		
		Order savedOrder = new Order();
		savedOrder.setSupplierOrderId(supplierOrder.getId());
		savedOrder.setFulfillmentTime(supplierOrder.getFulfillmentTime());
		savedOrder.setDestinationAddress(cartDTO.getAddress().toString());
		savedOrder.setDeliveryDate(voucher.getDeliveryEstimatedDate());
		savedOrder.setVoucher(voucher.getNumber());
		
		return orderRepository.save(savedOrder);
    }
	
	public Order finishCartFallback(CartDTO cartDTO) {
		LOG.info("Falling back to finishCartFallback method.");
		return new Order();
	}
}
