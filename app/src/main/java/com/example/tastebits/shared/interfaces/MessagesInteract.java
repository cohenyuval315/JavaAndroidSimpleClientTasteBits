package com.example.tastebits.shared.interfaces;

import android.content.Context;
import android.view.View;

import com.example.tastebits.data.models.MessageModel;

public interface MessagesInteract {
    public void interact(View view, Context context, MessageModel message);
}
