package com.example.tastebits.data.models;

import com.example.tastebits.data.enums.OrderState;

import java.util.ArrayList;

public class OrderModel extends IdentifiedModel {
    int userId;
    int driverId;
    int restaurantId;
    ArrayList<Integer> mealsIds;
    ArrayList<Integer> couponsIds;
    int totalPrice;
    OrderState orderState;

    String notes;
    public OrderModel(int userId) {
        this.userId = userId;
        this.mealsIds = new ArrayList<>();
        this.couponsIds = new ArrayList<>();
        this.restaurantId = -1;
        this.totalPrice = -1;
        this.driverId = -1;
        this.orderState = OrderState.NULL;
        this.notes = "";
    }

    public String getNotes() {
        return notes;
    }

    public void addNote(String note){
        if (note.length() == 0){
            return;
        }
        this.notes += note;
        this.notes += '\n';
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public ArrayList<Integer> getMealsIds() {
        return mealsIds;
    }

    public void setMealsIds(ArrayList<Integer> mealsIds) {
        this.mealsIds = mealsIds;
    }

    public ArrayList<Integer> getCouponsIds() {
        return couponsIds;
    }

    public void addCoupon(int couponId){
        this.couponsIds.add(couponId);
    }

    public void removeCoupon(int couponId){
        for (int i = 0; i < this.couponsIds.size(); i++) {
            if(i == couponId){
                this.couponsIds.remove(couponId);
            }
        }
    }

    public void addMeal(int mealId){
        this.mealsIds.add(mealId);
    }

    public void removeMeal(int mealId){
        for (int i = 0; i < this.mealsIds.size(); i++) {
            if(i == mealId){
                this.mealsIds.remove(mealId);
            }
        }
    }


    public void setCouponsIds(ArrayList<Integer> couponsIds) {
        this.couponsIds = couponsIds;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
