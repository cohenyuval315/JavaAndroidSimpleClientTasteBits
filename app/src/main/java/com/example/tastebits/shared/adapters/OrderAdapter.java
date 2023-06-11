package com.example.tastebits.shared.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.shared.interfaces.OrderInteract;
import com.example.tastebits.R;
import com.example.tastebits.data.models.MealModel;
import com.example.tastebits.data.models.OrderModel;
import com.example.tastebits.data.models.RestaurantModel;
import com.example.tastebits.data.models.UserModel;

import java.util.ArrayList;
import java.util.Locale;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private ArrayList<OrderModel> orders;
    private String buttonName;
    private OrderInteract orderInteract;

    private ArrayList<OrderModel> generateOrderList() {
        // Replace this with your actual data retrieval logic
        ArrayList<OrderModel> orderList = new ArrayList<>();
        UserModel user =  DataManagerSingleton.getCurrentUser();
        ArrayList<RestaurantModel> restaurants = DataManagerSingleton.getInstance().getRestaurants();
        RestaurantModel restaurant =  restaurants.get(0);
        ArrayList<MealModel> meals = DataManagerSingleton.getInstance().getRestaurantMeals(restaurant.getId());
        OrderModel order1 = new OrderModel(user.getId());
        order1.addNote("hello outside pls");
        order1.setRestaurantId(restaurant.getId());
        MealModel meal1 = meals.get(1);
        MealModel meal2 = meals.get(2);
        order1.addMeal(meal1.getId());
        order1.addMeal(meal2.getId());
        order1.addMeal(meal2.getId());
        int total1 = meal1.getPrice() + meal2.getPrice() + meal2.getPrice();
        order1.setTotalPrice(total1);
        orderList.add(order1);

        OrderModel order2 = new OrderModel(user.getId());
        order2.setRestaurantId(restaurant.getId());
        order2.addNote("call before please");
        MealModel meal3 = meals.get(3);
        MealModel meal4 = meals.get(4);
        order2.addMeal(meal1.getId());
        order2.addMeal(meal2.getId());
        order2.addMeal(meal2.getId());
        int total2 = meal3.getPrice() + meal4.getPrice() + meal4.getPrice();
        order2.setTotalPrice(total2);
        orderList.add(order2);

        return orderList;
    }


    public OrderAdapter(String buttonName, OrderInteract orderInteract) {
        this.orders = this.generateOrderList();
        this.buttonName = buttonName;
        this.orderInteract = orderInteract;
    }
    public OrderAdapter(ArrayList<OrderModel> orders, String buttonName, OrderInteract orderInteract) {
        this.orders = orders;
        this.buttonName = buttonName;
        this.orderInteract = orderInteract;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderModel order = orders.get(position);
        holder.orderID.setText(String.format(Locale.getDefault(),"%d",order.getId()));
        holder.orderTotalPrice.setText(String.format(Locale.getDefault(),"%d",order.getTotalPrice()));
        RestaurantModel restaurant = DataManagerSingleton.getInstance().getRestaurantById(orders.get(position).getRestaurantId());
        holder.orderRestaurantName.setText(restaurant.getName());
        holder.orderNotes.setText(orders.get(position).getNotes());
        holder.orderInteractButton.setText(this.buttonName);
        holder.order = order;
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private OrderModel order;
        private TextView orderRestaurantName;
        private TextView orderID;

        private TextView orderNotes;

        private TextView orderTotalPrice;

        private Button orderInteractButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            orderRestaurantName = itemView.findViewById(R.id.orderRestaurantName);
            orderID = itemView.findViewById(R.id.orderID);
            orderNotes = itemView.findViewById(R.id.orderNotes);
            orderTotalPrice = itemView.findViewById(R.id.orderTotalPrice);
            orderInteractButton = itemView.findViewById(R.id.orderInteractButton);
            orderInteractButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    orderInteract.interact(v, itemView.getContext(),order);
                }
            });
        }
    }
}


