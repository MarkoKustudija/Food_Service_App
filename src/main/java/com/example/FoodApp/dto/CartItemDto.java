package com.example.FoodApp.dto;

import com.example.FoodApp.model.CartItem;
import com.example.FoodApp.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {

    private Long id;
    private String name;
    private int amount;
    private double price;
    private Order order;

    public CartItemDto(CartItemDto item) {
        this.id = item.getId();
        this.name = item.getName();
        this.amount = item.getAmount();
        this.price = item.getPrice();
        this.order = item.getOrder();
    }

    public CartItemDto(CartItem item) {
        this.id = item.getId();
        this.name = item.getName();
        this.amount = item.getAmount();
        this.price = item.getPrice();
        this.order = item.getOrder();

    }
}
