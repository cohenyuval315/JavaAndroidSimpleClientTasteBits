package com.example.tastebits.customer.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastebits.customer.interfaces.UpdateCartPrice;
import com.example.tastebits.customer.interfaces.UpdateVerticalRec;
import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.R;
import com.example.tastebits.data.models.MealModel;
import com.example.tastebits.data.models.OrderModel;

import java.util.ArrayList;
import java.util.Locale;

public class RestaurantMenuAdapter extends RecyclerView.Adapter<RestaurantMenuAdapter.ViewHolder> {

    UpdateVerticalRec updateVerticalRec;
    UpdateCartPrice updateCartPriceListener;
    ArrayList<MealModel> list;

    final int MIN_NUMBER_MEALS = 1;
    final int MAX_NUMBER_MEALS = 5;
    public RestaurantMenuAdapter(ArrayList<MealModel> list,UpdateCartPrice updateCartPriceListener) {
        this.list = list;
        this.updateCartPriceListener = updateCartPriceListener;
    }

    @NonNull
    @Override
    public RestaurantMenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantMenuAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.price.setText( String.format(Locale.getDefault(),"%d $", list.get(position).getPrice()));
        holder.description.setText(list.get(position).getDescription());
        holder.rating.setText(list.get(position).getRating());
        holder.timing.setText(list.get(position).getTiming());
        holder.button.setText("add to cart");
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mealDialog(holder.itemView.getContext(),list.get(position));
            }
        });
        //holder.butt

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView  name,price,description,rating,timing;

        Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.detailed_meal_img);
            name = itemView.findViewById(R.id.detailed_meal_name);
            price = itemView.findViewById(R.id.detailed_meal_price);
            description = itemView.findViewById(R.id.detailed_meal_description);
            rating = itemView.findViewById(R.id.detailed_meal_rating);
            timing = itemView.findViewById(R.id.detailed_meal_timing);
            button = itemView.findViewById(R.id.meal_item_action_button);
        }
    }

    public void mealDialog(Context context, MealModel meal){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.dialog_user_meal,null);
        EditText mealRequests = dialogView.findViewById(R.id.dialog_user_meal_requests);
        Button incrementButton = dialogView.findViewById(R.id.incrementButton);
        Button decrementButton =dialogView.findViewById(R.id.decrementButton);
        EditText numOfMeals = dialogView.findViewById(R.id.valueNumMeals);
        TextView title = dialogView.findViewById(R.id.dialog_user_meal_name);
        title.setText(meal.getName());
        final int minValue = MIN_NUMBER_MEALS;
        final int maxValue = MAX_NUMBER_MEALS;
        numOfMeals.setText(String.valueOf(minValue));
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentValue = Integer.parseInt(numOfMeals.getText().toString());
                int newValue = currentValue + 1;
                if (newValue < maxValue){
                    numOfMeals.setText(String.valueOf(newValue));
                }
            }
        });
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentValue = Integer.parseInt(numOfMeals.getText().toString());
                if (currentValue > minValue) {
                    int newValue = currentValue - 1;
                    numOfMeals.setText(String.valueOf(newValue));
                }
            }
        });
        builder.setTitle(meal.getName());
        builder.setView(dialogView);
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int currentValue = Integer.parseInt(numOfMeals.getText().toString());
                OrderModel order = DataManagerSingleton.getCurrentOrder();
                for (int i = 0; i < currentValue; i++) {
                    order.addMeal(meal.getId());
                }
                order.addNote(String.valueOf(mealRequests.getText()));
                DataManagerSingleton.setCurrentOrder(order);
                notifyDataSetChanged();
                updateCartPriceListener.updateCartPrice();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
