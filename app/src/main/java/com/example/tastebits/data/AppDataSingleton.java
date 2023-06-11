package com.example.tastebits.data;

import com.example.tastebits.R;
import com.example.tastebits.data.models.AppFilterModel;
import com.example.tastebits.data.models.CustomerModel;
import com.example.tastebits.data.models.DriverModel;
import com.example.tastebits.data.models.MealModel;
import com.example.tastebits.data.models.MessageModel;
import com.example.tastebits.data.models.RestaurantModel;
import com.example.tastebits.data.models.RestaurantTabModel;
import com.example.tastebits.data.models.ShiftSupervisorModel;
import com.example.tastebits.data.models.UserModel;

import java.util.ArrayList;

public class AppDataSingleton {
    private static AppDataSingleton mInstance= null;
    ArrayList<AppFilterModel> filters = new ArrayList<>();
    ArrayList<ShiftSupervisorModel> supervisors = new ArrayList<>();
    ArrayList<RestaurantModel> restaurants = new ArrayList<>();
    ArrayList<RestaurantTabModel> restaurants_tabs = new ArrayList<>();

    ArrayList<MealModel> restaurants_meals = new ArrayList<>();

    ArrayList<CustomerModel> customers = new ArrayList<>();

    ArrayList<UserModel> allUsers = new ArrayList<>();

    ArrayList<DriverModel> drivers = new ArrayList<>();

    ArrayList<MessageModel> restaurants_messages = new ArrayList<>();
    protected AppDataSingleton(){
        this.init_sample_data();
    }

    public static synchronized AppDataSingleton getInstance() {
        if(null == mInstance){
            mInstance = new AppDataSingleton();
        }
        return mInstance;
    }

