package com.example.fantasticrestaurantv1.users.repository;

import com.example.fantasticrestaurantv1.users.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {

    User findUserByEmail(String email);

    User findUserById(String id);

    User findUserByUsername(String username);
}