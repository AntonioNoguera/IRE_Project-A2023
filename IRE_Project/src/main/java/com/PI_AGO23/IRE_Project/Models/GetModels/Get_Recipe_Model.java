package com.PI_AGO23.IRE_Project.Models.GetModels;

import com.PI_AGO23.IRE_Project.Models.BackModels.smallRecipes;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

public class Get_Recipe_Model {
    private Long id;
    private String dish;

    private List<smallRecipes> ingredients;


    //Constructors
    public Get_Recipe_Model(Long id, String Name){
        this.id = id;
        this.dish = Name;
    }

    //Getter and setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public List<smallRecipes> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<smallRecipes> elements) {
        this.ingredients = elements;
    }
}
