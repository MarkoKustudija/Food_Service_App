package com.example.FoodApp.controller;


import com.example.FoodApp.dto.CartItemDto;
import com.example.FoodApp.dto.OrderDto;
import com.example.FoodApp.model.CartItem;
import com.example.FoodApp.model.Order;
import com.example.FoodApp.service.CartItemService;
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
@RequestMapping(value = "api/cartItems")
@CrossOrigin(origins = {"http://localhost:3000"})
public class CartItemController {

    @Autowired
    CartItemService itemService;

    @PostMapping()
    public ResponseEntity<CartItemDto> create (@RequestBody CartItemDto cartItemDto){

        CartItem item = new CartItem();

        item.setName(cartItemDto.getName());
        item.setAmount(cartItemDto.getAmount());
        item.setPrice(cartItemDto.getPrice());

//        ModelMapper modelMapper = new ModelMapper();

//        modelMapper.map(item, cartItemDto);

        item.setOrder(cartItemDto.getOrder());
//        cartItemDto.setOrder(cartItemDto.getOrder());

        item = itemService.save(item);

//        CartItemDto retValue = modelMapper.map(item, CartItemDto.class);

        return new ResponseEntity<>(new CartItemDto(item), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<CartItemDto>> getAllOrders(Pageable page){

        Page<CartItem> items = itemService.getAllItems(page);
        List<CartItemDto> retValue = new ArrayList<>();

        for (CartItem item : items) {
//            ModelMapper modelMapper = new ModelMapper();
//            CartItemDto cartItemDto = new CartItemDto();
//            modelMapper.map(item, cartItemDto);
//            retValue.add(new CartItemDto(cartItemDto));
            retValue.add(new CartItemDto(item));
        }

        return  new ResponseEntity<>(retValue, HttpStatus.OK);
    }
}
