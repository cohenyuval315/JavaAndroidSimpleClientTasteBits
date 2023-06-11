package com.example.tastebits.shared.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
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

import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.R;
import com.example.tastebits.data.models.MealModel;
import com.example.tastebits.shared.interfaces.UpdateMenuRec;

import java.util.ArrayList;
import java.util.Locale;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    ArrayList<MealModel> meals;
    Context context;
    UpdateMenuRec updateMenuRec;
    String modalTitle = "Update Item Price";
    String positiveButtonName = "Update";
    String negativeButtonName = "Cancel";

    String buttonName = "update";
    public MenuAdapter( ArrayList<MealModel> meals,Context context,UpdateMenuRec updateVerticalRec) {
        this.meals = meals;
        this.context = context;
        this.updateMenuRec = updateVerticalRec;
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MealModel meal = meals.get(position);
        holder.name.setText(meal.getName());
        holder.description.setText(meal.getDescription());
        holder.price.setText(String.format(Locale.getDefault(),"%d $",meal.getPrice()));
        holder.timing.setText(meal.getTiming());
        holder.rating.setText(meal.getRating());
        holder.imageView.setImageResource(meal.getImage());
        holder.button.setText(this.buttonName);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUpdateDialog(holder.itemView.getContext(),meal);
            }
        });
    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,description,timing,rating,price;
        Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.meal_item_action_button);
            imageView = itemView.findViewById(R.id.detailed_meal_img);
            name = itemView.findViewById(R.id.detailed_meal_name);
            description = itemView.findViewById(R.id.detailed_meal_description);
            timing = itemView.findViewById(R.id.detailed_meal_timing);
            rating = itemView.findViewById(R.id.detailed_meal_rating);
            price =  itemView.findViewById(R.id.detailed_meal_price);
        }
    }
    private void openUpdateDialog(Context context,MealModel meal) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(this.modalTitle);
        final EditText input = new EditText(context);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setText(String.format(Locale.getDefault(),"%d", meal.getPrice()));
        builder.setView(input);
        builder.setPositiveButton(this.positiveButtonName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newPrice = input.getText().toString();
                DataManagerSingleton.getInstance().updateMeal(meal.getId(),Integer.parseInt(newPrice));
                notifyDataSetChanged();
                updateMenuRec.update();
            }
        });

        builder.setNegativeButton(this.negativeButtonName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
