package com.PI_AGO23.IRE_Project.Controllers;

import com.PI_AGO23.IRE_Project.Models.Dish_Model;
import com.PI_AGO23.IRE_Project.Services.Dish_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Dish")
public class Dish_Controller {
    @Autowired
    private Dish_Service dishService;


    @GetMapping()
    public ArrayList<Dish_Model> Get_Dishes(){
        return this.dishService.get_Dishes();
    }

    @GetMapping(path="/{id}")
    public Optional<Dish_Model> Get_Dish_By_ID(@PathVariable("id") long id){
        return this.dishService.get_Dish_By_ID(id);
    }

    @PostMapping Dish_Model New_Dish(@RequestBody Dish_Model Request){
        return this.dishService.new_Dish(Request);
    }

    @PutMapping(path="/{id}")
    public Dish_Model Update_Dish(@RequestBody Dish_Model Request, @PathVariable("id") long id){
        return this.dishService.update_Dish(Request, id);
    }

    @DeleteMapping(path="/{id}")
    public String Delete_Dish(@PathVariable("id") long id){
        boolean ok = this.dishService.delete_Dish(id);

        if(ok){
            return  "Action Completed!";
        }else{
            return "Action wasn´t Completed!";
        }
    }
}