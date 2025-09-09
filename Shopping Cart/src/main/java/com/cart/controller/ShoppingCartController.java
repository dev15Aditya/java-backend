package com.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cart.model.ShoppingCart;
import com.cart.service.ShoppingCartService;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @GetMapping("/{userId}")
    public ShoppingCart getCart(@PathVariable String userId){
        return shoppingCartService.getCart(userId)
            .orElseGet(() -> shoppingCartService.getOrCreateCart(userId));
    }

    @PostMapping("/{userId}/add")
    public ShoppingCart addItemToCart(
        @PathVariable String userId,
        @RequestParam String productId,
        @RequestParam Integer quantity
    ) {
        return shoppingCartService.addItemToCart(userId, productId, quantity);
    }

    @DeleteMapping("/{userId}/remove")
    public ShoppingCart removeItemFromCart (
        @PathVariable String userId,
        @RequestParam String productId
    ){
        return shoppingCartService.removeItemFromCart(userId, productId);
    } 

      @PutMapping("/{userId}/update")
    public ShoppingCart updateItemQuantity(
            @PathVariable String userId,
            @RequestParam String productId,
            @RequestParam Integer quantity) {
        return shoppingCartService.updateItemQuantity(userId, productId, quantity);
    }

    @DeleteMapping("/{userId}/clear")
    public void clearCart(@PathVariable String userId) {
        shoppingCartService.clearCart(userId);
    }
}
