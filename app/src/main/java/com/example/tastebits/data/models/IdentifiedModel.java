package com.example.tastebits.data.models;

import java.util.UUID;

public abstract class IdentifiedModel {
    int id;

    public IdentifiedModel(){
        this.id = this.generateUniqueId();
    }

    public int getId() {
        return id;
    }
    private int generateUniqueId() {
        UUID uuid = UUID.randomUUID();
        return uuid.hashCode();
    }
}
