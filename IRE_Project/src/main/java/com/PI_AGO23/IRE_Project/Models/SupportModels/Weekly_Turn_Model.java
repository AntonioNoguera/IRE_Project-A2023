package com.PI_AGO23.IRE_Project.Models.SupportModels;

import java.util.List;

public class Weekly_Turn_Model {
    private int id;
    private String day;
    private List<Food_Time_Model> food_time;
    //Constructor


    public Weekly_Turn_Model(){}

    public Weekly_Turn_Model(int id, String day, List<Food_Time_Model> food_time) {
        this.id = id;
        this.day = day;
        this.food_time = food_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<Food_Time_Model> getFood_time() {
        return food_time;
    }

    public void setFood_time(List<Food_Time_Model> food_time) {
        this.food_time = food_time;
    }
}
