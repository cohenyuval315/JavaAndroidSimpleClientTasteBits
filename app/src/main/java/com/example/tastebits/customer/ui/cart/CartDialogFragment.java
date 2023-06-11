package com.example.tastebits.customer.ui.cart;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.R;
import com.example.tastebits.data.models.MealModel;
import com.example.tastebits.customer.activities.PaymentActivity;

import java.util.ArrayList;

public class CartDialogFragment extends DialogFragment {

    private String currentCartPrice;
    ListView cartItemsListView;

    CartAdapter cartAdapter;

    TextView restaurantName;

    public static CartDialogFragment newInstance(String currentCartPrice) {
        CartDialogFragment fragment = new CartDialogFragment();
        Bundle args = new Bundle();
        args.putString("currentCartPrice", currentCartPrice);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_cart, null);
        if (getArguments() != null) {
            currentCartPrice = getArguments().getString("currentCartPrice");
        }

        TextView currentCartPriceTextView = view.findViewById(R.id.cartTotalPrice);
        restaurantName = view.findViewById(R.id.cartRestaurantName);
        currentCartPriceTextView.setText(currentCartPrice);
        cartItemsListView = view.findViewById(R.id.cartItemList);
        ArrayList<MealModel> cartItemsList = DataManagerSingleton.getInstance().getMealsFromOrder();
        String resName = DataManagerSingleton.getCurrentRestaurant().getName();
        restaurantName.setText(resName);

        // Create the cartItemAdapter and set it to the cartItemsListView
        cartAdapter = new CartAdapter(requireContext(), cartItemsList);
        cartItemsListView.setAdapter(cartAdapter);



        Button confirmButton = view.findViewById(R.id.cartProceedButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProceedDialog();
            }
        });

        Button cancelButton = view.findViewById(R.id.cartCancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(view);
        return builder.create();
    }

    private void openPaymentFragment() {
        Intent intent = new Intent(requireContext(), PaymentActivity.class);
        startActivity(intent);
        dismiss();
    }
    private void openProceedDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("are you sure?");
        builder.setPositiveButton("proceed", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                openPaymentFragment();
            }
        });

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
