package com.example.FoodApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;

    @Column
    private String street;
    @Column
    private String city;
    @Column()
    private int postalCode;
//    @OneToOne(cascade =  CascadeType.PERSIST)
//    private  Order order;



}
