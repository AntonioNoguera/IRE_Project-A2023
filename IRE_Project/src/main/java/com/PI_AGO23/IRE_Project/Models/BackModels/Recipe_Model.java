package com.PI_AGO23.IRE_Project.Models.BackModels;

import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Recipe_Model;

import javax.persistence.*;

@Entity
@Table(name="Recipe_Table")
public class Recipe_Model {
    //Recipe_ID	Dish_ID	Ingredient_ID	Recipe_Ingredient_Amount
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Recipe_ID;

    @Column(name="Dish_ID") private Long Dish_ID;

    @Column private Long Ingredient_ID;

    @Column private float Recipe_Ingredient_Amount;

    public Recipe_Model() {
    }

    public Recipe_Model(Post_Recipe_Model recipeItem) {
        this.Dish_ID = recipeItem.getDish_id();
        this.Ingredient_ID = recipeItem.getIngredient_id();
        this.Recipe_Ingredient_Amount = recipeItem.getExistence();
    }


    public Long getRecipe_ID() {
        return Recipe_ID;
    }

    public void setRecipe_ID(Long recipe_ID) {
        Recipe_ID = recipe_ID;
    }

    public Long getDish_ID() {
        return Dish_ID;
    }

    public void setDish_ID(Long dish_ID) {
        Dish_ID = dish_ID;
    }

    public Long getIngredient_ID() {
        return Ingredient_ID;
    }

    public void setIngredient_ID(Long ingredient_ID) {
        Ingredient_ID = ingredient_ID;
    }

    public float getRecipe_Existence() {
        return Recipe_Ingredient_Amount;
    }

    public void setRecipe_Ingredient_Amount(float recipe_Ingredient_Amount) {
        Recipe_Ingredient_Amount = recipe_Ingredient_Amount;
    }
}
