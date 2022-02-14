package com.example.fantasticrestaurantv1.users.repository;

import com.example.fantasticrestaurantv1.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByEmail(String email);

    User findUserById(Long id);

    User findUserByUsername(String username);
}