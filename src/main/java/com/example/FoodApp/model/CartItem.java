package com.example.FoodApp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cartItems")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column
    private String name;
    @Column
    private int amount;
    @Column
    private double price;
    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonIgnoreProperties("orderedItems")
//    @JsonIgnore
    private Order order;

}
