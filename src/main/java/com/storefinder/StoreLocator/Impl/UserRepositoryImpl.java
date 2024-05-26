package com.storefinder.StoreLocator.Impl;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.storefinder.StoreLocator.model.User;
import com.storefinder.StoreLocator.repository.UserSearchRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserSearchRepository {

    @Autowired
    private MongoClient client;

    @Autowired
    private MongoConverter converter;

    @Override
    public List<User> findByRole(String role) {
        final List<User> users = new ArrayList<>();

        MongoDatabase database = client.getDatabase("storefinder");
        MongoCollection<Document> collection = database.getCollection("users");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", "admin")
                                .append("path", "role")))));
        result.forEach(doc -> users.add(converter.read(User.class, doc)));

        return users;
    }
}
