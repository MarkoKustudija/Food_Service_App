package com.example.FoodApp.dto;

import com.example.FoodApp.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealItemDto {

    private  Long id;
    private String name;
    private String description;
    private double price;
    private OrderDto orderDto;
}
