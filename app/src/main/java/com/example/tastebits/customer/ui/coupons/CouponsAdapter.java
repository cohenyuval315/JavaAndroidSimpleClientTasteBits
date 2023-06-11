package com.example.tastebits.customer.ui.coupons;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.R;
import com.example.tastebits.data.models.CouponModel;
import com.example.tastebits.data.models.MealModel;
import com.example.tastebits.data.models.RestaurantModel;

import java.util.ArrayList;
import java.util.Locale;

public class CouponsAdapter extends RecyclerView.Adapter<CouponsAdapter.ViewHolder> {

    private ArrayList<CouponModel> couponList;

    public CouponsAdapter(ArrayList<CouponModel> couponList) {
        this.couponList = couponList;
    }

    public CouponsAdapter() {
        this.couponList = generateCoupons();
    }

    public ArrayList<CouponModel> generateCoupons(){
        ArrayList<CouponModel> coupons = new ArrayList<>();
        ArrayList<RestaurantModel> restaurants = DataManagerSingleton.getInstance().getRestaurants();
        int restaurantId = restaurants.get(0).getId();
        ArrayList<MealModel>  resMeals=  DataManagerSingleton.getInstance().getRestaurantMeals(restaurantId);
        MealModel meal1 = resMeals.get(0);
        MealModel meal2 = resMeals.get(0);
        MealModel meal3 = resMeals.get(0);
        MealModel meal4 = resMeals.get(0);
        MealModel meal5 = resMeals.get(0);
        CouponModel coupon1 = new CouponModel(restaurantId,meal1.getId(), meal1.getPrice() - meal1.getPrice() * 50/100,meal1.getName()+" tasty","1/1/2023 20:00");
        CouponModel coupon2 = new CouponModel(restaurantId,meal2.getId(), meal2.getPrice() - meal2.getPrice() * 50/100,meal2.getName()+"meal2 tasty","1/1/2023 20:00");
        CouponModel coupon3 = new CouponModel(restaurantId,meal3.getId(), meal3.getPrice() - meal3.getPrice() * 60/100,meal3.getName()+"meal3 tasty","1/1/2023 20:00");
        CouponModel coupon4 = new CouponModel(restaurantId,meal4.getId(), meal4.getPrice() - meal4.getPrice() * 70/100,meal4.getName()+"meal4 tasty","1/1/2023 20:00");
        CouponModel coupon5 = new CouponModel(restaurantId,meal5.getId(), meal5.getPrice() - meal5.getPrice() * 100/100,meal5.getName()+"meal5 tasty","1/1/2023 20:00");
        CouponModel coupon6 = new CouponModel(restaurantId,meal5.getId(), meal5.getPrice() - meal5.getPrice() * 50/100,meal5.getName()+"meal5 tasty","1/1/2023 20:00");
        coupons.add(coupon1);
        coupons.add(coupon2);
        coupons.add(coupon3);
        coupons.add(coupon4);
        coupons.add(coupon5);
        coupons.add(coupon6);
        return coupons;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coupon, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CouponModel coupon = couponList.get(position);
        int restaurantId = coupon.getRestaurantId();
        String resName = DataManagerSingleton.getInstance().getRestaurantById(restaurantId).getName();
        String mealName = DataManagerSingleton.getInstance().getMealById(coupon.getMealId()).getName();
        holder.couponDescriptionTextView.setText(coupon.getDescription());
        holder.couponRestaurantNameTextView.setText(resName);
        holder.couponMealItemTextView.setText(mealName);
        holder.couponExpDateTextView.setText(coupon.getExpDate());
        holder.couponDiscountTextView.setText(String.format(Locale.getDefault(),"%d",coupon.getNewPrice()));
    }

    @Override
    public int getItemCount() {
        return couponList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView couponRestaurantNameTextView;
        private TextView couponDescriptionTextView;
        private TextView couponMealItemTextView;
        private TextView couponExpDateTextView;
        private TextView couponDiscountTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            couponRestaurantNameTextView= itemView.findViewById(R.id.couponRestaurantName);
            couponDescriptionTextView= itemView.findViewById(R.id.couponDescription);
            couponMealItemTextView= itemView.findViewById(R.id.couponMealItem);
            couponExpDateTextView= itemView.findViewById(R.id.couponExpDate);
            couponDiscountTextView= itemView.findViewById(R.id.couponDiscount);
        }
    }
}
