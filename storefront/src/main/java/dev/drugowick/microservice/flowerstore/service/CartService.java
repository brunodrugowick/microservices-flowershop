package dev.drugowick.microservice.flowerstore.service;

import dev.drugowick.microservice.flowerstore.dto.CartDTO;
import dev.drugowick.microservice.flowerstore.dto.SupplierInfoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartService {

    @Value("${supplier.url:#{'http://supplier'}}")
    private String supplierUrl;

    private RestTemplate restTemplate;
    private DiscoveryClient discoveryClient;
    
    public CartService(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
		super();
		this.restTemplate = restTemplate;
		this.discoveryClient = discoveryClient;
	}



	public void finishCart(CartDTO cartDTO) {

        ResponseEntity<SupplierInfoDTO> response = restTemplate.exchange(
                supplierUrl + "/info/" + cartDTO.getAddress().getProvince(),
                HttpMethod.GET,
                null,
                SupplierInfoDTO.class
        );
        
        /**
         * Just out of curiosity it's possible to see the available clients that Ribbon is load-balancing to.
         */
        discoveryClient.getInstances("supplier").stream()
        .forEach(supplier -> {
        	System.out.println(supplier.getHost() + ":" + supplier.getPort());
        });
        
    }
}
