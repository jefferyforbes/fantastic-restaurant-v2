package com.example.fantasticrestaurantv1.users.repository;

import com.example.fantasticrestaurantv1.users.domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, Integer> {

    Role findByName(String name);
}
