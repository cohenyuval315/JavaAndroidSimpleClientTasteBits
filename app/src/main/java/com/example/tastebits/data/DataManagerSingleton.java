package com.example.tastebits.data;


import android.app.Application;

import com.example.tastebits.data.models.AppFilterModel;
import com.example.tastebits.data.models.CustomerModel;
import com.example.tastebits.data.models.MealModel;
import com.example.tastebits.data.models.MessageModel;
import com.example.tastebits.data.models.OrderModel;
import com.example.tastebits.data.models.RestaurantModel;
import com.example.tastebits.data.models.RestaurantTabModel;
import com.example.tastebits.data.models.UserModel;

import java.util.ArrayList;

public class DataManagerSingleton extends Application {
    private static DataManagerSingleton mInstance = null;
    public static AppDataSingleton appData = null;
    public static UserModel currentUser = null;
    public static RestaurantModel currentRestaurant = null;
    public static OrderModel currentOrder = null;



    public DataManagerSingleton(){
        appData = AppDataSingleton.getInstance();
    }
    public static synchronized DataManagerSingleton getInstance() {
        if(null == mInstance){
            mInstance = new DataManagerSingleton();
        }
        return mInstance;
    }
    public synchronized UserModel getUserByEmail(String email){
        for (int i = 0; i < appData.allUsers.size(); i++) {
            UserModel user = appData.allUsers.get(i);
            if (user.getEmail().equals(email)){
                return appData.allUsers.get(i);
            }

        }
        return null;
    }
    public synchronized boolean isUserExists(String email){
        if (getUserByEmail(email) == null){
            return false;
        }
        return true;
    }

    public UserModel login(String email, String pass){
        for (int i = 0; i < appData.allUsers.size(); i++) {
            UserModel user = appData.allUsers.get(i);
            if (user.getEmail().equals(email) && user.getPassword().equals(pass)){
                currentUser = appData.allUsers.get(i);
                return appData.allUsers.get(i);
            }
        }
        return null;
    }

    public static UserModel getCurrentUser(){
        return currentUser;
    }

    public static void setCurrentUser(UserModel currentUser) {
        DataManagerSingleton.currentUser = currentUser;
    }

    public static RestaurantModel getCurrentRestaurant() {
        return currentRestaurant;
    }

    public static void setCurrentRestaurant(RestaurantModel currentRestaurant) {
        DataManagerSingleton.currentRestaurant = currentRestaurant;
    }

    public static OrderModel getCurrentOrder() {
        return currentOrder;
    }

    public static void setCurrentOrder(OrderModel currentOrder) {
        DataManagerSingleton.currentOrder = currentOrder;
    }

    public UserModel register(String email,String pass){
        if (getUserByEmail(email) == null){
            CustomerModel customer = new CustomerModel(email,pass);
            appData.allUsers.add(customer);
            appData.customers.add(customer);
            return customer;
        }
        return null;
    }

    public synchronized ArrayList<RestaurantModel> getRestaurants(){
        return appData.restaurants;
    }
    public synchronized ArrayList<UserModel> getAllUsers(){
        return appData.allUsers;
    }
    public synchronized ArrayList<RestaurantTabModel> getRestaurantsTabs(){
        return appData.restaurants_tabs;
    }
    public synchronized ArrayList<AppFilterModel> getAppRestaurantsFilters(){
        return appData.getFilters();
    }
    public synchronized ArrayList<MealModel> getRestaurantsMeals(){
        return appData.getRestaurants_meals();
    }

    public ArrayList<RestaurantModel> getRestaurantsByFilter(Integer filterId){
        ArrayList<RestaurantModel> restaurants =  appData.getRestaurants();
        ArrayList<RestaurantModel> filteredRestaurants = new ArrayList<>();
        for (int i = 0; i < restaurants.size(); i++) {
            RestaurantModel restaurant = restaurants.get(i);
            ArrayList<Integer> restaurantFiltersIds =  restaurant.getFiltersIds();
            for (int j = 0; j < restaurantFiltersIds.size(); j++) {
                int restaurantFiltersId = restaurantFiltersIds.get(j);
                if (restaurantFiltersId == filterId){
                    filteredRestaurants.add(restaurant);
                }

            }
        }
        return filteredRestaurants;
    }

