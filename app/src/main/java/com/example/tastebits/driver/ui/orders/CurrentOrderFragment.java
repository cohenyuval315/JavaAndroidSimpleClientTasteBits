package com.example.tastebits.driver.ui.orders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tastebits.R;
import com.example.tastebits.data.models.OrderModel;

public class CurrentOrderFragment extends Fragment {
    private TextView currentOrderText;
    private Button abortButton;
    private OrderModel currentOrder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_driver_current_order, container, false);
        return view;
    }
}