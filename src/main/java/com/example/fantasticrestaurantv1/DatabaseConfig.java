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
    private static final String RESTAURANT_COL = "RestaurantDb";
    private static final String RESTAURANT_ITEM_COL = "RestaurantItemDb";
    private static final String ORDER_COL = "OrderDb";
    private static final String USER_COL = "UserDb";
    private static final String ROLE_COL = "RoleDb";
    private static final String DatabaseUrl = "DATABASE_URL";

    ConnectionString connectionString = new ConnectionString(System.getenv(DatabaseUrl));
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase(MainDatabase);

    public void upsertCol() {
        System.out.println(database.listCollections());
        database.createCollection(RESTAURANT_COL);
        database.createCollection(RESTAURANT_ITEM_COL);
        database.createCollection(ORDER_COL);
        database.createCollection(USER_COL);
        database.createCollection(ROLE_COL);

        database.getCollection(RESTAURANT_COL);
        database.getCollection(RESTAURANT_ITEM_COL);
        database.getCollection(ORDER_COL);
        database.getCollection(USER_COL);
        database.getCollection(ROLE_COL);
        System.out.println(database.listCollectionNames());
    }

    @Bean
    CommandLineRunner runner() {
        upsertCol();
        return null;
    };
}
