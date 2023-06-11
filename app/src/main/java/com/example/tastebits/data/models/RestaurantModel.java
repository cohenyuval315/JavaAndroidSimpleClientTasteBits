package com.example.tastebits.data.models;

import com.example.tastebits.data.enums.UserType;

import java.util.ArrayList;

public class RestaurantModel extends UserModel {
    int image;
    String name;
    String timing;
    String rating;
    int price;


    ArrayList<Integer> filtersIds = new ArrayList<>();
    public RestaurantModel(int image, String name, String timing, String rating, int price,ArrayList<Integer> filtersIds) {
        super(UserType.RESTAURANT,name,"");
        this.image = image;
        this.name = name;
        this.timing = timing;
        this.rating = rating;
        this.price = price;
        this.filtersIds = filtersIds;
    }


    public ArrayList<Integer> getFiltersIds() {
        return filtersIds;
    }

    public void setFiltersIds(ArrayList<Integer> filtersIds) {
        this.filtersIds = filtersIds;
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

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
