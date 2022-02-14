package com.example.fantasticrestaurantv1.orders.domain;

import com.example.fantasticrestaurantv1.restaurants.domain.RestaurantItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Collection<RestaurantItem> restaurantItems;
    private LocalDate orderDate;
    private LocalDateTime orderTime;
    private Integer totalCost;
    private Boolean orderCompleted;

    public Order(Long id,
                 Long userId,
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
