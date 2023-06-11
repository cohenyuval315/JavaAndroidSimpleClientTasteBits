package com.example.tastebits.driver.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.R;
import com.example.tastebits.shared.activities.LoginActivity;
import com.example.tastebits.databinding.ActivityDriverMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class DriverMainActivity extends AppCompatActivity {

private ActivityDriverMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_main);
        BottomNavigationView navView = findViewById(R.id.driver_nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.driver_navigation_home, R.id.driver_navigation_waiting_orders, R.id.driver_navigation_current_order)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_driver_main);
        NavigationUI.setupWithNavController(navView, navController);
        Button logoutButton = findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataManagerSingleton.setCurrentUser(null);
                startActivity(new Intent(DriverMainActivity.this, LoginActivity.class));
            }
        });
    }

}