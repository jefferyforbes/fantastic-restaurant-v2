package com.example.fantasticrestaurantv1;

import com.example.fantasticrestaurantv1.users.domain.Role;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    private static final String MainDatabase = "Fantastic-Restaurants-DB";
    private static final String DatabaseCol = "restaurantsDb";
    private static final String DatabaseUrl = "DATABASE_URL";

    ConnectionString connectionString = new ConnectionString(System.getenv(DatabaseUrl));
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase(MainDatabase);

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
    CommandLineRunner runner() {
        upsertCol();
        return null;
    };
}
