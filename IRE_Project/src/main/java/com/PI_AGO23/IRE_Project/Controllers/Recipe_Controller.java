package com.PI_AGO23.IRE_Project.Controllers;

import com.PI_AGO23.IRE_Project.Models.Ingredient_Model;
import com.PI_AGO23.IRE_Project.Models.Recipe_Model;
import com.PI_AGO23.IRE_Project.Services.Recipe_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Recipe")
public class Recipe_Controller {
    @Autowired private Recipe_Service recipeService;

    @GetMapping(path = "/{id}")
    public ArrayList<Recipe_Model> Get_Recipe_Ingredients(@PathVariable("id") long id){
        return this.recipeService.get_Recipe_By_Dish(id);
    }
}
