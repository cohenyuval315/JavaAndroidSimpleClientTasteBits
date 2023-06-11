package com.example.tastebits.data.models;

public class RestaurantTabModel extends IdentifiedModel {
    String name;
    int restaurant_id;
    public RestaurantTabModel(int restaurant_id, String name){
        this.restaurant_id = restaurant_id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
