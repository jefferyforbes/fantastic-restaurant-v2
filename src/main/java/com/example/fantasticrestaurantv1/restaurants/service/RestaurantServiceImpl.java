package com.example.fantasticrestaurantv1.restaurants.service;

import com.example.fantasticrestaurantv1.restaurants.domain.Restaurant;
import com.example.fantasticrestaurantv1.restaurants.domain.RestaurantItem;
import com.example.fantasticrestaurantv1.restaurants.repository.RestaurantItemRepository;
import com.example.fantasticrestaurantv1.restaurants.repository.RestaurantRepository;
import com.example.fantasticrestaurantv1.users.domain.User;
import com.example.fantasticrestaurantv1.users.domain.UserType;
import com.example.fantasticrestaurantv1.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final static String INVALID_USER_TYPE_EXCEPTION =
            "User type must be BUSINESS to create or modify restaurants";
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantItemRepository restaurantItemRepository;

    @Override
    public Restaurant createNewRestaurant(Restaurant restaurant, User user) {
        User currentUser = userRepository.findUserByUsername(user.getUsername());
        if (currentUser.getUserType() == UserType.BUSINESS) {
            return restaurantRepository.save(restaurant);
        } else {
            throw new IllegalStateException(INVALID_USER_TYPE_EXCEPTION);
        }
    }

    @Override
    public RestaurantItem createNewRestaurantItem(Restaurant restaurant, RestaurantItem restaurantItem, User user) {
        User currentUser = userRepository.findUserByUsername(user.getUsername());
        if (currentUser.getUserType() == UserType.BUSINESS) {
            return restaurantItemRepository.save(restaurantItem);
        } else {
            throw new IllegalStateException(INVALID_USER_TYPE_EXCEPTION);
        }
    }

    @Override
    public Collection<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> getRestaurantById(Integer id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Restaurant getRestaurantByName(String name) {
        return restaurantRepository.findByName(name);
    }

    @Override
    public void addItemsToRestaurant(Collection<RestaurantItem> restaurantItems, Restaurant restaurant, User user) {
        User currentUser = userRepository.findUserById(user.getId());
        if (user.getUserType() == UserType.BUSINESS) {
            restaurantItems.addAll(restaurantItems);
        } else {
            throw new IllegalStateException(INVALID_USER_TYPE_EXCEPTION);
        }
    }

    @Override
    public void removeItemsFromRestaurant(
            Collection<RestaurantItem> restaurantItems,
            Restaurant restaurant, User user) {
        if (user.getUserType() == UserType.BUSINESS) {
            restaurantRepository.findById(restaurant.getId()).ifPresentOrElse(
                    restaurant1 -> restaurant1.setRestaurantItems(restaurantItems),
                    () -> new IllegalStateException("There was a problem locating the restaurant")
            );
        } else {
            throw new IllegalStateException(INVALID_USER_TYPE_EXCEPTION);
        }
    }

    @Override
    public Optional<RestaurantItem> getRestaurantItemById(Integer id) {
        return restaurantItemRepository.findById(id);
    }

    @Override
    public RestaurantItem getRestaurantItemByName(String name) {
        return restaurantItemRepository.findRestaurantItemByName(name);
    }

    @Override
    public Collection<RestaurantItem> getAllRestaurantItems(Integer id) {
        return restaurantItemRepository.findAllRestaurantItemsById(id).stream().filter(
                restaurantItem -> id == restaurantItem.getId()).collect(Collectors.toList());
    }
}