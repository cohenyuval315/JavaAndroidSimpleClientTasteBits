package com.example.tastebits.data.models;

import com.example.tastebits.data.enums.UserType;

public class DriverModel extends UserModel {
    int money;

    public DriverModel(String email, String password) {
        super(UserType.DRIVER, email, password);
    }


}
