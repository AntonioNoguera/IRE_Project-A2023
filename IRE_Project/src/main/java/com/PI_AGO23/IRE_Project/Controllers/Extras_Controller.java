package com.PI_AGO23.IRE_Project.Controllers;

import com.PI_AGO23.IRE_Project.Models.BackModels.Extra_Model;
import com.PI_AGO23.IRE_Project.Models.GetModels.Get_Extra_Model;
import com.PI_AGO23.IRE_Project.Services.Extra_Service;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Extra")
public class Extras_Controller {
    @Autowired
    private Extra_Service extraService;

    @GetMapping
    public ArrayList<Extra_Model> Get_Extras(){
        return this.extraService.get_Extras();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Get_Extra_Model> Get_Extra_By_ID(@PathVariable("id") long Id){
        return this.extraService.get_Extra_ByiD(Id);
    }

    @PostMapping
    public Extra_Model New_Extra(@RequestBody Extra_Model Extra){
        return this.extraService.new_Extra(Extra);

    }

    @PutMapping(path = "/{id}")
    public Extra_Model Update_Extra (@RequestBody Extra_Model Request, @PathVariable("id") long Id){
        return this.extraService.update_Extra(Request,Id);
    }

    @DeleteMapping(path = "/{id}")
    public String Delete_Extra(@PathVariable("id") Long Id){
        boolean ok = this.extraService.delete_Extra(Id);

        if(ok){
            return "Action Completed!";
        }else{
            return "Action wasn´t completed!";
        }
    }
}
