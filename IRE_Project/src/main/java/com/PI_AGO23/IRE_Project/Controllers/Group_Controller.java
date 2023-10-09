package com.PI_AGO23.IRE_Project.Controllers;

import com.PI_AGO23.IRE_Project.Models.Group_Model;
import com.PI_AGO23.IRE_Project.Services.Group_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/Group")
public class Group_Controller {
    @Autowired
    private Group_Service GroupService;

    @GetMapping
    public ArrayList<Group_Model> Get_Groups(){
        return this.GroupService.get_Groups();
    }

    @GetMapping(path = "/{id}")
    public Optional<Group_Model> Get_Group_By_ID(@PathVariable("id") long Id){
        return this.GroupService.Get_Group_By_ID(Id);
    }

    @PostMapping Group_Model New_Group(@RequestBody Group_Model Group){
        return this.GroupService.new_Group(Group);
    }

    @PutMapping(path="/{id}")
    public Group_Model Update_Group(@RequestBody Group_Model Request, @PathVariable("id") long id){
        return this.GroupService.Update_Group(Request,id);
    }

    @DeleteMapping(path = "/{id}")
    public String Delete_Group(@PathVariable("id") long Id){
        boolean ok = this.GroupService.Delete_Group(Id);

        if(ok){
            return "Action Completed!";
        }else{
            return "Action wasn´t completed!";
        }
    }
}
