package com.example.fantasticrestaurantv1;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.CreateCollectionOptions;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    private static final String MainDatabase = "FANTASTIC-RESTAURANTS-DB";
    private static final String DatabaseCol = "restaurantsDb";
    private static final String DatabaseUrl = "DATABASE_URL";
    private ClientSession clientSession;

    ConnectionString connectionString = new ConnectionString(System.getenv(DatabaseUrl));
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase(MainDatabase);

    public void upsertCol() {
        database.listCollections();
        CreateCollectionOptions mongoOptions = new CreateCollectionOptions();
        database.createCollection(clientSession, DatabaseCol, mongoOptions);
    }
}
