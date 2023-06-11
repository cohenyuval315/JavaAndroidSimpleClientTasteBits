package com.example.tastebits.customer.ui.restaurant_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.R;
import com.example.tastebits.customer.adapters.RestaurantFilterAdapter;
import com.example.tastebits.customer.adapters.RestaurantListAdapter;
import com.example.tastebits.customer.interfaces.UpdateVerticalRec;
import com.example.tastebits.data.models.AppFilterModel;
import com.example.tastebits.data.models.RestaurantModel;

import java.util.ArrayList;


public class RestaurantListFragment extends Fragment implements UpdateVerticalRec {

    RecyclerView homeAppFiltersRec, homeRestaurantsListRec;
    ArrayList<AppFilterModel> homeAppFilterModelList;
    RestaurantFilterAdapter homeAppFilterAdapter;
    RestaurantListAdapter homeRestaurantListAdapter;
    ArrayList<RestaurantModel> homeRestaurantModelList;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_restaurant_list,container,false);
        homeAppFiltersRec = root.findViewById(R.id.home_horizontal_rec);
        homeRestaurantsListRec = root.findViewById(R.id.home_vertical_rec);

        DataManagerSingleton dm = DataManagerSingleton.getInstance();
        homeAppFilterModelList = dm.getAppRestaurantsFilters();
        homeAppFilterAdapter = new RestaurantFilterAdapter(this,getActivity(), homeAppFilterModelList);
        homeAppFiltersRec.setAdapter(homeAppFilterAdapter);
        homeAppFiltersRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeAppFiltersRec.setHasFixedSize(true);
        homeAppFiltersRec.setNestedScrollingEnabled(false);

        homeRestaurantModelList = new ArrayList<>();


        homeRestaurantListAdapter = new RestaurantListAdapter(getActivity(), homeRestaurantModelList);
        homeRestaurantsListRec.setAdapter(homeRestaurantListAdapter);
        homeRestaurantsListRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
//        homeRestaurantsListRec.setHasFixedSize(true);
//        homeRestaurantsListRec.setNestedScrollingEnabled(false);

        return root;
    }

    @Override
    public void callBack(int position, ArrayList<RestaurantModel> list) {
        homeRestaurantListAdapter = new RestaurantListAdapter(getContext(),list);
        homeRestaurantListAdapter.notifyDataSetChanged();
        homeRestaurantsListRec.setAdapter(homeRestaurantListAdapter);

    }
}