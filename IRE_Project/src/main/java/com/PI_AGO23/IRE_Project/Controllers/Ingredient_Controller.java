package com.PI_AGO23.IRE_Project.Controllers;

import com.PI_AGO23.IRE_Project.Models.GetModels.Get_Ingredient_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Ingredient_Model;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Ingredient_Model;
import com.PI_AGO23.IRE_Project.Services.Ingredient_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Ingredient")
public class Ingredient_Controller {


    @Autowired private Ingredient_Service ingredientService;

    @GetMapping
    public ArrayList<Get_Ingredient_Model> Get_Ingredients(){
        return this.ingredientService.get_Ingredients();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Get_Ingredient_Model> Get_Ingredient_By_ID(@PathVariable("id") long id){
        return this.ingredientService.get_Ingredient_By_ID(id);
    }

    //MANUAL API DEFINITIONS :C
    @PostMapping
    public ResponseEntity<Put_Ingredient_Model> New_Ingredient(@RequestBody Post_Ingredient_Model Ingredient){
        return this.ingredientService.new_Ingredient(Ingredient);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Put_Ingredient_Model> Update_Ingredient(@RequestBody Post_Ingredient_Model Request, @PathVariable("id") long id){
        return this.ingredientService.update_Ingredient(Request,id);
    }

    @DeleteMapping(path = "/{id}")
    public String Delete_Ingredient(@PathVariable("id") long Id){
        boolean ok = this.ingredientService.Delete_Ingredient(Id);

        if(ok){
            return "Action Completed!";
        }else{
            return "Action Wasn´t Completed!";
        }
    }
}
