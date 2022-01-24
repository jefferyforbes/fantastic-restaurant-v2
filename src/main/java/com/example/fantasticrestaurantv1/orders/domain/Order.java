package com.example.fantasticrestaurantv1.orders.domain;

import com.example.fantasticrestaurantv1.restaurants.domain.RestaurantItem;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Document
public class Order {

    @Id
    private final Integer id;
    private final Integer userId;
    private final Collection<RestaurantItem> restaurantItems;
    private final LocalDate orderDate;
    private final LocalDateTime orderTime;
    private final Integer totalCost;
    private final Boolean orderCompleted;

    public Order(Integer id,
                 Integer userId,
                 Collection<RestaurantItem> restaurantItems,
                 LocalDate orderDate,
                 LocalDateTime orderTime,
                 Integer totalCost,
                 Boolean orderCompleted) {
        this.id = id;
        this.userId = userId;
        this.restaurantItems = restaurantItems;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.totalCost = totalCost;
        this.orderCompleted = orderCompleted;
    }
}
