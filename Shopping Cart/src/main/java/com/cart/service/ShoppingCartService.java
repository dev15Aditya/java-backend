package com.cart.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.model.CartItem;
import com.cart.model.Product;
import com.cart.model.ShoppingCart;
import com.cart.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartRepository cartRepository;

    public ShoppingCart getOrCreateCart(String userId){
        return cartRepository.findByUserId(userId)
            .orElseGet(() -> {
                ShoppingCart newCart = new ShoppingCart(userId);
                return cartRepository.save(newCart);
            });
    }

    public ShoppingCart addItemToCart(String userId, String productId, Integer quantity){
        ShoppingCart cart = getOrCreateCart(userId);
        Optional<Product> productOpt = productService.getProductById(productId);

        if(productOpt.isPresent()){
            Product product = productOpt.get();
            CartItem newItem = new CartItem(product, quantity);

            Optional<CartItem> existingItem = cart.getItems()
                .stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst();

            if(existingItem.isPresent()){
                CartItem item = existingItem.get();
                item.setQuantity(item.getQuantity() + quantity);
                item.setTotalPrice(item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
                cart.recalculateTotal();
            } else {
                cart.addItem(newItem);
            }

            return cartRepository.save(cart);
        }
        throw new RuntimeException("Product not found");
    }

    public ShoppingCart removeItemFromCart(String userId, String productId){
        ShoppingCart cart = getOrCreateCart(userId);
        cart.removeItem(productId);
        return cartRepository.save(cart);
    }

    public ShoppingCart updateItemQuantity(String userId, String productId, Integer quantity){
        ShoppingCart cart = getOrCreateCart(userId);
        cart.updateItemQuantity(productId, quantity);
        return cartRepository.save(cart);
    }

    public void clearCart(String userId){
        ShoppingCart cart = getOrCreateCart(userId);
        cart.clearCart();
        cartRepository.save(cart);
    }

    public Optional<ShoppingCart> getCart(String userId){
        return cartRepository.findByUserId(userId);
    }
}
