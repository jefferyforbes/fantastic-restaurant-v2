package com.example.fantasticrestaurantv1.orders.repository;

import com.example.fantasticrestaurantv1.orders.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface OrderRepository extends MongoRepository<Order, Integer> {

    Collection<Order> findAllByUserId(Integer id);
}