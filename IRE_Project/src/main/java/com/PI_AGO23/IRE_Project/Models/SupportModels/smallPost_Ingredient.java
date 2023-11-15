package com.PI_AGO23.IRE_Project.Models.SupportModels;

public class smallPost_Ingredient {
    private Long ingredient_id;
    private float amount;

    public smallPost_Ingredient(Long ingredient_id, float amount) {
        this.ingredient_id = ingredient_id;
        this.amount = amount;
    }

    public Long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
