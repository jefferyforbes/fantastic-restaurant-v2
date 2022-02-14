package com.example.fantasticrestaurantv1.restaurants.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String ownerName;
    private String email;
    private String address;
    private Collection<RestaurantItem> restaurantItems;

    public Restaurant(
            Long id,
            String name,
            String ownerName,
            String email,
            String address,
            Collection<RestaurantItem> restaurantItems) {
        this.id = id;
        this.name = name;
        this.ownerName = ownerName;
        this.email = email;
        this.address = address;
        this.restaurantItems = restaurantItems;
    }
}