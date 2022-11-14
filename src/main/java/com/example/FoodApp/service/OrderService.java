package com.example.FoodApp.service;

import com.example.FoodApp.model.Order;
import com.example.FoodApp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order save(Order o) {
        return  orderRepository.save(o);
    }

    public Page<Order> getAllOrders(Pageable page) {
        return orderRepository.findAll(page);
    }
}
