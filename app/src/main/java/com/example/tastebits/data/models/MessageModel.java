package com.example.tastebits.data.models;

import com.example.tastebits.data.enums.MessageType;

public class MessageModel extends IdentifiedModel {
    int restaurantId;
    int orderId;
    MessageType messageType;
    String content;
    String title;

    public MessageModel(int restaurantId,int orderId, MessageType messageType,String title,  String content) {
        this.title = title;
        this.restaurantId = restaurantId;
        this.orderId = orderId;
        this.messageType = messageType;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
