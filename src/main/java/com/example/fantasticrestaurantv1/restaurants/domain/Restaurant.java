package com.example.fantasticrestaurantv1.restaurants.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Data
@Document
public class Restaurant {

    @Id
    private Integer id;
    @Indexed(unique = true)
    private String name;
    private String ownerName;
    private String email;
    private String address;
    private Collection<RestaurantItem> restaurantItems;

    public Restaurant(
            Integer id,
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