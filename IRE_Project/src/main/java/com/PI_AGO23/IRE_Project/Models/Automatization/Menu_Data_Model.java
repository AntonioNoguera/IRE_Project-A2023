package com.PI_AGO23.IRE_Project.Models.Automatization;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Menu_Data_Model {
    public Map<String,Integer> Dish_Kind_Amount_Info = new HashMap<>();
    public Map<String, List<Map<Integer, String>>> Extra_Info = new HashMap<>();


    //Constructor

    //Getters And Setter
}
