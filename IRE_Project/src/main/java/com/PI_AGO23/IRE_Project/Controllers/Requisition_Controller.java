package com.PI_AGO23.IRE_Project.Controllers;

import com.PI_AGO23.IRE_Project.Models.BackModels.Requisition_Model;
import com.PI_AGO23.IRE_Project.Services.Requisition_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Requisition")
public class Requisition_Controller {
    @Autowired private Requisition_Service requisitionService;

    @GetMapping(path="/{id}")
    public Optional<Requisition_Model> Get_Requisition_By_ID(@PathVariable("id") long id){
        return this.requisitionService.get_Requisition_By_ID(id);
    }

    //Working on
    @GetMapping()
    public ArrayList<Requisition_Model> Get_Requisition_Week(){
        return (ArrayList<Requisition_Model>) requisitionService.get_Week_Requisition("pending");
    }

    @PostMapping Requisition_Model New_Requisition(@RequestBody Requisition_Model Requisition){
        return this.requisitionService.new_Requisition(Requisition);
    }
}
