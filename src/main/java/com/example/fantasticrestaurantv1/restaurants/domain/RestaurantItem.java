package com.example.fantasticrestaurantv1.restaurants.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Data
@Document
public class RestaurantItem {

    @Id
    private Integer id;
    private String name;
    private String restaurantName;
    private String description;
    private String price;
    private Collection<String> preferences;

    public RestaurantItem(
            Integer id,
            String name,
            String description,
            String price,
            Collection<String> preferences) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.preferences = preferences;
    }
}
