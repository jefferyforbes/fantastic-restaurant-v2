package com.example.fantasticrestaurantv1.orders.repository;

import com.example.fantasticrestaurantv1.orders.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Collection<Order> findAllByUserId(Long id);
}