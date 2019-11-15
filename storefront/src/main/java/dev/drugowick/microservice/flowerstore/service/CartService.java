package dev.drugowick.microservice.flowerstore.service;

import dev.drugowick.microservice.flowerstore.dto.CartDTO;
import dev.drugowick.microservice.flowerstore.dto.SupplierInfoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartService {

    @Value("${supplier.url:#{'http://supplier'}}")
    private String supplierUrl;

    private RestTemplate restTemplate;

    public CartService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void finishCart(CartDTO cartDTO) {

        ResponseEntity<SupplierInfoDTO> response = restTemplate.exchange(
                supplierUrl + "/info/" + cartDTO.getAddress().getProvince(),
                HttpMethod.GET,
                null,
                SupplierInfoDTO.class
        );
    }
}
