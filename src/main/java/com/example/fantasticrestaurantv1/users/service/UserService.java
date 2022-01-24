package com.example.fantasticrestaurantv1.users.service;

import com.example.fantasticrestaurantv1.users.domain.Role;
import com.example.fantasticrestaurantv1.users.domain.User;
import com.example.fantasticrestaurantv1.users.domain.UserType;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void registerUser(User user);

    Role createRole(Role role);

    void addRoleToUser(String username, String  roleName);

    Optional<Role> getUserRole(String username);

    Collection<Role> getUserRoles(String username);

    User getUserById(String id);

    UserType getUserType(String username);

    User getUserByUsername(String username);

    List<User> getAllUsers();
}
