package dev.drugowick.microservice.flowerstore.controller;

import dev.drugowick.microservice.flowerstore.dto.CartDTO;
import dev.drugowick.microservice.flowerstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void closeCart(@RequestBody CartDTO cart) {

        cartService.finishCart(cart);

    }
}
