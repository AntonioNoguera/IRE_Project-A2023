package com.PI_AGO23.IRE_Project.Models.PostModels;

import com.PI_AGO23.IRE_Project.Models.SupportModels.smallPost_Ingredient;

public class Post_Recipe_Model {
    private Long dish_id;
    private Long ingredient_id;
    private float existence;

    //Constructor

    public Post_Recipe_Model() {
    }

    public Post_Recipe_Model(Long dish_id, Long ingredient_id, float existence) {
        this.dish_id = dish_id;
        this.ingredient_id = ingredient_id;
        this.existence = existence;
    }

    public Post_Recipe_Model(Post_Recipe_Model model) {
        this.dish_id = model.getDish_id();
        this.ingredient_id = model.getIngredient_id();
        this.existence = model.getExistence();
    }

    public Post_Recipe_Model(Long dish_id, smallPost_Ingredient model) {
        this.dish_id = dish_id;
        this.ingredient_id = model.getIngredient_id();
        this.existence = model.getExistence();
    }

    //Getter And Setter

    public Long getDish_id() {
        return dish_id;
    }

    public void setDish_id(Long dish_id) {
        this.dish_id = dish_id;
    }

    public Long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public float getExistence() {
        return existence;
    }

    public void setExistence(float existence) {
        this.existence = existence;
    }
}
