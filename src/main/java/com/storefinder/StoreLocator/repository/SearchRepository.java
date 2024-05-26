package com.storefinder.StoreLocator.repository;

import com.storefinder.StoreLocator.model.Store;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SearchRepository {
    List<Store> findByText(String text);
}
