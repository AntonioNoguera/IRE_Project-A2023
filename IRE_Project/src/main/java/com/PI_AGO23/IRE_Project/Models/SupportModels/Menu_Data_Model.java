package com.PI_AGO23.IRE_Project.Models.SupportModels;

import java.util.HashMap;
import java.util.Map;

public class Menu_Data_Model {
    private Map<String,Integer> Dish_Kind_Amount_Info = new HashMap<>();
    private Map<String, Extra_Data_Model> Extra_Info = new HashMap<>();

    //Constructor

    public Menu_Data_Model() {}

    public Menu_Data_Model(Map<String, Integer> dish_Kind_Amount_Info, Map<String, Extra_Data_Model> extra_Info) {
        Dish_Kind_Amount_Info = dish_Kind_Amount_Info;
        Extra_Info = extra_Info;
    }

    //Getters And Setter
    public Map<String, Integer> getDish_Kind_Amount_Info() {
        return Dish_Kind_Amount_Info;
    }

    public void setDish_Kind_Amount_Info(Map<String, Integer> dish_Kind_Amount_Info) {
        Dish_Kind_Amount_Info = dish_Kind_Amount_Info;
    }

    public Map<String, Extra_Data_Model> getExtra_Info() {
        return Extra_Info;
    }

    public void setExtra_Info(Map<String, Extra_Data_Model> extra_Info) {
        Extra_Info = extra_Info;
    }
}
