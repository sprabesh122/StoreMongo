package com.storefinder.StoreLocator.Impl;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.storefinder.StoreLocator.model.Store;
import com.storefinder.StoreLocator.repository.SearchRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Store> findByText(String text) {
        final List<Store> stores = new ArrayList<>();

        MongoDatabase database = client.getDatabase("storefinder");
        MongoCollection<Document> collection = database.getCollection("stores");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text", new Document("query", text)
                                        .append("path", "category"))),
                new Document("$sort",
                        new Document("review", 1L)),
                new Document("$limit", 1L)));
        result.forEach(doc -> stores.add(converter.read(Store.class, doc)));

        return stores;
    }
}
