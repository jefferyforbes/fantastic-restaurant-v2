package com.example.fantasticrestaurantv1.orders.service;

import com.example.fantasticrestaurantv1.orders.domain.Order;
import com.example.fantasticrestaurantv1.users.domain.User;

import java.util.Collection;
import java.util.Optional;

public interface OrderService {

    Order createNewOrder(Order order, User user);

    Collection<Order> getAllOrdersForUser(Integer id);

    Optional<Order> getOrderById(Integer id);

    Collection<Order> getAllOrders();
}