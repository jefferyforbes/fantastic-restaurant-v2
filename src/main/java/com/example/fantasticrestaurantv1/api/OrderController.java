package com.example.fantasticrestaurantv1.api;

import com.example.fantasticrestaurantv1.orders.domain.Order;
import com.example.fantasticrestaurantv1.orders.service.OrderService;
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
public class OrderController {

    private final OrderService service;

    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Collection<Order>> getAllOrders() {
        return ResponseEntity.ok().body(service.getAllOrders());
    }

    @GetMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Collection<Order>> getAllOrdersById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.getAllOrdersForUser(id));
    }

    @GetMapping("/order/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Order>> getOrder(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.getOrderById(id));
    }

    @PostMapping("/order/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Order> createNewOrder(@RequestBody Order order, User user) {
        URI uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/order/create").toUriString());
        return ResponseEntity.created(uri).body(service.createNewOrder(order, user));
    }
}