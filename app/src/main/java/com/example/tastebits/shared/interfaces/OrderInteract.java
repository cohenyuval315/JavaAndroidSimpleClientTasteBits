package com.example.tastebits.shared.interfaces;

import android.content.Context;
import android.view.View;

import com.example.tastebits.data.models.OrderModel;

public interface OrderInteract {
    public void interact(View view, Context context, OrderModel order);
}
