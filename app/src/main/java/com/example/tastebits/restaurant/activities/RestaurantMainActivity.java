package com.example.tastebits.restaurant.activities;

import android.os.Bundle;

import com.example.tastebits.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class RestaurantMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_main);
        BottomNavigationView navView = findViewById(R.id.restaurant_nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_restaurant_main);
        NavigationUI.setupWithNavController(navView,navController);
    }
}