package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.GetModels.Get_Ingredient_Model;
import com.PI_AGO23.IRE_Project.Models.Ingredient_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Ingredient_Model;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Dish_Model;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Ingredient_Model;
import com.PI_AGO23.IRE_Project.Models.SupportModels.Response_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Group_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Ingredient_Repository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
    public ResponseEntity<Get_Ingredient_Model> get_Ingredient_By_ID(Long Id){

        Optional<Ingredient_Model> ingredient = ingredientRepository.findById(Id);
        if (ingredient.isPresent()) {
            Ingredient_Model ingredienteReal = ingredient.get();
            Get_Ingredient_Model modeloIngrediente = new Get_Ingredient_Model(ingredienteReal);
            modeloIngrediente.setGroup_name(groupRepository.getGroupName(ingredienteReal.getGroup_ID()));
            return ResponseEntity.status(HttpStatus.OK).body(modeloIngrediente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //Nuevo Ingrediente(400,500,419)
    public ResponseEntity<Put_Ingredient_Model> new_Ingredient(Post_Ingredient_Model Ingredient){
        Ingredient_Model IngredientFormat = new Ingredient_Model(Ingredient);
        IngredientFormat.setIngredient_Last_Used(String.valueOf(LocalDateTime.now()));
        if(ingredientExists(IngredientFormat)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new Put_Ingredient_Model(IngredientFormat));
        }else{
            ingredientRepository.save(IngredientFormat);
            return ResponseEntity.status(HttpStatus.OK).body(new Put_Ingredient_Model(IngredientFormat));

        }
    }

    //if duplicated method
    private boolean ingredientExists(Ingredient_Model ingredient) {
        return ingredientRepository.countDuplicateIngredients(ingredient.getIngredient_Name()) > 0;
    }

    //Actualizar Ingrediente
    public ResponseEntity<Put_Ingredient_Model> update_Ingredient(Post_Ingredient_Model Request, Long Id){
        Optional<Ingredient_Model> Ingredient = Optional.of(ingredientRepository.findById(Id).get());

        Ingredient.get().setIngredient_Name(Request.getName());
        Ingredient.get().setGroup_ID(Request.getGroup_id());

        if(!(groupRepository.getGroupName(Request.getGroup_id()) == null)){
            Ingredient.get().setIngredient_Unit(Request.getUnit());
            //None Modified Values
            ingredientRepository.save(Ingredient.get());
            return ResponseEntity.status(HttpStatus.OK).body(new Put_Ingredient_Model(Ingredient.get()));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);

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
