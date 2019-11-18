package dev.drugowick.microservice.flowerstore.controller;

import dev.drugowick.microservice.flowerstore.dto.CartDTO;
import dev.drugowick.microservice.flowerstore.model.Order;
import dev.drugowick.microservice.flowerstore.service.CartService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;
    private static final Logger LOG = LoggerFactory.getLogger(CartController.class);

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Order closeCart(@RequestBody CartDTO cart) {
    	LOG.info("Requesting the store to finish cart {}", cart);
        return cartService.finishCart(cart);
    }
}
