package com.PI_AGO23.IRE_Project.Controllers;

import com.PI_AGO23.IRE_Project.Models.MovementJoin_Model;
import com.PI_AGO23.IRE_Project.Models.Movement_Model;
import com.PI_AGO23.IRE_Project.Services.Movement_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@RestController
@RequestMapping("/Movement")
public class Movement_Controller {
    @Autowired private Movement_Service movementService;

    @GetMapping("/{id}")
    public List<MovementJoin_Model> Get_Movements_By_Requisition(@PathVariable("id") long id){
        return this.movementService.get_Movements_By_Requisition(id);
    }

    @GetMapping()
    public List<List<MovementJoin_Model>> Get_All_Movements(){
        return this.movementService.get_Requisitions();
    }

    @PostMapping
    Movement_Model New_Movement(@RequestBody Movement_Model Movement){
        return this.movementService.new_Movement(Movement);
    }

    @PutMapping
    Movement_Model Update_Movement(@RequestBody Movement_Model Movement, @PathVariable("id") long id){
        return this.movementService.update_Requisition(Movement,id);
    }

    @DeleteMapping
    Boolean Delete_Movement(@PathVariable("id") long id){
        return this.movementService.delete_Movement(id);
    }
}
