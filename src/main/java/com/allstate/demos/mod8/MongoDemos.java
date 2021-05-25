package com.allstate.demos.mod8;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static java.util.Collections.singletonList;

public class MongoDemos {
//Connect to Mongo localhost, training db, query the inventory collection

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("training");
        MongoCollection<Document> collection = database.getCollection("inventory");

        Document myDoc = collection.find().first();
        System.out.println(myDoc.getString("item"));

        Document canvas = new Document("item", "deecanvas")
                .append("qty", 100)
                .append("tags", singletonList("cotton"));
        Document size = new Document("h", 28)
                .append("w", 35.5)
                .append("uom", "cm");
        canvas.put("size", size);


        collection.insertOne(canvas);
    }

}
