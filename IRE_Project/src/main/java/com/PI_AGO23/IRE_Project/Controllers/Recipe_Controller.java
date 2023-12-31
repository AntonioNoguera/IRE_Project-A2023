package com.PI_AGO23.IRE_Project.Controllers;

import com.PI_AGO23.IRE_Project.Models.BackModels.RecipeJoin_Model;
import com.PI_AGO23.IRE_Project.Models.BackModels.Recipe_Model;
import com.PI_AGO23.IRE_Project.Models.GetModels.Get_Recipe_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Recipe_Model;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Recipe_Model;
import com.PI_AGO23.IRE_Project.Models.SupportModels.smallPost_Ingredient;
import com.PI_AGO23.IRE_Project.Services.Recipe_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Recipe")
public class Recipe_Controller {
    @Autowired private Recipe_Service recipeService;

    @GetMapping
    public List<Get_Recipe_Model> Get_Recipes(){
        return this.recipeService.get_Recipes();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Get_Recipe_Model> Get_Recipe_Ingredients(@PathVariable("id") long id){
        return this.recipeService.get_Recipe_By_Dish(id);
    }

    @PostMapping ResponseEntity<Put_Recipe_Model> new_Recipe_Ingredient(@RequestBody Post_Recipe_Model Recipe){
        return this.recipeService.add_Ingredient(Recipe);

    }

    @PostMapping(path="/{id}")
    public String New_Recipe_Ingredients(@RequestBody List<smallPost_Ingredient> Recipe, @PathVariable("id") long id){
        return this.recipeService.add_Ingredients(Recipe,id);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<String> Delete_Specific_Item(@PathVariable("id") long id){
        return this.recipeService.deleteItem(id);
    }
}
