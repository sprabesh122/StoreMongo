package com.storefinder.StoreLocator.repository;

import com.storefinder.StoreLocator.model.Store;
import com.storefinder.StoreLocator.model.User;

import java.util.List;

public interface UserSearchRepository {
    List<User> findByRole(String text);
}
