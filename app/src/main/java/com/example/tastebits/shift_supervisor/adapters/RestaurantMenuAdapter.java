package com.example.tastebits.shift_supervisor.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastebits.R;
import com.example.tastebits.data.models.MealModel;

import java.util.ArrayList;

public class RestaurantMenuAdapter extends RecyclerView.Adapter<RestaurantMenuAdapter.ViewHolder> {


    ArrayList<MealModel> list;

    public RestaurantMenuAdapter(ArrayList<MealModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.price.setText(list.get(position).getPrice());
        holder.description.setText(list.get(position).getDescription());
        holder.rating.setText(list.get(position).getRating());
        holder.timing.setText(list.get(position).getTiming());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView  name,price,description,rating,timing;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.detailed_meal_img);
            name = itemView.findViewById(R.id.detailed_meal_name);
            price = itemView.findViewById(R.id.detailed_meal_price);
            description = itemView.findViewById(R.id.detailed_meal_description);
            rating = itemView.findViewById(R.id.detailed_meal_rating);
            timing = itemView.findViewById(R.id.detailed_meal_timing);
        }
    }
}
