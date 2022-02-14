package com.example.fantasticrestaurantv1.users.repository;

import com.example.fantasticrestaurantv1.users.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
