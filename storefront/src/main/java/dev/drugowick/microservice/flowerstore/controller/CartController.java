package dev.drugowick.microservice.flowerstore.controller;

import dev.drugowick.microservice.flowerstore.dto.CartDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @RequestMapping(method = RequestMethod.POST)
    public void closeCart(@RequestBody CartDTO cart) {

    }
}
