package com.storefinder.StoreLocator.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "stores")
public class Store {

    private String name;
    private String Location;
    private String category;
    private String products[];

    public Store() {
    }

    @Override
    public String toString() {
        return "stores{" +
                ", name='" + name + '\'' +
                ", Location='" + Location + '\'' +
                ", category='" + category + '\'' +
                ", products=" + Arrays.toString(products) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String[] getProducts() {
        return products;
    }

    public void setProducts(String[] products) {
        this.products = products;
    }
}



