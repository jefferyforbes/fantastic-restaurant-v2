package com.example.fantasticrestaurantv1;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    private static final String MainDatabase = "Fantastic-Restaurants-DB";
    private static final String DatabaseUrl = "DATABASE_URL";

    ConnectionString connectionString = new ConnectionString(System.getenv(DatabaseUrl));
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase(MainDatabase);
}
