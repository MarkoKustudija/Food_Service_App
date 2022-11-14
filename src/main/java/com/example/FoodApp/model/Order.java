package com.example.FoodApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private double total;
//    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
//    private List<CartItem> orderedItems = new ArrayList<>();
    @OneToOne(cascade =  CascadeType.PERSIST)
    private User user;

    public double getTotal(int amount, double price) {
        total = amount * price;
        return total;
    }
}
