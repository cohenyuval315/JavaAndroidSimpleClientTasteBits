package com.example.tastebits.customer.ui.cart;

import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ArrayAdapter;
    import android.widget.TextView;

    import com.example.tastebits.R;
    import com.example.tastebits.data.models.MealModel;


    import java.util.ArrayList;


    public class CartAdapter extends ArrayAdapter<MealModel> {

        ArrayList<MealModel> cartItems;
        public CartAdapter(Context context, ArrayList<MealModel> cartItems) {
            super(context, 0,cartItems);
            this.cartItems = cartItems;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_cart, parent, false);
            }

            // Get the current cart item
            MealModel cartItem = getItem(position);

            // Set the cart item name and price to the corresponding TextViews
            TextView itemNameTextView = convertView.findViewById(R.id.cartMealName);
            TextView itemPriceTextView = convertView.findViewById(R.id.cartMealPrice);
            itemNameTextView.setText(cartItem.getName());
            itemPriceTextView.setText(String.valueOf(cartItem.getPrice()));

            return convertView;
        }
    }
