package com.PI_AGO23.IRE_Project.Models.SupportModels;

public class smallPost_Ingredient {
    private Long ingredient_id;
    private float existence;

    public smallPost_Ingredient(Long ingredient_id, float existence) {
        this.ingredient_id = ingredient_id;
        this.existence = existence;
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
