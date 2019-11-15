package dev.drugowick.microservice.flowerstore.service;

import dev.drugowick.microservice.flowerstore.dto.CartDTO;
import dev.drugowick.microservice.flowerstore.dto.SupplierInfoDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartService {

    public void finishCart(CartDTO cartDTO) {

        RestTemplate client = new RestTemplate();
        ResponseEntity<SupplierInfoDTO> response = client.exchange(
                "http://localhost:8081/info" + "GO",
                HttpMethod.GET,
                null,
                SupplierInfoDTO.class
        );

        System.out.println(response.getBody().toString());
    }
}
