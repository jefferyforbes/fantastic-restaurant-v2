package com.example.fantasticrestaurantv1.restaurants.repository;

import com.example.fantasticrestaurantv1.restaurants.domain.RestaurantItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface RestaurantItemRepository extends MongoRepository<RestaurantItem, Integer> {

    RestaurantItem findRestaurantItemByName(String name);

    Collection<RestaurantItem> findAllRestaurantItemsById(Integer id);
}
