package com.example.fantasticrestaurantv1.users.domain;

// [Data] Annotation removes boilerplate code for Getters and Setters

/* [Document] Annotation specifies that this model is a document model
that can be inserted, deleted or modified in the mongodb */

/* [Indexed] Annotation with the ("unique=true") parameters, means that the database will not
allow the creation of any new documents with the same value for that parameter */

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private UserType userType;
    private Collection<Role> roles = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime lastLoggedIn;

    public User(String name,
                String username,
                String password,
                String email,
                String phoneNumber,
                LocalDate dateOfBirth,
                UserType userType,
                LocalDateTime createdAt,
                LocalDateTime lastLoggedIn) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.userType = userType;
        this.createdAt = createdAt;
        this.lastLoggedIn = lastLoggedIn;
    }
}