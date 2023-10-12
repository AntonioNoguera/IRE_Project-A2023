package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.Dish_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Dish_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Extra_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class Dish_Service {

    @Autowired I_Dish_Repository dishRepository;
    @Autowired
    I_Extra_Repository extraRepository;

    /**
     * 1.1.- New_Dish (Crear):
     * 1.2.- Get_Dish_By_ID, x
     * Get_Dishes (Leer): x
     * 1.3.- Update_Dish (Actualizar):
     * 1.4.- Delete_Dish (Actualizar):
     */

    public ArrayList<Dish_Model> get_Dishes(){
        return (ArrayList<Dish_Model>) dishRepository.findAll();
    }

    public Optional<Dish_Model> get_Dish_By_ID(Long id){
        Optional<Dish_Model> optionalDish = dishRepository.findById(id);

        if (optionalDish.isPresent()) {
            Dish_Model dish = optionalDish.get();
            dish.setSauce_Name(extraRepository.getExtra(dish.getSauce_ID()));
            dish.setComplement_Name(extraRepository.getExtra(dish.getComplement_ID()));
            dish.setProtein_Name(extraRepository.getExtra(dish.getProtein_ID()));
            dish.setType_Name(extraRepository.getExtra(dish.getDish_Type()));
            return optionalDish;
        } else {
            // Handle the case where the dish is not found by ID.
            // You can return an empty Optional or take appropriate action.
            return Optional.empty();
        }
    }

    public Dish_Model new_Dish(Dish_Model Dish){
        //Esta fecha no puede ser el día de hoy, se actualiza hasta que se asgina un platillo a la req.

        Dish.setDish_Last_Made(String.valueOf(LocalDateTime.now()));

        return dishRepository.save(Dish);
    }

    public Dish_Model update_Dish(Dish_Model Request, Long Id){
        Dish_Model Dish = dishRepository.findById(Id).get();

        Dish.setDish_Name(Request.getDish_Name());
        Dish.setDish_Assamble(Request.getDish_Assamble());
        Dish.setDish_Temperature(Request.getDish_Temperature());
        Dish.setDish_Services(Request.getDish_Services());
        Dish.setComplement_ID(Request.getComplement_ID());
        Dish.setSauce_ID(Request.getSauce_ID());
        Dish.setProtein_ID(Request.getProtein_ID());
        Dish.setDish_Type(Request.getDish_Type());

        dishRepository.save(Dish);

        return Dish;
    }


    public Boolean delete_Dish(Long Id){
        try{
            dishRepository.deleteById(Id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
