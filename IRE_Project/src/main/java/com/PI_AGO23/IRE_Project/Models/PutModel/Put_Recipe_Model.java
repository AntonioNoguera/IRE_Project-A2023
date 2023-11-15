package com.PI_AGO23.IRE_Project.Models.PutModel;

import com.PI_AGO23.IRE_Project.Models.BackModels.Recipe_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Recipe_Model;

public class Put_Recipe_Model extends Post_Recipe_Model {
    private Long id;

    Put_Recipe_Model(){}

    public Put_Recipe_Model(Recipe_Model recipe){
        super(recipe.getDish_ID(),recipe.getIngredient_ID(),recipe.getRecipe_Ingredient_Amount());
        this.id=recipe.getRecipe_ID();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
