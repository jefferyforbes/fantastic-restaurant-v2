package com.example.fantasticrestaurantv1.api;

import com.example.fantasticrestaurantv1.restaurants.domain.Restaurant;
import com.example.fantasticrestaurantv1.restaurants.domain.RestaurantItem;
import com.example.fantasticrestaurantv1.restaurants.service.RestaurantService;
import com.example.fantasticrestaurantv1.users.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RestaurantController {

    private final RestaurantService service;

    @GetMapping("/restaurants")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Collection<Restaurant>> getAllRestaurants() {
        return ResponseEntity.ok().body(service.getAllRestaurants());
    }

    @GetMapping("/restaurantItems/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Collection<RestaurantItem>> getAllRestaurantItems(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.getAllRestaurantItems(id));
    }

    @GetMapping("/restaurantItem/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<RestaurantItem>> getRestaurantItem(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.getRestaurantItemById(id));
    }

    @GetMapping("/restaurant/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Restaurant>> getRestaurant(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.getRestaurantById(id));
    }

    @PostMapping("restaurant/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Restaurant> createNewRestaurant(Restaurant restaurant, User user) {
        URI uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/restaurant/create").toUriString());
        return ResponseEntity.created(uri).body(service.createNewRestaurant(restaurant, user));
    }

    @PostMapping("restaurantItem/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RestaurantItem> createNewRestaurantItem(
            Restaurant restaurant, RestaurantItem restaurantItem, User user) {
        URI uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentContextPath().path(
                        "/api/v1/restaurantItem/create").toUriString());
        return ResponseEntity.created(uri).body(service.createNewRestaurantItem(restaurant, restaurantItem, user));
    }
}
