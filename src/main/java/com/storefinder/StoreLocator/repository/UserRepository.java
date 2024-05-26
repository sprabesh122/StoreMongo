package com.storefinder.StoreLocator.repository;

import com.storefinder.StoreLocator.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
