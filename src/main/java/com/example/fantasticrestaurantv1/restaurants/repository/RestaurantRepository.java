package com.example.fantasticrestaurantv1.restaurants.repository;

import com.example.fantasticrestaurantv1.restaurants.domain.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<Restaurant, Integer> {
    Restaurant findByName(String name);
}