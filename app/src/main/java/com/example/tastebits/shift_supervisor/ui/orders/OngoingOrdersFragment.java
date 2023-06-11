package com.example.tastebits.shift_supervisor.ui.orders;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tastebits.shared.interfaces.OrderInteract;
import com.example.tastebits.R;
import com.example.tastebits.shared.adapters.OrderAdapter;
import com.example.tastebits.data.models.OrderModel;


public class OngoingOrdersFragment extends Fragment implements OrderInteract {
    private OrderAdapter orderAdapter;
    private String modalTitle = "Ongoing Order";

    private String okButtonName = "Ok";
    private String buttonName = "Read";
    private String fragTitle = "Driver On Road Orders";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orders, container, false);
        RecyclerView orderList = view.findViewById(R.id.orderList);
        TextView title = view.findViewById(R.id.orderListTitle);
        title.setText(fragTitle);
        orderList.setLayoutManager(new LinearLayoutManager(requireContext()));
        orderAdapter = new OrderAdapter(buttonName,this);
        orderList.setAdapter(orderAdapter);
        return view;
    }

    @Override
    public void interact(View view, Context context, OrderModel order) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(this.modalTitle);
        builder.setPositiveButton(this.okButtonName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}