package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.GetModels.Get_Ingredient_Model;
import com.PI_AGO23.IRE_Project.Models.Ingredient_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Ingredient_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Group_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Ingredient_Repository;
import com.fasterxml.jackson.databind.deser.UnresolvedId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.springframework.boot.context.properties.bind.Bindable.mapOf;

@Service
public class Ingredient_Service {
    @Autowired
    I_Ingredient_Repository ingredientRepository;

    @Autowired
    I_Group_Repository groupRepository;

    //Obtener Todos los Ingredientes
    public ArrayList<Get_Ingredient_Model> get_Ingredients(){
        ArrayList<Ingredient_Model> Ingredients = (ArrayList<Ingredient_Model>) ingredientRepository.findAll();
        ArrayList<Get_Ingredient_Model> IngredientsFormated = new ArrayList<>();

        for(Ingredient_Model Ingredient: Ingredients){
            Get_Ingredient_Model unitIngredient = new Get_Ingredient_Model(Ingredient);
            unitIngredient.setGroup_name(groupRepository.getGroupName(Ingredient.getGroup_ID()));

            IngredientsFormated.add(unitIngredient);
        }

        return IngredientsFormated;
    }
    //Obtener Un Ingrediente
    public Optional<Ingredient_Model> get_Ingredient_By_ID(Long Id){
        return ingredientRepository.findById(Id);
    }

    //Nuevo Ingrediente
    public Ingredient_Model new_Ingredient(Post_Ingredient_Model Ingredient){
        Ingredient_Model IngredientFormat = new Ingredient_Model(Ingredient);
        IngredientFormat.setIngredient_Last_Used(String.valueOf(LocalDateTime.now()));
        return ingredientRepository.save(IngredientFormat);
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
