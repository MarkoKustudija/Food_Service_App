package com.example.FoodApp.service;


import com.example.FoodApp.model.CartItem;
import com.example.FoodApp.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    public CartItem save(CartItem item) {
        return cartItemRepository.save(item);
    }

    public Page<CartItem> getAllItems(Pageable page) {
        return cartItemRepository.findAll(page);
    }
}
