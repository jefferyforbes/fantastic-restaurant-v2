package com.example.fantasticrestaurantv1.restaurants.repository;

import com.example.fantasticrestaurantv1.restaurants.domain.RestaurantItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface RestaurantItemRepository extends JpaRepository<RestaurantItem, Long> {

    RestaurantItem findRestaurantItemByName(String name);

    Collection<RestaurantItem> findAllRestaurantItemsById(Long id);
}
