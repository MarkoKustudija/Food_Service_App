package com.example.FoodApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "meals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private double price;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//    private Order order;

    public MealItem(MealItem m) {
        this.id = m.getId();
        this.name = m.getName();
        this.description = m.getDescription();
        this.price = m.getPrice();
//        this.order = m.getOrder();
    }
}
