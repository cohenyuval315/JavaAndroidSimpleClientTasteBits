package com.example.tastebits.restaurant.ui.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.R;
import com.example.tastebits.shared.adapters.MenuAdapter;
import com.example.tastebits.shared.interfaces.UpdateMenuRec;
import com.example.tastebits.data.models.MealModel;
import com.example.tastebits.data.models.RestaurantModel;

import java.util.ArrayList;

public class MenuFragment extends Fragment implements UpdateMenuRec {


    RecyclerView recyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RestaurantModel restaurant =  (RestaurantModel)DataManagerSingleton.getCurrentUser();
        ArrayList<MealModel> meals = DataManagerSingleton.getInstance().getRestaurantMeals(restaurant.getId());
        View rootView = inflater.inflate(R.layout.fragment_restaurant_menu, container, false);

        // Find the RecyclerView in the layout
        recyclerView = rootView.findViewById(R.id.restaurantMenuRec);
        // Set the layout manager for the RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        // Create an adapter and set it for the RecyclerView
        MenuAdapter adapter = new MenuAdapter(meals,getContext(), this);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void update() {
//        RestaurantModel restaurant =  (RestaurantModel)DataManagerSingleton.getCurrentUser();
//        ArrayList<MealModel> meals = DataManagerSingleton.getInstance().getRestaurantMeals(restaurant.getId());
//        MenuAdapter adapter = new MenuAdapter(meals,getContext(), this);
//        recyclerView.setAdapter(adapter);
    }
}