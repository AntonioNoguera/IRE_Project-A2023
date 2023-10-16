package com.PI_AGO23.IRE_Project.Models.PostModels;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Post_Ingredient_Model {

    private String Ingredient_Name;
    private Integer Group_ID;
    private Float Ingredient_Existence;
    private String Ingredient_Unit;

    public Post_Ingredient_Model() {
    }

    public Post_Ingredient_Model(String ingredient_Name, Integer group_Id, Float ingredient_Existence, String ingredient_Unit) {
        Ingredient_Name = ingredient_Name;
        Group_ID = group_Id;
        Ingredient_Existence = ingredient_Existence;
        Ingredient_Unit = ingredient_Unit;
    }

    public String getIngredient_Name() {
        return Ingredient_Name;
    }

    public void setIngredient_Name(String ingredient_Name) {
        Ingredient_Name = ingredient_Name;
    }

    public Integer getGroup_Id() {
        return Group_ID;
    }

    public void setGroup_Id(Integer group_Id) {
        Group_ID = group_Id;
    }

    public Float getIngredient_Existence() {
        return Ingredient_Existence;
    }

    public void setIngredient_Existence(Float ingredient_Existence) {
        Ingredient_Existence = ingredient_Existence;
    }

    public String getIngredient_Unit() {
        return Ingredient_Unit;
    }

    public void setIngredient_Unit(String ingredient_Unit) {
        Ingredient_Unit = ingredient_Unit;
    }
}
