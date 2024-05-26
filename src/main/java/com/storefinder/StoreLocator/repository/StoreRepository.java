package com.storefinder.StoreLocator.repository;

import com.storefinder.StoreLocator.model.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface StoreRepository extends MongoRepository<Store, String> {

}
