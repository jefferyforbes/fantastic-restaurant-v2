package com.example.fantasticrestaurantv1.restaurants.repository;

import com.example.fantasticrestaurantv1.restaurants.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    Restaurant findByName(String name);
}