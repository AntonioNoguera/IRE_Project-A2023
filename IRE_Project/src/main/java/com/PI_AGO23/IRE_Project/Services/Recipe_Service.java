package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.Recipe_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Recipe_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class Recipe_Service {
    @Autowired
    I_Recipe_Repository recipeRepository;



    //5.1.- Add_Ingredient(Crear):
    //Recipe_Table(Dish_ID,Ingredient_ID,Recipe_Ingredient_Amount)
    public Recipe_Model add_Ingredient(Recipe_Model Ingredient){
        return recipeRepository.save(Ingredient);
    }

    //5.1.1.- Add Ingredients:
    //Bucle con iteraciones, lo que principalmente realiza es un bucle con el metodo de arriba
    public String add_Ingredients(ArrayList<Recipe_Model> Ingredient_List){
        for (Recipe_Model recipeModel : Ingredient_List) {
            try {
                add_Ingredient(recipeModel);
            }catch (Exception e){
                return "Problem with the ingredient " + recipeModel+ "Verify no double items";
            }

        }
        return "Process Done with sucess!";
    }

    //5.2.- Get_Recipes: (Muy probablemente en forma de matriz o en hashmap
    public ArrayList<Recipe_Model> get_Recipes(){
        //Metodo que tiene que contar los platillos activos
        //Metodo que tiene que agrupar los platillos activos
        //Bucle que ejecuta el metodo 5.3 en bucle;
        return (ArrayList<Recipe_Model>) recipeRepository.findAll();
    }

    //5.3.- Get_Recipe_Ingredient_By_Dish
    public ArrayList<Recipe_Model> get_Recipe_By_Dish(Long Id){
        return recipeRepository.findByDishID(Id);
    }
    //5.4.- Update_Recipe
    //Metodo de creación de un nuevo platillo;
}
