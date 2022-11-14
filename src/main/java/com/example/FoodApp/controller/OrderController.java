package com.example.FoodApp.controller;


import com.example.FoodApp.dto.CartItemDto;
import com.example.FoodApp.dto.OrderDto;
import com.example.FoodApp.model.Order;
import com.example.FoodApp.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/orders")
@CrossOrigin(origins = {"http://localhost:3000"})
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping()
    public ResponseEntity<OrderDto> create (@RequestBody OrderDto orderDto){

//        for(int i =0;i<orderDto.getOrderedItems().size(); i++){
//
//            CartItemDto cartItemDto = orderDto.getOrderedItems().get(i);
//
//            cartItemDto.setName(cartItemDto.getName());
//            cartItemDto.setAmount(cartItemDto.getAmount());
//            cartItemDto.setPrice(cartItemDto.getPrice());
//
//            cartItemDto.setOrder(orderDto);
//
//            orderDto.getOrderedItems().set(i, cartItemDto);
//        }

//        ModelMapper modelMapper = new ModelMapper();
//
//        Order order = modelMapper.map(orderDto, Order.class);
        Order order = new Order();

        order.setTotal(orderDto.getTotal());
        order.setUser(orderDto.getUser());

        order = orderService.save(order);

//        OrderDto retValue = modelMapper.map(order, OrderDto.class);

        return  new ResponseEntity<>(new OrderDto(order), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<OrderDto>> getAllOrders(Pageable page){

        Page<Order> orders = orderService.getAllOrders(page);
        List<OrderDto> retValue = new ArrayList<>();

        for (Order order : orders) {
            ModelMapper modelMapper = new ModelMapper();
            OrderDto orderDto = new OrderDto();
            modelMapper.map(order, orderDto);
            retValue.add(new OrderDto(orderDto));
        }

        return  new ResponseEntity<>(retValue, HttpStatus.OK);
    }
}
