package com.example.tastebits.data.models;

import com.example.tastebits.data.enums.UserType;

import java.util.ArrayList;

public class CustomerModel extends UserModel{
    ArrayList<Integer> couponsIds;
    public CustomerModel(String email, String password) {
        super(UserType.USER,email, password);

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

    public ArrayList<Integer> getCouponsIds() {
        return couponsIds;
    }

    public void setCouponsIds(ArrayList<Integer> couponsIds) {
        this.couponsIds = couponsIds;
    }
}
