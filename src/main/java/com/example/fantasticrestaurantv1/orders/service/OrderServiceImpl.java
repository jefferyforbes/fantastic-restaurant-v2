package com.example.fantasticrestaurantv1.orders.service;

import com.example.fantasticrestaurantv1.orders.domain.Order;
import com.example.fantasticrestaurantv1.orders.repository.OrderRepository;
import com.example.fantasticrestaurantv1.users.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order createNewOrder(Order order, User user) {
        if (Objects.equals(order.getUserId(), user.getId())) {
            return orderRepository.save(order);
        } else {
            throw new IllegalStateException("User id must match the user id given on the Order");
        }
    }

    @Override
    public Collection<Order> getAllOrdersForUser(Integer id) {
        return orderRepository.findAllByUserId(id);
    }

    @Override
    public Collection<Order> getAllOrders() { return orderRepository.findAll(); }

    @Override
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }
}