    public ArrayList<MessageModel> getMessages(){
        return this.restaurants_messages;
    }
    private void init_sample_data(){
        this.filters = new ArrayList<>();
        AppFilterModel filter1 = new AppFilterModel(R.drawable.ic_gluten_free,"glut free");
        AppFilterModel filter2 = new AppFilterModel(R.drawable.ic_vegan,"vegan");
        AppFilterModel filter3 = new AppFilterModel(R.drawable.ic_kosher,"kosher");
        AppFilterModel filter4 = new AppFilterModel(R.drawable.ic_vegetarian,"vegetarian");
        filters.add(filter1);
        filters.add(filter2);
        filters.add(filter3);
        filters.add(filter4);
        ArrayList<Integer> filterType1 = new ArrayList<>();
        ArrayList<Integer> filterType2 = new ArrayList<>();
        ArrayList<Integer> filterType3 = new ArrayList<>();
        ArrayList<Integer> filterType4 = new ArrayList<>();
        ArrayList<Integer> filterType5 = new ArrayList<>();
        filterType1.add(filter1.getId());
        filterType2.add(filter2.getId());
        filterType3.add(filter3.getId());
        filterType4.add(filter4.getId());

        filterType5.add(filter1.getId());
        filterType5.add(filter2.getId());
        filterType5.add(filter3.getId());
        filterType5.add(filter4.getId());


        RestaurantModel golda = new RestaurantModel(R.drawable.res_img_0,"Golda","08:00 - 22:00","3",100,filterType1);
        this.restaurants.add(golda);
        int golda_id = golda.getId();
        ShiftSupervisorModel golda_supervisor = new ShiftSupervisorModel("super","",golda_id);
        this.supervisors.add(golda_supervisor);
        RestaurantTabModel tab_golda_featured = new RestaurantTabModel(golda_id,"featured");
        RestaurantTabModel tab_golda_icecreams = new RestaurantTabModel(golda_id,"icecreams");
        RestaurantTabModel tab_golda_cookies = new RestaurantTabModel(golda_id,"cookies");
        this.restaurants_tabs.add(tab_golda_featured);
        this.restaurants_tabs.add(tab_golda_icecreams);
        this.restaurants_tabs.add(tab_golda_cookies);
        int tab_golda_featured_id = tab_golda_featured.getId();
        int tab_golda_icecreams_id = tab_golda_icecreams.getId();
        int tab_golda_cookies_id = tab_golda_cookies.getId();
        MealModel meal1 = new MealModel(golda_id,R.drawable.meal_1,"food 1","food 1 description","8:00 - 13:00",12,"3");
        MealModel meal2 = new MealModel(golda_id,R.drawable.meal_2,"food 2","food 2 description","8:00 - 14:00",13,"4");
        MealModel meal3 = new MealModel(golda_id,R.drawable.meal_3,"food 3","food 3 description","8:00 - 15:00",14,"5");
        MealModel meal4 = new MealModel(golda_id,R.drawable.meal_4,"food 4","food 4 description","8:00 - 16:00",15,"5");
        MealModel meal5 = new MealModel(golda_id,R.drawable.meal_6,"food 5","food 5 description","8:00 - 17:00",17,"1");
        MealModel meal6 = new MealModel(golda_id,R.drawable.meal_7,"food 6","food 6 description","8:00 - 18:00",20,"2");
        this.restaurants_meals.add(meal1);
        this.restaurants_meals.add(meal2);
        this.restaurants_meals.add(meal3);
        this.restaurants_meals.add(meal4);
        this.restaurants_meals.add(meal5);
        this.restaurants_meals.add(meal6);



        RestaurantModel deliCream = new RestaurantModel(R.drawable.res_img_1,"Deli Cream","08:00 - 22:00","3",10,filterType1);
        this.restaurants.add(deliCream);
        int deliCream_id = deliCream.getId();
        ShiftSupervisorModel deli_supervisor = new ShiftSupervisorModel("super_deli","",deliCream_id);
        this.supervisors.add(deli_supervisor);
        RestaurantTabModel tab_deliCream_featured = new RestaurantTabModel(deliCream_id,"featured");
        RestaurantTabModel tab_deliCream_all = new RestaurantTabModel(deliCream_id,"all");
        this.restaurants_tabs.add(tab_deliCream_featured);
        this.restaurants_tabs.add(tab_deliCream_all);
        int tab_deliCream_featured_id = tab_deliCream_featured.getId();
        int tab_deliCream_all_id = tab_deliCream_all.getId();
        MealModel meal7 = new MealModel(deliCream_id,R.drawable.icecream3,"hambur","meal_1desc","timing",10,"3");
        MealModel meal8 = new MealModel(deliCream_id,R.drawable.icecream4,"paprika","meal_1desc","timing",10,"3");
        MealModel meal9 = new MealModel(deliCream_id,R.drawable.icecream1,"latus","meal_1desc","timing",10,"3");
        MealModel meal10 = new MealModel(deliCream_id,R.drawable.fries4,"samaly2","meal_1desc","timing",10,"3");
        MealModel meal11 = new MealModel(deliCream_id,R.drawable.burger1,"pita","meal_1desc","timing",10,"3");
        MealModel meal12 = new MealModel(deliCream_id,R.drawable.burger4,"hammus","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal7);
        this.restaurants_meals.add(meal8);
        this.restaurants_meals.add(meal9);
        this.restaurants_meals.add(meal10);
        this.restaurants_meals.add(meal11);
        this.restaurants_meals.add(meal12);



        RestaurantModel pancakeHouse = new RestaurantModel(R.drawable.res_img_3,"Golda","08:00 - 22:00","3",10,filterType1);
        this.restaurants.add(pancakeHouse);
        int pancakeHouse_id = pancakeHouse.getId();
        ShiftSupervisorModel pancake_supervisor = new ShiftSupervisorModel("super_pancake","",pancakeHouse_id);
        this.supervisors.add(pancake_supervisor);
        RestaurantTabModel tab_pancakeHouse_featured = new RestaurantTabModel(pancakeHouse_id,"featured");
        RestaurantTabModel tab_pancakeHouse_all = new RestaurantTabModel(pancakeHouse_id,"all");
        RestaurantTabModel tab_pancakeHouse_pancakes = new RestaurantTabModel(pancakeHouse_id,"pancakes");
        this.restaurants_tabs.add(tab_pancakeHouse_featured);
        this.restaurants_tabs.add(tab_pancakeHouse_all);
        this.restaurants_tabs.add(tab_pancakeHouse_pancakes);
        int tab_pancakeHouse_featured_id = tab_pancakeHouse_featured.getId();
        int tab_pancakeHouse_all_id = tab_pancakeHouse_all.getId();
        int tab_pancakeHouse_pancakes_id = tab_pancakeHouse_pancakes.getId();
        MealModel meal13 = new MealModel(pancakeHouse_id,R.drawable.icecream3,"naknik","meal_1desc","timing",10,"3");
        MealModel meal14 = new MealModel(pancakeHouse_id,R.drawable.icecream4,"eggs","meal_1desc","timing",10,"3");
        MealModel meal15 = new MealModel(pancakeHouse_id,R.drawable.icecream1,"sushi","meal_1desc","timing",10,"3");
        MealModel meal16 = new MealModel(pancakeHouse_id,R.drawable.fries4,"kartiv","meal_1desc","timing",10,"3");
        MealModel meal17 = new MealModel(pancakeHouse_id,R.drawable.burger1,"snake","meal_1desc","timing",10,"3");
        MealModel meal18 = new MealModel(pancakeHouse_id,R.drawable.burger4,"shark","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal13);
        this.restaurants_meals.add(meal14);
        this.restaurants_meals.add(meal15);
        this.restaurants_meals.add(meal16);
        this.restaurants_meals.add(meal17);
        this.restaurants_meals.add(meal18);


        RestaurantModel sweetCity = new RestaurantModel(R.drawable.res_img_4,"Sweet City","08:00 - 22:00","3",10,filterType5);
        this.restaurants.add(sweetCity);
        int sweetCity_id = sweetCity.getId();
        ShiftSupervisorModel city_supervisor = new ShiftSupervisorModel("super_city","",sweetCity_id);
        this.supervisors.add(city_supervisor);
        RestaurantTabModel tab_sweetCity_featured = new RestaurantTabModel(sweetCity_id,"featured");
        RestaurantTabModel tab_sweetCity_all = new RestaurantTabModel(sweetCity_id,"all");
        this.restaurants_tabs.add(tab_sweetCity_featured);
        this.restaurants_tabs.add(tab_sweetCity_all);
        int tab_sweetCity_featured_id = tab_sweetCity_featured.getId();
        int tab_sweetCity_all_id = tab_sweetCity_all.getId();
        MealModel meal19 = new MealModel(sweetCity_id,R.drawable.icecream3,"money","meal_1desc","timing",10,"3");
        MealModel meal20 = new MealModel(sweetCity_id,R.drawable.icecream4,"cat","meal_1desc","timing",10,"3");
        MealModel meal21 = new MealModel(sweetCity_id,R.drawable.icecream1,"dog","meal_1desc","timing",10,"3");
        MealModel meal22 = new MealModel(sweetCity_id,R.drawable.fries4,"banana","meal_1desc","timing",10,"3");
        MealModel meal23 = new MealModel(sweetCity_id,R.drawable.burger1,"book","meal_1desc","timing",10,"3");
        MealModel meal24 = new MealModel(sweetCity_id,R.drawable.burger4,"paper","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal19);
        this.restaurants_meals.add(meal20);
        this.restaurants_meals.add(meal21);
        this.restaurants_meals.add(meal22);
        this.restaurants_meals.add(meal23);
        this.restaurants_meals.add(meal24);



        RestaurantModel sweetsWorld = new RestaurantModel(R.drawable.res_img_5,"Sweet World","08:00 - 22:00","3",10,filterType2);
        this.restaurants.add(sweetsWorld);
        int sweetWorld_id = sweetsWorld.getId();
        ShiftSupervisorModel world_supervisor = new ShiftSupervisorModel("super_world","",sweetWorld_id);
        this.supervisors.add(world_supervisor);
        RestaurantTabModel tab_sweetsWorld_featured = new RestaurantTabModel(sweetWorld_id,"featured");
        RestaurantTabModel tab_sweetsWorld_all = new RestaurantTabModel(sweetWorld_id,"all");
        this.restaurants_tabs.add(tab_sweetsWorld_featured);
        this.restaurants_tabs.add(tab_sweetsWorld_all);
        int tab_sweetsWorld_featured_id = tab_sweetsWorld_featured.getId();
        int tab_sweetsWorld_all_id = tab_sweetsWorld_all.getId();
        MealModel meal25 = new MealModel(sweetWorld_id,R.drawable.icecream3,"choclate","meal_1desc","timing",10,"3");
        MealModel meal26 = new MealModel(sweetWorld_id,R.drawable.icecream4,"vanilla","meal_1desc","timing",10,"3");
        MealModel meal27 = new MealModel(sweetWorld_id,R.drawable.icecream1,"strawberry","meal_1desc","timing",10,"3");
        MealModel meal28 = new MealModel(sweetWorld_id,R.drawable.fries4,"blueberry","meal_1desc","timing",10,"3");
        MealModel meal29 = new MealModel(sweetWorld_id,R.drawable.burger1,"blackberry","meal_1desc","timing",10,"3");
        MealModel meal30 = new MealModel(sweetWorld_id,R.drawable.burger4,"bottle","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal25);
        this.restaurants_meals.add(meal26);
        this.restaurants_meals.add(meal27);
        this.restaurants_meals.add(meal28);
        this.restaurants_meals.add(meal29);
        this.restaurants_meals.add(meal30);



        RestaurantModel pizzaHut = new RestaurantModel(R.drawable.res_img_6,"Pizza Hut","08:00 - 22:00","3",10,filterType4);
        this.restaurants.add(pizzaHut);
        int pizzaHut_id = pizzaHut.getId();
        ShiftSupervisorModel hut_supervisor = new ShiftSupervisorModel("super_hut","",pizzaHut_id);
        this.supervisors.add(hut_supervisor);
        RestaurantTabModel tab_pizzaHut_featured = new RestaurantTabModel(pizzaHut_id,"featured");
        RestaurantTabModel tab_pizzaHut_all = new RestaurantTabModel(pizzaHut_id,"all");
        RestaurantTabModel tab_pizzaHut_pizzas = new RestaurantTabModel(pizzaHut_id,"pizzas");
        this.restaurants_tabs.add(tab_pizzaHut_featured);
        this.restaurants_tabs.add(tab_pizzaHut_all);
        this.restaurants_tabs.add(tab_pizzaHut_pizzas);
        int tab_pizzaHut_featured_id = tab_pizzaHut_featured.getId();
        int tab_pizzaHut_all_id = tab_pizzaHut_all.getId();
        int tab_pizzaHut_pizzas_id = tab_pizzaHut_pizzas.getId();
        MealModel meal31 = new MealModel(pizzaHut_id,R.drawable.icecream3,"pizza","meal_1desc","timing",10,"3");
        MealModel meal32 = new MealModel(pizzaHut_id,R.drawable.icecream4,"pitpiza","meal_1desc","timing",10,"3");
        MealModel meal33 = new MealModel(pizzaHut_id,R.drawable.icecream1,"cheese","meal_1desc","timing",10,"3");
        MealModel meal34 = new MealModel(pizzaHut_id,R.drawable.fries4,"blue cheese","meal_1desc","timing",10,"3");
        MealModel meal35 = new MealModel(pizzaHut_id,R.drawable.burger1,"red cheese","meal_1desc","timing",10,"3");
        MealModel meal36 = new MealModel(pizzaHut_id,R.drawable.burger4,"green cheese","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal31);
        this.restaurants_meals.add(meal32);
        this.restaurants_meals.add(meal33);
        this.restaurants_meals.add(meal34);
        this.restaurants_meals.add(meal35);
        this.restaurants_meals.add(meal36);


        RestaurantModel pizzaExplode = new RestaurantModel(R.drawable.res_img_7,"Explode Pizza","08:00 - 22:00","3",10,filterType3);
        this.restaurants.add(pizzaExplode);
        int pizzaExplode_id = pizzaExplode.getId();
        ShiftSupervisorModel explode_supervisor = new ShiftSupervisorModel("super_explode","",pizzaExplode_id);
        this.supervisors.add(explode_supervisor);
        RestaurantTabModel tab_pizzaExplode_featured = new RestaurantTabModel(pizzaExplode_id,"featured");
        RestaurantTabModel tab_pizzaExplode_all = new RestaurantTabModel(pizzaExplode_id,"all");
        RestaurantTabModel tab_pizzaExplode_pizzas = new RestaurantTabModel(pizzaExplode_id,"pizzas");
        this.restaurants_tabs.add(tab_pizzaExplode_featured);
        this.restaurants_tabs.add(tab_pizzaExplode_all);
        this.restaurants_tabs.add(tab_pizzaExplode_pizzas);
        int tab_pizzaExplode_featured_id = tab_pizzaExplode_featured.getId();
        int tab_pizzaExplode_all_id = tab_pizzaExplode_all.getId();
        int tab_pizzaExplode_pizzas_id = tab_pizzaExplode_pizzas.getId();
        MealModel meal37 = new MealModel(pizzaExplode_id,R.drawable.icecream3,"cup","meal_1desc","timing",10,"3");
        MealModel meal38 = new MealModel(pizzaExplode_id,R.drawable.icecream4,"coffe","meal_1desc","timing",10,"3");
        MealModel meal39 = new MealModel(pizzaExplode_id,R.drawable.icecream1,"tea","meal_1desc","timing",10,"3");
        MealModel meal40 = new MealModel(pizzaExplode_id,R.drawable.fries4,"water","meal_1desc","timing",10,"3");
        MealModel meal41 = new MealModel(pizzaExplode_id,R.drawable.burger1,"coke","meal_1desc","timing",10,"3");
        MealModel meal42 = new MealModel(pizzaExplode_id,R.drawable.burger4,"cigg","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal37);
        this.restaurants_meals.add(meal38);
        this.restaurants_meals.add(meal39);
        this.restaurants_meals.add(meal40);
        this.restaurants_meals.add(meal41);
        this.restaurants_meals.add(meal42);



        RestaurantModel pizzaPizza = new RestaurantModel(R.drawable.res_img_9,"Pizza Pizza","08:00 - 22:00","3",10,filterType3);
        this.restaurants.add(pizzaPizza);
        int pizzaPizza_id = pizzaPizza.getId();
        ShiftSupervisorModel pizza_supervisor = new ShiftSupervisorModel("super_pizza","",pizzaPizza_id);
        this.supervisors.add(pizza_supervisor);
        RestaurantTabModel tab_pizzaPizza_featured = new RestaurantTabModel(pizzaPizza_id,"featured");
        RestaurantTabModel tab_pizzaPizza_all = new RestaurantTabModel(pizzaPizza_id,"all");
        RestaurantTabModel tab_pizzaPizza_best = new RestaurantTabModel(pizzaPizza_id,"best");
        this.restaurants_tabs.add(tab_pizzaPizza_featured);
        this.restaurants_tabs.add(tab_pizzaPizza_all);
        this.restaurants_tabs.add(tab_pizzaPizza_best);
        int tab_pizzaPizza_featured_id = tab_pizzaPizza_featured.getId();
        int tab_pizzaPizza_all_id = tab_pizzaPizza_all.getId();
        int tab_pizzaPizza_best_id = tab_pizzaPizza_best.getId();
        MealModel meal43 = new MealModel(pizzaPizza_id,R.drawable.icecream3,"mouse","meal_1desc","timing",10,"3");
        MealModel meal44 = new MealModel(pizzaPizza_id,R.drawable.icecream4,"red","meal_1desc","timing",10,"3");
        MealModel meal45 = new MealModel(pizzaPizza_id,R.drawable.icecream1,"blye","meal_1desc","timing",10,"3");
        MealModel meal46 = new MealModel(pizzaPizza_id,R.drawable.fries4,"yellow","meal_1desc","timing",10,"3");
        MealModel meal47 = new MealModel(pizzaPizza_id,R.drawable.burger1,"idk","meal_1desc","timing",10,"3");
        MealModel meal48 = new MealModel(pizzaPizza_id,R.drawable.burger4,"idk2","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal43);
        this.restaurants_meals.add(meal44);
        this.restaurants_meals.add(meal45);
        this.restaurants_meals.add(meal46);
        this.restaurants_meals.add(meal47);
        this.restaurants_meals.add(meal48);



        RestaurantModel pizzaZ = new RestaurantModel(R.drawable.res_img_10,"PizzaZ","08:00 - 22:00","3",10,filterType2);
        this.restaurants.add(pizzaZ);
        int pizzaZ_id = pizzaZ.getId();
        ShiftSupervisorModel z_supervisor = new ShiftSupervisorModel("super_z","",pizzaZ_id);
        this.supervisors.add(z_supervisor);
        RestaurantTabModel tab_pizzaZ_featured = new RestaurantTabModel(pizzaZ_id,"featured");
        RestaurantTabModel tab_pizzaZ_all = new RestaurantTabModel(pizzaZ_id,"all");
        this.restaurants_tabs.add(tab_pizzaZ_featured);
        this.restaurants_tabs.add(tab_pizzaZ_all);
        int tab_pizzaZ_featured_id = tab_pizzaZ_featured.getId();
        int tab_pizzaZ_all_id = tab_pizzaZ_all.getId();
        MealModel meal49 = new MealModel(pizzaZ_id,R.drawable.meal_1,"abc","meal_1desc","timing",10,"3");
        MealModel meal50 = new MealModel(pizzaZ_id,R.drawable.meal_2,"abcd","meal_1desc","timing",10,"3");
        MealModel meal51 = new MealModel(pizzaZ_id,R.drawable.meal_3,"abcdf","meal_1desc","timing",10,"3");
        MealModel meal52 = new MealModel(pizzaZ_id,R.drawable.meal_4,"acbdgf","meal_1desc","timing",10,"3");
        MealModel meal53 = new MealModel(pizzaZ_id,R.drawable.meal_6,"asdasd","meal_1desc","timing",10,"3");
        MealModel meal54 = new MealModel(pizzaZ_id,R.drawable.meal_7,"gdfgfd","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal49);
        this.restaurants_meals.add(meal50);
        this.restaurants_meals.add(meal51);
        this.restaurants_meals.add(meal52);
        this.restaurants_meals.add(meal53);
        this.restaurants_meals.add(meal54);



        RestaurantModel hamburg = new RestaurantModel(R.drawable.res_img_11,"Hamburg","08:00 - 22:00","3",10,filterType5);
        this.restaurants.add(hamburg);
        int hamburg_id = hamburg.getId();
        ShiftSupervisorModel ham_supervisor = new ShiftSupervisorModel("super_ham","",hamburg_id);
        this.supervisors.add(ham_supervisor);
        RestaurantTabModel tab_hamburg_featured = new RestaurantTabModel(hamburg_id,"featured");
        RestaurantTabModel tab_hamburg_all = new RestaurantTabModel(hamburg_id,"all");
        this.restaurants_tabs.add(tab_hamburg_featured);
        this.restaurants_tabs.add(tab_hamburg_all);
        int tab_hamburg_featured_id = tab_hamburg_featured.getId();
        int tab_hamburg_all_id = tab_hamburg_all.getId();
        MealModel meal55 = new MealModel(hamburg_id,R.drawable.icecream3,"f1","meal_1desc","timing",10,"3");
        MealModel meal56 = new MealModel(hamburg_id,R.drawable.icecream4,"f2","meal_1desc","timing",10,"3");
        MealModel meal57 = new MealModel(hamburg_id,R.drawable.icecream1,"f3","meal_1desc","timing",10,"3");
        MealModel meal58 = new MealModel(hamburg_id,R.drawable.fries4,"f4","meal_1desc","timing",10,"3");
        MealModel meal59 = new MealModel(hamburg_id,R.drawable.burger1,"f5","meal_1desc","timing",10,"3");
        MealModel meal60 = new MealModel(hamburg_id,R.drawable.burger4,"f6","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal55);
        this.restaurants_meals.add(meal56);
        this.restaurants_meals.add(meal57);
        this.restaurants_meals.add(meal58);
        this.restaurants_meals.add(meal59);
        this.restaurants_meals.add(meal60);



        RestaurantModel burgers = new RestaurantModel(R.drawable.res_img_12,"Burgers","08:00 - 22:00","3",10,filterType4);
        this.restaurants.add(burgers);
        int burgers_id = burgers.getId();
        ShiftSupervisorModel burgers_supervisor = new ShiftSupervisorModel("super_burgers","",burgers_id);
        this.supervisors.add(burgers_supervisor);
        RestaurantTabModel tab_burgers_featured = new RestaurantTabModel(burgers_id,"featured");
        RestaurantTabModel tab_burgers_all = new RestaurantTabModel(burgers_id,"all");
        RestaurantTabModel tab_burgers_burgers = new RestaurantTabModel(burgers_id,"burgers");
        this.restaurants_tabs.add(tab_burgers_featured);
        this.restaurants_tabs.add(tab_burgers_all);
        this.restaurants_tabs.add(tab_burgers_burgers);
        int tab_burgers_featured_id = tab_burgers_featured.getId();
        int tab_burgers_all_id = tab_burgers_all.getId();
        int tab_burgers_burgers_id = tab_burgers_burgers.getId();
        MealModel meal61 = new MealModel(burgers_id,R.drawable.icecream3,"ctrl","meal_1desc","timing",10,"3");
        MealModel meal62 = new MealModel(burgers_id,R.drawable.icecream4,"alt","meal_1desc","timing",10,"3");
        MealModel meal63 = new MealModel(burgers_id,R.drawable.icecream1,"delete","meal_1desc","timing",10,"3");
        MealModel meal64 = new MealModel(burgers_id,R.drawable.fries4,"f4","meal_1desc","timing",10,"3");
        MealModel meal65 = new MealModel(burgers_id,R.drawable.burger1,"karton","meal_1desc","timing",10,"3");
        MealModel meal66 = new MealModel(burgers_id,R.drawable.burger4,"ballon","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal61);
        this.restaurants_meals.add(meal62);
        this.restaurants_meals.add(meal63);
        this.restaurants_meals.add(meal64);
        this.restaurants_meals.add(meal65);
        this.restaurants_meals.add(meal66);


        RestaurantModel burgerim = new RestaurantModel(R.drawable.res_img_13,"Burgerim","08:00 - 22:00","3",10,filterType5);
        this.restaurants.add(burgerim);
        int burgerim_id = burgerim.getId();
        ShiftSupervisorModel burgerim_supervisor = new ShiftSupervisorModel("super_burgerim","",burgerim_id);
        this.supervisors.add(burgerim_supervisor);
        RestaurantTabModel tab_burgerim_featured = new RestaurantTabModel(burgerim_id,"featured");
        RestaurantTabModel tab_burgerim_all = new RestaurantTabModel(burgerim_id,"all");
        this.restaurants_tabs.add(tab_burgerim_featured);
        this.restaurants_tabs.add(tab_burgerim_all);
        int tab_burgerim_featured_id = tab_burgerim_featured.getId();
        int tab_burgerim_all_id = tab_burgerim_all.getId();
        MealModel meal67 = new MealModel(burgerim_id,R.drawable.icecream3,"meal67","meal_1desc","timing",10,"3");
        MealModel meal68 = new MealModel(burgerim_id,R.drawable.icecream4,"meal68","meal_1desc","timing",10,"3");
        MealModel meal69 = new MealModel(burgerim_id,R.drawable.icecream1,"meal69","meal_1desc","timing",10,"3");
        MealModel meal70 = new MealModel(burgerim_id,R.drawable.fries4,"meal70","meal_1desc","timing",10,"3");
        MealModel meal71 = new MealModel(burgerim_id,R.drawable.burger1,"meal71","meal_1desc","timing",10,"3");
        MealModel meal72 = new MealModel(burgerim_id,R.drawable.burger4,"meal72","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal67);
        this.restaurants_meals.add(meal68);
        this.restaurants_meals.add(meal69);
        this.restaurants_meals.add(meal70);
        this.restaurants_meals.add(meal71);
        this.restaurants_meals.add(meal72);


        RestaurantModel burgerRanch = new RestaurantModel(R.drawable.res_img_14,"Burger Ranch","08:00 - 22:00","3",10,filterType4);
        this.restaurants.add(burgerRanch);
        int burgerRanch_id = burgerRanch.getId();
        ShiftSupervisorModel ranch_supervisor = new ShiftSupervisorModel("super_ranch","",burgerRanch_id);
        this.supervisors.add(ranch_supervisor);
        RestaurantTabModel tab_burgerRanch_featured = new RestaurantTabModel(burgerRanch_id,"featured");
        RestaurantTabModel tab_burgerRanch_all = new RestaurantTabModel(burgerRanch_id,"all");
        this.restaurants_tabs.add(tab_burgerRanch_featured);
        this.restaurants_tabs.add(tab_burgerRanch_all);
        int tab_burgerRanch_featured_id = tab_burgerRanch_featured.getId();
        int tab_burgerRanch_all_id = tab_burgerRanch_all.getId();
        MealModel meal73 = new MealModel(burgerRanch_id,R.drawable.icecream3,"meal73","meal_1desc","timing",10,"3");
        MealModel meal74 = new MealModel(burgerRanch_id,R.drawable.icecream4,"meal74","meal_1desc","timing",10,"3");
        MealModel meal75 = new MealModel(burgerRanch_id,R.drawable.icecream1,"meal75","meal_1desc","timing",10,"3");
        MealModel meal76 = new MealModel(burgerRanch_id,R.drawable.fries4,"meal76","meal_1desc","timing",10,"3");
        MealModel meal77 = new MealModel(burgerRanch_id,R.drawable.burger1,"meal77","meal_1desc","timing",10,"3");
        MealModel meal78 = new MealModel(burgerRanch_id,R.drawable.burger4,"meal78","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal73);
        this.restaurants_meals.add(meal74);
        this.restaurants_meals.add(meal75);
        this.restaurants_meals.add(meal76);
        this.restaurants_meals.add(meal77);
        this.restaurants_meals.add(meal78);


        RestaurantModel japanika = new RestaurantModel(R.drawable.res_img_15,"Japanika","08:00 - 22:00","3",10,filterType2);
        this.restaurants.add(japanika);
        int japanika_id = japanika.getId();
        ShiftSupervisorModel japanika_supervisor = new ShiftSupervisorModel("super_japanika","",japanika_id);
        this.supervisors.add(japanika_supervisor);
        RestaurantTabModel tab_japanika_featured = new RestaurantTabModel(japanika_id,"featured");
        RestaurantTabModel tab_japanika_all = new RestaurantTabModel(japanika_id,"all");
        RestaurantTabModel tab_japanika_sushi = new RestaurantTabModel(japanika_id,"sushi");
        RestaurantTabModel tab_japanika_rolls = new RestaurantTabModel(japanika_id,"rolls");
        this.restaurants_tabs.add(tab_japanika_featured);
        this.restaurants_tabs.add(tab_japanika_all);
        this.restaurants_tabs.add(tab_japanika_sushi);
        this.restaurants_tabs.add(tab_japanika_rolls);
        int tab_japanika_featured_id = tab_japanika_featured.getId();
        int tab_japanika_all_id = tab_japanika_all.getId();
        int tab_japanika_sushi_id = tab_japanika_sushi.getId();
        int tab_japanika_rolls_id = tab_japanika_rolls.getId();
        MealModel meal79 = new MealModel(japanika_id,R.drawable.icecream3,"meal79","meal_1desc","timing",10,"3");
        MealModel meal80 = new MealModel(japanika_id,R.drawable.icecream4,"meal80","meal_1desc","timing",10,"3");
        MealModel meal81 = new MealModel(japanika_id,R.drawable.icecream1,"meal81","meal_1desc","timing",10,"3");
        MealModel meal82 = new MealModel(japanika_id,R.drawable.fries4,"meal82","meal_1desc","timing",10,"3");
        MealModel meal83 = new MealModel(japanika_id,R.drawable.burger1,"meal83","meal_1desc","timing",10,"3");
        MealModel meal84 = new MealModel(japanika_id,R.drawable.burger4,"meal84","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal79);
        this.restaurants_meals.add(meal80);
        this.restaurants_meals.add(meal81);
        this.restaurants_meals.add(meal82);
        this.restaurants_meals.add(meal83);
        this.restaurants_meals.add(meal84);


        RestaurantModel oshioshi = new RestaurantModel(R.drawable.res_img_16,"Oshi-Oshi","08:00 - 22:00","3",10,filterType2);
        this.restaurants.add(oshioshi);
        int oshioshi_id = oshioshi.getId();
        ShiftSupervisorModel oshi_supervisor = new ShiftSupervisorModel("super_oshi","",oshioshi_id);
        this.supervisors.add(oshi_supervisor);
        RestaurantTabModel tab_oshioshi_featured = new RestaurantTabModel(oshioshi_id,"featured");
        RestaurantTabModel tab_oshioshi_all = new RestaurantTabModel(oshioshi_id,"all");
        this.restaurants_tabs.add(tab_oshioshi_featured);
        this.restaurants_tabs.add(tab_oshioshi_all);
        int tab_oshioshi_featured_id = tab_oshioshi_featured.getId();
        int tab_oshioshi_all_id = tab_oshioshi_all.getId();
        MealModel meal85 = new MealModel(oshioshi_id,R.drawable.icecream3,"meal85","meal_1desc","timing",10,"3");
        MealModel meal86 = new MealModel(oshioshi_id,R.drawable.icecream4,"meal86","meal_1desc","timing",10,"3");
        MealModel meal87 = new MealModel(oshioshi_id,R.drawable.icecream1,"meal87","meal_1desc","timing",10,"3");
        MealModel meal88 = new MealModel(oshioshi_id,R.drawable.fries4,"meal88","meal_1desc","timing",10,"3");
        MealModel meal89 = new MealModel(oshioshi_id,R.drawable.burger1,"meal89","meal_1desc","timing",10,"3");
        MealModel meal90 = new MealModel(oshioshi_id,R.drawable.burger4,"meal90","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal85);
        this.restaurants_meals.add(meal86);
        this.restaurants_meals.add(meal87);
        this.restaurants_meals.add(meal88);
        this.restaurants_meals.add(meal89);
        this.restaurants_meals.add(meal90);



        RestaurantModel subway = new RestaurantModel(R.drawable.res_img_17,"Subway","08:00 - 22:00","3",10,filterType3);
        this.restaurants.add(subway);
        int subway_id = subway.getId();
        ShiftSupervisorModel subway_supervisor = new ShiftSupervisorModel("super_sub","",subway_id);
        this.supervisors.add(subway_supervisor);
        RestaurantTabModel tab_subway_all = new RestaurantTabModel(subway_id,"all");
        this.restaurants_tabs.add(tab_subway_all);
        int tab_subway_all_id = tab_subway_all.getId();
        MealModel meal91 = new MealModel(subway_id,R.drawable.icecream3,"meal91","meal_1desc","timing",10,"3");
        MealModel meal92 = new MealModel(subway_id,R.drawable.icecream4,"meal92","meal_1desc","timing",10,"3");
        MealModel meal93 = new MealModel(subway_id,R.drawable.icecream1,"meal93","meal_1desc","timing",10,"3");
        MealModel meal94 = new MealModel(subway_id,R.drawable.fries4,"meal94","meal_1desc","timing",10,"3");
        MealModel meal95 = new MealModel(subway_id,R.drawable.burger1,"meal95","meal_1desc","timing",10,"3");
        MealModel meal96 = new MealModel(subway_id,R.drawable.burger4,"meal96","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal91);
        this.restaurants_meals.add(meal92);
        this.restaurants_meals.add(meal93);
        this.restaurants_meals.add(meal94);
        this.restaurants_meals.add(meal95);
        this.restaurants_meals.add(meal96);



        RestaurantModel kfc = new RestaurantModel(R.drawable.res_img_18,"KFC","08:00 - 22:00","3",10,filterType4);
        this.restaurants.add(kfc);
        int kfc_id = kfc.getId();
        ShiftSupervisorModel kfc_supervisor = new ShiftSupervisorModel("super_kfc","",kfc_id);
        this.supervisors.add(kfc_supervisor);
        RestaurantTabModel tab_kfc_all = new RestaurantTabModel(kfc_id,"all");
        this.restaurants_tabs.add(tab_kfc_all);
        int tab_kfc_all_id = tab_kfc_all.getId();
        MealModel meal97 = new MealModel(kfc_id,R.drawable.icecream3,"meal97","meal_1desc","timing",10,"3");
        MealModel meal98 = new MealModel(kfc_id,R.drawable.icecream4,"meal98","meal_1desc","timing",10,"3");
        MealModel meal99 = new MealModel(kfc_id,R.drawable.icecream1,"meal99","meal_1desc","timing",10,"3");
        MealModel meal100 = new MealModel(kfc_id,R.drawable.fries4,"meal100","meal_1desc","timing",10,"3");
        MealModel meal101 = new MealModel(kfc_id,R.drawable.burger1,"meal101","meal_1desc","timing",10,"3");
        MealModel meal102 = new MealModel(kfc_id,R.drawable.burger4,"meal102","meal_1desc","timing",10,"3");
        this.restaurants_meals.add(meal97);
        this.restaurants_meals.add(meal98);
        this.restaurants_meals.add(meal99);
        this.restaurants_meals.add(meal100);
        this.restaurants_meals.add(meal101);
        this.restaurants_meals.add(meal102);


        CustomerModel customer = new CustomerModel("user","");
        DriverModel driver = new DriverModel("driver","");
        this.customers.add(customer);
        this.drivers.add(driver);

        allUsers.addAll(this.customers);
        allUsers.addAll(this.restaurants);
        allUsers.addAll(this.supervisors);
        allUsers.addAll(this.drivers);
    }



    public ArrayList<AppFilterModel> getFilters() {
        return filters;
    }

    public void setFilters(ArrayList<AppFilterModel> filters) {
        this.filters = filters;
    }

    public ArrayList<ShiftSupervisorModel> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(ArrayList<ShiftSupervisorModel> supervisors) {
        this.supervisors = supervisors;
    }

    public ArrayList<RestaurantModel> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(ArrayList<RestaurantModel> restaurants) {
        this.restaurants = restaurants;
    }

    public ArrayList<RestaurantTabModel> getRestaurants_tabs() {
        return restaurants_tabs;
    }

    public void setRestaurants_tabs(ArrayList<RestaurantTabModel> restaurants_tabs) {
        this.restaurants_tabs = restaurants_tabs;
    }

    public ArrayList<MealModel> getRestaurants_meals() {
        return restaurants_meals;
    }

    public void setRestaurants_meals(ArrayList<MealModel> restaurants_meals) {
        this.restaurants_meals = restaurants_meals;
    }

    public ArrayList<CustomerModel> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<CustomerModel> customers) {
        this.customers = customers;
    }

    public ArrayList<UserModel> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(ArrayList<UserModel> allUsers) {
        this.allUsers = allUsers;
    }




}
