package com.bookstore.util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Created by googo on 25/03/2017.
 */
public class MongoDBUtil {
    public MongoDatabase getDB(String database){
        try {
            MongoClient mongoClient = new MongoClient("localhost",27017);

            return mongoClient.getDatabase(database);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
