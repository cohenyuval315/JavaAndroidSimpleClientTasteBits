package com.example.tastebits.shift_supervisor.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.R;
import com.example.tastebits.shared.activities.LoginActivity;
import com.example.tastebits.data.models.ShiftSupervisorModel;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_shift_supervisor_home, container, false);
        ShiftSupervisorModel supervisor =  (ShiftSupervisorModel)DataManagerSingleton.getCurrentUser();
        Button logoutButton = root.findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataManagerSingleton.setCurrentUser(null);
                startActivity(new Intent(requireActivity(), LoginActivity.class));
            }
        });
        int restaurantId = supervisor.getRestaurant_id();
        return root;
    }


}