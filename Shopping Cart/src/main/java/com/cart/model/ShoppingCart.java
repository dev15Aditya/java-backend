package com.cart.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="shopping_cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    @Id
    private String id;
    private String userId;
    private List<CartItem> items = new ArrayList<>();
    private BigDecimal totalAmount = BigDecimal.ZERO;

    public ShoppingCart(String userId) {
        this.userId = userId;
    }

    public void addItem(CartItem item) {
        items.add(item);
        recalculateTotal();
    }

    public void removeItem(String productId) {
        items.removeIf(item -> item.getProductId().equals(productId));
        recalculateTotal();
    }

    public void updateItemQuantity(String productId, Integer quantity){
        items.stream()
            .filter(item -> item.getProductId().equals(productId))
            .findFirst()
            .ifPresent(item -> {
                item.setQuantity(quantity);
                item.setTotalPrice(item.getUnitPrice().multiply(BigDecimal.valueOf(quantity)));
            recalculateTotal();
            });
    }

    public void clearCart() {
        items.clear();
        totalAmount = BigDecimal.ZERO;
    }

    public void recalculateTotal() {
        totalAmount = items.stream()
            .map(CartItem::getTotalPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
