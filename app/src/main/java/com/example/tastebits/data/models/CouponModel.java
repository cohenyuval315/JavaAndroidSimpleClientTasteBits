package com.example.tastebits.data.models;

public class CouponModel extends IdentifiedModel {
    int restaurantId;
    int mealId;
    int newPrice;

    String expDate;
    String description;

    public CouponModel(int restaurantId, int mealId, int newPrice,String description,String expDate) {
        super();
        this.restaurantId = restaurantId;
        this.description = description;
        this.mealId = mealId;
        this.newPrice = newPrice;
        this.expDate = expDate;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
