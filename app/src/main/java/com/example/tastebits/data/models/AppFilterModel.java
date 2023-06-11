package com.example.tastebits.data.models;

import java.util.UUID;

public class AppFilterModel extends IdentifiedModel {
    int image;
    String name;
    public AppFilterModel(int image, String name){
        this.image = image;
        this.name = name;
    }
    private int generateUniqueId() {
        UUID uuid = UUID.randomUUID();
        return uuid.hashCode();
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
}
