package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.BackModels.RecipeJoin_Model;
import com.PI_AGO23.IRE_Project.Models.BackModels.Recipe_Model;
import com.PI_AGO23.IRE_Project.Models.BackModels.smallRecipes;
import com.PI_AGO23.IRE_Project.Models.GetModels.Get_Recipe_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Dish_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Ingredient_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Recipe_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Recipe_Service {
    @Autowired
    I_Recipe_Repository recipeRepository;

    @Autowired
    I_Dish_Repository dishRepository;

    @Autowired
    I_Ingredient_Repository ingredientRepository;

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
    public List<Get_Recipe_Model> get_Recipes(){
        ArrayList<Long> activeDishes = dishRepository.getIdActiveDishes();
        List<Get_Recipe_Model> allRecipies = new ArrayList<>();

        for (Long activeDish : activeDishes) {

           if(get_Recipe_By_Dish(activeDish).getBody()!=null){
               allRecipies.add(get_Recipe_By_Dish(activeDish).getBody());
           }
        }

        return allRecipies;
    }

    //5.3.- Get_Recipe_Ingredient_By_Dish - ON WORK
    public ResponseEntity<Get_Recipe_Model> get_Recipe_By_Dish(Long Id){
        List<Recipe_Model> results = recipeRepository.getRecipeById(Id);

        if (!results.isEmpty()){
            Get_Recipe_Model recipes = new Get_Recipe_Model(Id,dishRepository.getDishName(Id));
            List<smallRecipes> formatMembers = new ArrayList<smallRecipes>();

            for (Recipe_Model result : results) {
                smallRecipes recipe = new smallRecipes(
                        result.getRecipe_ID(),  // id
                        ingredientRepository.getName(result.getIngredient_ID()),  // name
                        result.getRecipe_Ingredient_Amount(),  // amount
                        ingredientRepository.getUnit(result.getIngredient_ID())  // unit Get Unit from Ingredient table
                );
                formatMembers.add(recipe);
            }

            recipes.setIngredients(formatMembers);

            return ResponseEntity.status(HttpStatus.OK).body(recipes);
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);


    }
    //5.4.- Update_Recipe
    //Metodo de creación de un nuevo platillo;
}
