package com.example.tastebits.data.models;

public class MealModel extends IdentifiedModel{
    int image;
    String name;
    String description;
    String timing;
    int price;
    String rating;

    boolean available;
    int restaurant_id;


    public MealModel(int restaurant_id,int image, String name, String description, String timing, int price, String rating) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.timing = timing;
        this.price = price;
        this.rating = rating;
        this.available = true;
        this.restaurant_id = restaurant_id;

    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
