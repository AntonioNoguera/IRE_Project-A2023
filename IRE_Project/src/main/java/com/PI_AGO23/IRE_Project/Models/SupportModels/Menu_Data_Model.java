package com.PI_AGO23.IRE_Project.Models.SupportModels;

import com.PI_AGO23.IRE_Project.Models.BackModels.smallTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu_Data_Model {
    private List<smallTypes> Dish_Distribution = new ArrayList<>();
    private List<smallTypes> Assamble_Distribution = new ArrayList<>();

    private List<smallTypes> Temperature_Distribution = new ArrayList<>();

    //Constructor
    public Menu_Data_Model() {}
    public Menu_Data_Model(List<smallTypes> dish_Kind_Amount_Info, List<smallTypes> assamble_Info, List<smallTypes> Temp) {
        Dish_Distribution = dish_Kind_Amount_Info;
        Assamble_Distribution = assamble_Info;
        Temperature_Distribution = Temp;
    }

    //Getters And SetterS

    public List<smallTypes> getDish_Distribution() {
        return Dish_Distribution;
    }

    public void setDish_Distribution(List<smallTypes> dish_Kind_Distribution) {
        Dish_Distribution = dish_Kind_Distribution;
    }

    public List<smallTypes> getAssamble_Distribution() {
        return Assamble_Distribution;
    }

    public void setAssamble_Distribution(List<smallTypes> assamble_Distribution) {
        Assamble_Distribution = assamble_Distribution;
    }

    public List<smallTypes> getTemperature_Distribution() {
        return Temperature_Distribution;
    }

    public void setTemperature_Distribution(List<smallTypes> temperature_Distribution) {
        Temperature_Distribution = temperature_Distribution;
    }
}
