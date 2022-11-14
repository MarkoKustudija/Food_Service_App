package com.example.FoodApp.dto;


import com.example.FoodApp.model.CartItem;
import com.example.FoodApp.model.Order;
import com.example.FoodApp.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private double total;
    private List<CartItem> orderedItems;
    private User user;

    public OrderDto(OrderDto o) {
        this.id = o.getId();
        this.total = o.getTotal();
        this.orderedItems = o.getOrderedItems();
        this.user = o.getUser();
    }


    public OrderDto(Order order) {
        this.id = order.getId();
        this.total = order.getTotal();
//        this.orderedItems = order.getOrderedItems();
        this.user = order.getUser();

    }

    public double getTotal(int amount, double price) {
        total = amount * price;
        return total;
    }
}
