package com.example.tastebits.data.models;

import com.example.tastebits.data.enums.UserType;

public class ShiftSupervisorModel extends UserModel {
    int restaurant_id;

    public ShiftSupervisorModel(String email, String password,int restaurant_id) {
        super(UserType.SHIFT_SUPERVISOR,email, password);
        this.restaurant_id = restaurant_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }
}
