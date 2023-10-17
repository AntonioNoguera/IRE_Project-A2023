package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.GetModels.Get_Ingredient_Model;
import com.PI_AGO23.IRE_Project.Models.Ingredient_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Ingredient_Model;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Ingredient_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Group_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Ingredient_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

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
    public Optional<Get_Ingredient_Model> get_Ingredient_By_ID(Long Id){

        Optional<Ingredient_Model> ingredient = ingredientRepository.findById(Id);
        if (ingredient.isPresent()) {
            Ingredient_Model ingredienteReal = ingredient.get();
            Get_Ingredient_Model modeloIngrediente = new Get_Ingredient_Model(ingredienteReal);
            modeloIngrediente.setGroup_name(groupRepository.getGroupName(ingredienteReal.getGroup_ID()));
            return Optional.of(modeloIngrediente);
        } else {
            return Optional.empty();
        }
    }

    //Nuevo Ingrediente
    public Put_Ingredient_Model new_Ingredient(Post_Ingredient_Model Ingredient){
        Ingredient_Model IngredientFormat = new Ingredient_Model(Ingredient);
        IngredientFormat.setIngredient_Last_Used(String.valueOf(LocalDateTime.now()));
        ingredientRepository.save(IngredientFormat);
        return new Put_Ingredient_Model(IngredientFormat);
    }

    //Actualizar Ingrediente
    public Put_Ingredient_Model update_Ingredient(Post_Ingredient_Model Request, Long Id){
        Ingredient_Model Ingredient = ingredientRepository.findById(Id).get();

        Ingredient.setIngredient_Name(Request.getName());
        Ingredient.setGroup_ID(Request.getGroup_id());
        Ingredient.setIngredient_Unit(Request.getUnit());

        //None Modified Values

        ingredientRepository.save(Ingredient);

        return new Put_Ingredient_Model(Ingredient);
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
