package com.PI_AGO23.IRE_Project.Controllers;

import com.PI_AGO23.IRE_Project.Models.BackModels.postMenuModel;
import com.PI_AGO23.IRE_Project.Models.SupportModels.Menu_Data_Model;
import com.PI_AGO23.IRE_Project.Models.SupportModels.Weekly_Turn_Model;
import com.PI_AGO23.IRE_Project.Services.Automatization_Service;
import com.PI_AGO23.IRE_Project.Services.Dish_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Automatization")
public class Automatization_Controller {
    @Autowired
    private Automatization_Service autoService;

    @GetMapping
    public Menu_Data_Model displayPercentages(){
        return this.autoService.gettingStuff();
    }

    @PostMapping
    public List<Weekly_Turn_Model> generateMenu(@RequestBody postMenuModel instructions){
        return this.autoService.generate(instructions);
    }
}
