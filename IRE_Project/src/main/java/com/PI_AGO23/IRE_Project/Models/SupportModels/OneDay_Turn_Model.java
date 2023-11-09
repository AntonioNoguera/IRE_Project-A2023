package com.PI_AGO23.IRE_Project.Models.SupportModels;

import java.util.List;
//SE REGRESA A WEEKLY

public class OneDay_Turn_Model {
    //Clase que
    private int id;
    private String day;
    private List<TurnFormat> food_time;
    //Constructor


    public OneDay_Turn_Model(){}

    public OneDay_Turn_Model(int id, String day, List<TurnFormat> food_time) {
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

    public List<TurnFormat> getFood_time() {
        return food_time;
    }

    public void setFood_time(List<TurnFormat> food_time) {
        this.food_time = food_time;
    }
}
