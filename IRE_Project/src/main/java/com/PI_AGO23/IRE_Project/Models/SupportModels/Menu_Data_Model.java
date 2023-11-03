package com.PI_AGO23.IRE_Project.Models.SupportModels;

import com.PI_AGO23.IRE_Project.Models.BackModels.smallTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu_Data_Model {
    private List<smallTypes> Dish_Kind_Amount_Info = new ArrayList<>();

    //Constructor

    public Menu_Data_Model() {}

    public Menu_Data_Model(List<smallTypes> dish_Kind_Amount_Info) {
        Dish_Kind_Amount_Info = dish_Kind_Amount_Info;
    }

    //Getters And Setters
    public List<smallTypes> getDish_Kind_Amount_Info() {
        return Dish_Kind_Amount_Info;
    }

    public void setDish_Kind_Amount_Info(List<smallTypes> dish_Kind_Amount_Info) {
        Dish_Kind_Amount_Info = dish_Kind_Amount_Info;
    }

}
