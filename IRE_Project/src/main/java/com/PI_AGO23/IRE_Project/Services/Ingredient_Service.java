package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.Ingredient_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Ingredient_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class Ingredient_Service {
    @Autowired
    I_Ingredient_Repository ingredientRepository;

    //Obtener Todos los Ingredientes
    public ArrayList<Ingredient_Model> get_Ingredients(){
        return (ArrayList<Ingredient_Model>) ingredientRepository.findAll();
    }
    //Obtener Un Ingrediente
    public Optional<Ingredient_Model> get_Ingredient_By_ID(Long Id){
        return ingredientRepository.findById(Id);
    }

    //Nuevo Ingrediente
    public Ingredient_Model new_Ingredient(Ingredient_Model Ingredient){
        return ingredientRepository.save(Ingredient);
    }

    //Actualizar Ingrediente
    public Ingredient_Model update_Ingredient(Ingredient_Model Request, Long Id){
        Ingredient_Model Ingredient = ingredientRepository.findById(Id).get();

        Ingredient.setIngredient_Name(Request.getIngredient_Name());
        Ingredient.setGroup_ID(Request.getGroup_ID());
        Ingredient.setIngredient_Unit(Request.getIngredient_Unit());

        ingredientRepository.save(Ingredient);

        return Ingredient;
    }

    //Eliminar Ingrediente
    public Boolean Delete_Ingredient(Long id){
        try{
            ingredientRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
