package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.BackModels.RecipeJoin_Model;
import com.PI_AGO23.IRE_Project.Models.BackModels.Recipe_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Dish_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Recipe_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Recipe_Service {
    @Autowired
    I_Recipe_Repository recipeRepository;

    @Autowired
    I_Dish_Repository dishRepository;



    //5.1.- Add_Ingredient(Crear):
    public Recipe_Model add_Ingredient(Recipe_Model Ingredient){
        return recipeRepository.save(Ingredient);
    }

    //5.1.1.- Add Ingredients:
    public String add_Ingredients(List<Recipe_Model> Ingredient_List, Long DishId){
        for (Recipe_Model recipeModel : Ingredient_List) {
            try {
                recipeModel.setDish_ID(DishId);
                add_Ingredient(recipeModel);
            }catch (Exception e){
                return "Problem with the ingredient " + recipeModel+ "Verify no double items";
            }

        }
        return "Process Done with sucess!";
    }

    //5.2.- Get_Recipes: (Muy probablemente en forma de matriz o en hashmap
    public List<List<RecipeJoin_Model>> get_Recipes(){
        ArrayList<Long> activeDishes = dishRepository.getIdActiveDishes();
        List<List<RecipeJoin_Model>> allRecipies = new ArrayList<>();

        for (Long activeDish : activeDishes) {
            allRecipies.add(get_Recipe_By_Dish(activeDish));
        }

        return allRecipies;
    }

    //5.3.- Get_Recipe_Ingredient_By_Dish
    public List<RecipeJoin_Model> get_Recipe_By_Dish(Long Id){
        List<Object[]> results = recipeRepository.getRecipeById(Id);
        List<RecipeJoin_Model> recipes = new ArrayList<>();

        for (Object[] result : results) {
            RecipeJoin_Model recipe = new RecipeJoin_Model(
                    (int) result[0],  // Recipe_ID
                    (String) result[1],  // Dish_Name
                    (String) result[2],  // Ingredient_Name
                    (float) result[3],  // Recipe_Ingredient_Amount
                    (String) result[4]  // Ingredient_Unit
            );
            recipes.add(recipe);
        }
    return recipes;
    }
    //5.4.- Update_Recipe
    //Metodo de creación de un nuevo platillo;
}
