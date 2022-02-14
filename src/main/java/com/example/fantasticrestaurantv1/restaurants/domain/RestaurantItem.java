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
public class RestaurantItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String restaurantName;
    private String description;
    private String price;
    private Collection<String> preferences;

    public RestaurantItem(
            Long id,
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
