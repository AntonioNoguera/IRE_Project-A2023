package com.PI_AGO23.IRE_Project.Models.Automatization;

import java.util.Map;

public class Dish_Distribution_Model {

    private Map<String,Dish_String_Model> Active_Dishes;
    private Map<String,Dish_String_Model> Idle_Dishes;
    private double Mean_Grade_Dishes;
    private double Std_Deviation_Dish;

    //Contructor


    public Dish_Distribution_Model() { }

    public Dish_Distribution_Model(Map<String, Dish_String_Model>
                                            active_Dishes, Map<String,
                                            Dish_String_Model> idle_Dishes,
                                            double mean_Grade_Dishes,
                                            double std_Deviation_Dish) {
        Active_Dishes = active_Dishes;
        Idle_Dishes = idle_Dishes;
        Mean_Grade_Dishes = mean_Grade_Dishes;
        Std_Deviation_Dish = std_Deviation_Dish;
    }

    //Getters and Setters

    public Map<String, Dish_String_Model> getActive_Dishes() {
        return Active_Dishes;
    }

    public void setActive_Dishes(Map<String, Dish_String_Model> active_Dishes) {
        Active_Dishes = active_Dishes;
    }

    public Map<String, Dish_String_Model> getIdle_Dishes() {
        return Idle_Dishes;
    }

    public void setIdle_Dishes(Map<String, Dish_String_Model> idle_Dishes) {
        Idle_Dishes = idle_Dishes;
    }

    public double getMean_Grade_Dishes() {
        return Mean_Grade_Dishes;
    }

    public void setMean_Grade_Dishes(double mean_Grade_Dishes) {
        Mean_Grade_Dishes = mean_Grade_Dishes;
    }

    public double getStd_Deviation_Dish() {
        return Std_Deviation_Dish;
    }

    public void setStd_Deviation_Dish(double std_Deviation_Dish) {
        Std_Deviation_Dish = std_Deviation_Dish;
    }
}
