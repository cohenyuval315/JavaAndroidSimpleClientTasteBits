package com.example.tastebits.restaurant.ui.messages;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.R;
import com.example.tastebits.shared.adapters.MessagesAdapter;
import com.example.tastebits.data.enums.MessageType;
import com.example.tastebits.shared.interfaces.MessagesInteract;
import com.example.tastebits.data.models.MessageModel;

import java.util.ArrayList;

public class MessagesFragment extends Fragment implements MessagesInteract {

    private RecyclerView recyclerView;
    private MessagesAdapter messagesAdapter;

    String modalTitle = "Give Coupon?";

    String messageTitle = "Message";
    String positiveButtonName = "Accept";
    String negativeButtonName = "Cancel";
    String buttonName = "Read";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_messages_view, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.messagesRec);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        ArrayList<MessageModel> messages = this.generateMessages();
        messagesAdapter = new MessagesAdapter(getContext(),this,this.buttonName,this.messageTitle);
        recyclerView.setAdapter(messagesAdapter);
    }
    public ArrayList<MessageModel> generateMessages(){
        int restaurant_id = DataManagerSingleton.getCurrentUser().getId();
        ArrayList<MessageModel> messages  = new ArrayList<>();
        messages.add(new MessageModel(restaurant_id,0, MessageType.PENDING,"messagetitlte1","the food didnt reach! give refund pls!"));
        messages.add(new MessageModel(restaurant_id,0, MessageType.PENDING,"messagetitlte2","the food is bad!! give refund pls!"));
        messages.add(new MessageModel(restaurant_id,0, MessageType.PENDING,"messagetitlte3","the driver ate my food!"));
        return messages;
    }

    @Override
    public void interact(View view, Context context, MessageModel message) {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(context);
        final TextView content = new TextView(context);
        content.setText(message.getContent());
        builder.setView(content);
        builder.setTitle(this.modalTitle);

        builder.setPositiveButton(this.positiveButtonName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.setNegativeButton(this.negativeButtonName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
