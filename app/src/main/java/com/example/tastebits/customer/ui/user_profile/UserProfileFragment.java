package com.example.tastebits.customer.ui.user_profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastebits.R;
import com.example.tastebits.customer.ui.coupons.CouponsAdapter;

public class UserProfileFragment extends Fragment {

    CouponsAdapter couponsAdapter;
    RecyclerView couponsListRec;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_user_profile, container, false);
        Button couponsButton  = root.findViewById(R.id.UserProfileCouponsButton);
        couponsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        couponsListRec = root.findViewById(R.id.userProfileCouponsRec);
        couponsAdapter = new CouponsAdapter();
        couponsListRec.setAdapter(couponsAdapter);
        couponsListRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));
        couponsListRec.setHasFixedSize(true);
        couponsListRec.setNestedScrollingEnabled(false);
        return root;
    }


}