package com.example.fantasticrestaurantv1;

import com.example.fantasticrestaurantv1.users.domain.Role;
import com.example.fantasticrestaurantv1.users.domain.User;
import com.example.fantasticrestaurantv1.users.domain.UserType;
import com.example.fantasticrestaurantv1.users.service.UserService;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class DatabaseConfig {

    private static final String MainDatabase = "Fantastic-Restaurants-DB";
    private static final String DatabaseCol = "restaurantsDb";
    private static final String DatabaseUrl = "DATABASE_URL";
    private UserService userService;

    ConnectionString connectionString = new ConnectionString(System.getenv(DatabaseUrl));
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase(MainDatabase);

    @Bean
    public void upsertCol() {
        Role role = new Role();
        System.out.println(database.listCollections());
        database.getCollection(DatabaseCol);

        database.getCollection(String.valueOf(role));
        database.getCollection("User");
        database.getCollection("Restaurants");

        database.createCollection(DatabaseCol);
    }

    @Bean
    public void generateAdminUser() {
        upsertCol();
        userService.createRole(new Role(1, System.getenv("ADMIN_ROLE")));

        userService.registerUser(new User(
                "Jeffery Forbes",
                System.getenv("ADMIN_USERNAME"),
                System.getenv("ADMIN_PASSWORD"),
                System.getenv("ADMIN_EMAIL"),
                System.getenv("ADMIN_PHONE_NUMBER"),
                LocalDate.now(),
                UserType.PERSONAL,
                LocalDateTime.now(),
                LocalDateTime.now())
        );
    }
}
