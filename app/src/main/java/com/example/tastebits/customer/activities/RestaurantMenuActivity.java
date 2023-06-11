package com.example.tastebits.customer.activities;
import android.content.Intent;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.R;
import com.example.tastebits.data.models.OrderModel;
import com.example.tastebits.data.models.RestaurantModel;
import com.example.tastebits.data.models.RestaurantTabModel;
import com.example.tastebits.data.models.UserModel;
import com.example.tastebits.customer.adapters.RestaurantMenuAdapter;
import com.example.tastebits.data.models.MealModel;
import com.example.tastebits.customer.interfaces.UpdateCartPrice;
import com.example.tastebits.customer.interfaces.UpdateVerticalRec;
import com.example.tastebits.customer.ui.cart.CartDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Locale;

public class RestaurantMenuActivity extends AppCompatActivity  implements UpdateCartPrice {

    RecyclerView recyclerView;
    ArrayList<MealModel> mealList;
    RestaurantMenuAdapter restaurantMenuAdapter;
    ImageView imageView;
    Toolbar toolbar;
    ActionBar actionBar;

    //
    ArrayList<RestaurantTabModel> restaurantTabList;
    //
    UpdateVerticalRec updateCartPrice;

    TextView cartPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_restaurant_menu);

        RestaurantModel restaurant = DataManagerSingleton.getCurrentRestaurant();
        FloatingActionButton checkout = findViewById(R.id.cart_fab);
        cartPrice = findViewById(R.id.current_cart_price);
        cartPrice.setText("0 $");
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCartDialog();
            }
        });
        //
        restaurantTabList = new ArrayList<>();
        restaurantTabList = DataManagerSingleton.getInstance().getRestaurantTabs(restaurant.getId());
        //

        UserModel user = DataManagerSingleton.getCurrentUser();
        OrderModel order = new OrderModel(user.getId());
        order.setRestaurantId(restaurant.getId());
        DataManagerSingleton.setCurrentOrder(order);


        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_meal_title_img);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mealList = new ArrayList<>();
        mealList = DataManagerSingleton.getInstance().getRestaurantMeals(restaurant.getId());
        restaurantMenuAdapter = new RestaurantMenuAdapter(mealList,this);
        recyclerView.setAdapter(restaurantMenuAdapter);

        imageView.setImageResource(restaurant.getImage());

        restaurantMenuAdapter.notifyDataSetChanged();

        toolbar = findViewById(R.id.restaurant_menu_toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        }
    }

    private void openCartDialog() {
        // Create an instance of the CartDialogFragment
        CartDialogFragment cartDialogFragment = CartDialogFragment.newInstance(String.valueOf(cartPrice.getText()));
        cartDialogFragment.show(getSupportFragmentManager(), "cart_dialog");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (true){
            clear_cart();
            Intent intent = new Intent(this, UserMainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Optional flag to clear the activity stack
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void clear_cart(){
        DataManagerSingleton.setCurrentOrder(new OrderModel(DataManagerSingleton.getCurrentUser().getId()));

    }
    @Override
    public void updateCartPrice() {
        TextView cartPrice = findViewById(R.id.current_cart_price);
        cartPrice.setText("0 $");
        ArrayList<MealModel> meals = DataManagerSingleton.getInstance().getMealsFromOrder();
        int totalPrice = 0;
        for (int i = 0; i < meals.size(); i++) {
            totalPrice += meals.get(i).getPrice();
        }
        String priceText = String.format(Locale.getDefault(), "%d $", totalPrice);
        cartPrice.setText(priceText);
    }

}