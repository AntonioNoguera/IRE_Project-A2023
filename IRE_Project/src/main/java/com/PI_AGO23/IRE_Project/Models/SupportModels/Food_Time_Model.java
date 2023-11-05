package com.PI_AGO23.IRE_Project.Models.SupportModels;

import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Dish_Model;

import java.util.List;
import java.io.Serializable;

public class Food_Time_Model  implements Serializable {
    private int id;
    private String food;
    private List<Put_Dish_Model> members;


    //Constructor
    public Food_Time_Model(int id,String food, List<Put_Dish_Model> members) {
        this.id=id;
        this.food = food;
        this.members = members;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public List<Put_Dish_Model> getMembers() {
        return members;
    }

    public void setMembers(List<Put_Dish_Model> members) {
        this.members = members;
    }
}
