package com.example.fantasticrestaurantv1.api;

import com.example.fantasticrestaurantv1.users.domain.Role;
import com.example.fantasticrestaurantv1.users.domain.User;
import com.example.fantasticrestaurantv1.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService service;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(service.getAllUsers());
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return ResponseEntity.ok().body(service.getUserById(id));
    }

    @PostMapping("/user/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createNewUser(@RequestBody User user) {
        URI uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/create").toUriString());
        service.registerUser(user);
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/role/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Role> createNewRole(@RequestBody Role role) {
        URI uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/role/create").toUriString());
        return ResponseEntity.created(uri).body(service.createRole(role));
    }

    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        service.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