    public ArrayList<RestaurantTabModel> getRestaurantTabs(int restaurantId){
        ArrayList<RestaurantTabModel> allTabs= appData.getRestaurants_tabs();
        ArrayList<RestaurantTabModel> restaurantTabs = new ArrayList<>();
        for (int i = 0; i < allTabs.size(); i++) {
            if(allTabs.get(i).getRestaurant_id() ==  restaurantId) {
                restaurantTabs.add(allTabs.get(i));
            }
        }
        return restaurantTabs;
    }
    public ArrayList<MealModel> getRestaurantMeals(int restaurantId) {
        ArrayList<MealModel> allMeals= appData.getRestaurants_meals();
        ArrayList<MealModel> restaurantMeals = new ArrayList<>();
        for (int i = 0; i < allMeals.size(); i++) {
            if(allMeals.get(i).getRestaurant_id() ==  restaurantId) {
                restaurantMeals.add(allMeals.get(i));
            }
        }
        return restaurantMeals;

    }

    public ArrayList<MessageModel> getRestaurantMessages(int restaurantId) {
        ArrayList<MessageModel> allMessages= appData.getMessages();
        ArrayList<MessageModel> restaurantMessages = new ArrayList<>();
        for (int i = 0; i < allMessages.size(); i++) {
            if(allMessages.get(i).getRestaurantId() ==  restaurantId) {
                restaurantMessages.add(allMessages.get(i));
            }
        }
        return restaurantMessages;

    }

    public ArrayList<MealModel> getMealsFromOrder(){
        ArrayList<Integer> orderMeals =  currentOrder.getMealsIds();
        ArrayList<MealModel> meals = appData.getRestaurants_meals();
        ArrayList<MealModel> orderMealsObjects = new ArrayList<>();
        for (int i = 0; i < orderMeals.size(); i++) {
            int mealId = orderMeals.get(i);
            MealModel meal = getMealById(mealId);
            orderMealsObjects.add(meal);
        }
        return orderMealsObjects;
    }
    public MealModel getMealById(int mealId){
        ArrayList<MealModel> meals = appData.getRestaurants_meals();
        MealModel meal = null;
        for (int i = 0; i < meals.size(); i++) {
            if (meals.get(i).getId() == mealId){
                meal = meals.get(i);
            }
        }
        return meal;
    }
    public void updateMeal(int mealId, int newPrice){
        ArrayList<MealModel> meals =  appData.getRestaurants_meals();
        for (int i = 0; i <meals.size(); i++) {
            if (meals.get(i).getId() == mealId){
                meals.get(i).setPrice(newPrice);
            }
        }
        appData.setRestaurants_meals(meals);
    }


    public RestaurantModel getRestaurantById(int restaurantId){
        ArrayList<RestaurantModel> restaurants =  appData.getRestaurants();
        for (int i = 0; i < restaurants.size(); i++) {
            if(restaurants.get(i).getId() ==restaurantId){
                return restaurants.get(i);
            }
        }
        return null;
    }

//    public ArrayList<MealModel> getRestaurantTabMeals(int restaurantId,int tabId){
//        ArrayList<MealModel> allMeals= appData.getRestaurants_meals();
//        ArrayList<MealModel> restaurantTabMeals = new ArrayList<>();
//        for (int i = 0; i < allMeals.size(); i++) {
//            if(allMeals.get(i).getRestaurant_id() ==  restaurantId) {
//
//                for (int j = 0; j < allMeals.get(i).getTabsId().size() ; j++) {
//                    if (allMeals.get(i).getTabsId().get(i) == tabId){
//                        restaurantTabMeals.add(allMeals.get(i));
//                    }
//
//                }
//            }
//        }
//        return restaurantTabMeals;





}

