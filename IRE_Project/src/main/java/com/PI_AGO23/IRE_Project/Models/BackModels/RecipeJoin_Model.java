package com.PI_AGO23.IRE_Project.Models.BackModels;

import javax.persistence.*;

@Entity
public class RecipeJoin_Model {
    @Id
    private int Recipe_ID;
    @Column
    private String Dish_Name;
    @Column private String Ingredient_Name;
    @Column float Recipe_Ingredient_Amount;
    @Column private String Ingredient_Unit;

    public RecipeJoin_Model(int recipe_ID, String dish_Name, String ingredient_Name,
                            float recipe_Ingredient_Amount, String ingredient_Unit) {
        this.Recipe_ID = recipe_ID;
        this.Dish_Name = dish_Name;
        this.Ingredient_Name = ingredient_Name;
        this.Recipe_Ingredient_Amount = recipe_Ingredient_Amount;
        this.Ingredient_Unit = ingredient_Unit;
    }

    public int getRecipe_ID() {
        return Recipe_ID;
    }

    public void setRecipe_ID(int recipe_ID) {
        Recipe_ID = recipe_ID;
    }

    public String getDish_Name() {
        return Dish_Name;
    }

    public void setDish_Name(String dish_Name) {
        Dish_Name = dish_Name;
    }

    public String getIngredient_Name() {
        return Ingredient_Name;
    }

    public void setIngredient_Name(String ingredient_Name) {
        Ingredient_Name = ingredient_Name;
    }

    public float getRecipe_Ingredient_Amount() {
        return Recipe_Ingredient_Amount;
    }

    public void setRecipe_Ingredient_Amount(float recipe_Ingredient_Amount) {
        Recipe_Ingredient_Amount = recipe_Ingredient_Amount;
    }

    public String getIngredient_Unit() {
        return Ingredient_Unit;
    }

    public void setIngredient_Unit(String ingredient_Unit) {
        Ingredient_Unit = ingredient_Unit;
    }
}