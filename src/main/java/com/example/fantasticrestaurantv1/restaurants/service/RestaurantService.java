package com.example.fantasticrestaurantv1.restaurants.service;

import com.example.fantasticrestaurantv1.restaurants.domain.Restaurant;
import com.example.fantasticrestaurantv1.restaurants.domain.RestaurantItem;
import com.example.fantasticrestaurantv1.users.domain.User;

import java.util.Collection;
import java.util.Optional;

public interface RestaurantService {

    Restaurant createNewRestaurant(Restaurant restaurant, User user);

    RestaurantItem createNewRestaurantItem(Restaurant restaurant, RestaurantItem restaurantItem, User user);

    Collection<Restaurant> getAllRestaurants();

    Optional<Restaurant> getRestaurantById(Integer id);

    Restaurant getRestaurantByName(String name);

    void addItemsToRestaurant(Collection<RestaurantItem> restaurantItems, Restaurant restaurant, User user);

    void removeItemsFromRestaurant(Collection<RestaurantItem> restaurantItems, Restaurant restaurant, User user);

    Optional<RestaurantItem> getRestaurantItemById(Integer id);

    RestaurantItem getRestaurantItemByName(String name);

    Collection<RestaurantItem> getAllRestaurantItems(Integer id);
}