package com.example.tastebits.data.models;
import com.example.tastebits.data.enums.UserType;


public abstract class UserModel extends IdentifiedModel {
    private String email;
    private String password;

    private UserType userType;

    public UserModel(UserType userType, String email, String password) {
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
