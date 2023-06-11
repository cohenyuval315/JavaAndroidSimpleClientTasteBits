package com.example.tastebits.customer.adapters;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastebits.customer.interfaces.UpdateVerticalRec;
import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.R;
import com.example.tastebits.data.models.AppFilterModel;
import com.example.tastebits.data.models.RestaurantModel;

import java.util.ArrayList;

public class RestaurantFilterAdapter extends RecyclerView.Adapter<RestaurantFilterAdapter.ViewHolder> {

    UpdateVerticalRec updateVerticalRec;
    ArrayList<AppFilterModel> list;
    Activity activity;
    boolean check = true;
    boolean select = true;
    int row_index = -1;


    public RestaurantFilterAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<AppFilterModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant_filter,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantFilterAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        if (check) {
            ArrayList<RestaurantModel> homeVerticalModels = new ArrayList<>();
            DataManagerSingleton dm = DataManagerSingleton.getInstance();
            homeVerticalModels.addAll(dm.getRestaurantsByFilter(list.get(0).getId()));
            updateVerticalRec.callBack(position,homeVerticalModels);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    row_index =  position;
                    notifyDataSetChanged();
                    DataManagerSingleton dm = DataManagerSingleton.getInstance();
                    ArrayList<RestaurantModel> homeVerticalModels = new ArrayList<>();
                    homeVerticalModels.addAll(dm.getRestaurantsByFilter(list.get(position).getId()));
                    updateVerticalRec.callBack(position,homeVerticalModels);
                }
            });
            if (select){
                switch (position){

                }
                if (position == 0){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                    select = false;
                }
            }
            else {
                if (row_index == position){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }else {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
            }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;

        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.horizontal_img);
            name = itemView.findViewById(R.id.horizontal_text);
            cardView = itemView.findViewById(R.id.cardView);
        }

    }
}
