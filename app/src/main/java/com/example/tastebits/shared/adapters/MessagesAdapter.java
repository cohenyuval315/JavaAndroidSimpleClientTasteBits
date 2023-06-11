package com.example.tastebits.shared.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.R;
import com.example.tastebits.data.enums.MessageType;
import com.example.tastebits.data.models.MessageModel;
import com.example.tastebits.shared.interfaces.MessagesInteract;

import java.util.ArrayList;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder> {

    ArrayList<MessageModel> messages;
    Context context;

    String buttonName;

    MessagesInteract messagesInteract;

    String title;

    public ArrayList<MessageModel> generateMessages(){
        int restaurant_id = DataManagerSingleton.getCurrentUser().getId();
        ArrayList<MessageModel> messages  = new ArrayList<>();
        messages.add(new MessageModel(restaurant_id,0, MessageType.PENDING,"messagetitlte1","the food didnt reach! give refund pls!"));
        messages.add(new MessageModel(restaurant_id,0, MessageType.PENDING,"messagetitlte2","the food is bad!! give refund pls!"));
        messages.add(new MessageModel(restaurant_id,0, MessageType.PENDING,"messagetitlte3","the driver ate my food!"));
        return messages;
    }

    public MessagesAdapter(Context context,MessagesInteract messagesInteract,String buttonName) {
        this.buttonName = buttonName;
        this.messages = this.generateMessages();
        this.context = context;
        this.messagesInteract = messagesInteract;
    }

    public MessagesAdapter(ArrayList<MessageModel> messages,Context context,MessagesInteract messagesInteract,String buttonName) {
        this.buttonName = buttonName;
        this.messages = messages;
        this.context = context;
        this.messagesInteract = messagesInteract;

    }
    public MessagesAdapter(Context context,MessagesInteract messagesInteract,String buttonName,String title) {
        this.title = title;
        this.buttonName = buttonName;
        this.messages = this.generateMessages();
        this.context = context;
        this.messagesInteract = messagesInteract;
    }

    public MessagesAdapter(ArrayList<MessageModel> messages,Context context,MessagesInteract messagesInteract,String buttonName,String title) {
        this.title = title;
        this.buttonName = buttonName;
        this.messages = messages;
        this.context = context;
        this.messagesInteract = messagesInteract;

    }

    @NonNull
    @Override
    public MessagesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        return new MessagesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesAdapter.ViewHolder holder, int position) {
        MessageModel message =  messages.get(position);
        if (this.title != null){
            holder.messageTitle.setText(this.title);
        }else{
            holder.messageTitle.setText(message.getTitle());
        }
        holder.messageInteractButton.setText(this.buttonName);
        holder.message = message;
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        MessageModel message;
        TextView messageTitle;
        Button messageInteractButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            messageTitle = itemView.findViewById(R.id.messageTitle);
            messageInteractButton = itemView.findViewById(R.id.messageRead);
            messageInteractButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    messagesInteract.interact(v, itemView.getContext(),message);
                }
            });
        }

    }
}
