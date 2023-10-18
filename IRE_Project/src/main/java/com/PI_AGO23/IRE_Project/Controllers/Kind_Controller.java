package com.PI_AGO23.IRE_Project.Controllers;

import com.PI_AGO23.IRE_Project.Models.BackModels.Kind_Model;
import com.PI_AGO23.IRE_Project.Services.Kind_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Kind")
public class Kind_Controller {
    @Autowired
    private Kind_Service kindService;


    @GetMapping
    public ArrayList<Kind_Model> Get_Kinds(){
        return this.kindService.get_Kinds();
    }

    @PostMapping Kind_Model New_Kind(@RequestBody Kind_Model Kind){
        return this.kindService.new_Kind(Kind);
    }

    @PutMapping(path = "/{id}")
    public Kind_Model Update_Kind(@RequestBody Kind_Model Request, @PathVariable("id") long Id){
         return this.kindService.update_Kind(Request, Id);
    }

    @DeleteMapping(path = "/{id}")
    public String Delete_Kind(@PathVariable("id") long Id){
        boolean ok = this.kindService.delete_Kind(Id);

        if(ok){
            return "Action completed!";
        }else{
            return "The action wasn´t possible!";
        }
    }
}
