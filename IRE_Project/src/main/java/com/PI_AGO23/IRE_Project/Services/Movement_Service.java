package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.MovementJoin_Model;
import com.PI_AGO23.IRE_Project.Models.Movement_Model;
import com.PI_AGO23.IRE_Project.Models.RecipeJoin_Model;
import com.PI_AGO23.IRE_Project.Models.Recipe_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Movement_Repository;
import org.aspectj.apache.bcel.classfile.ExceptionTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

@Service
public class Movement_Service {
    @Autowired
    I_Movement_Repository movementRepository;

    //8.1.- Insert_Movement()
    public Movement_Model new_Movement(Movement_Model Movement){
        return movementRepository.save(Movement);
    }

    //8.2.- Get_Movements_By_Requisition()
    public List<MovementJoin_Model> get_Movement_By_Requisition(Long id){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");

        List<Object[]> Movements = movementRepository.getMovementsByRequisition(id);
        List<MovementJoin_Model> JoinMovements= new ArrayList<>();
        for (Object[] Movement : Movements) {
            MovementJoin_Model moves = new MovementJoin_Model(
                    (int) Movement[0],  // Recipe_ID
                    (String) Movement[1],  // Dish_Name
                    dateFormat1.format(Movement[2]),  // Ingredient_Name
                    (String) Movement[3],  // Recipe_Ingredient_Amount
                    (String) Movement[4],
                    (float) Movement[5],
                    (String) Movement[6],  // Recipe_Ingredient_Amount
                    dateFormat.format(Movement[7]) // Ingredient_Unit
            );

            JoinMovements.add(moves);

        }
         return JoinMovements;
    }

    /**
    //8.2.1.- Get Mo
     public List<List<Object>> get_Requisitions(){
        long tilin=1;
        return (List<List<Object>>) movementRepository.findById(tilin);
    }

    */

    //8.3.- Update_Movement()
    public Movement_Model update_Requisition(Movement_Model Request, Long id){
        Movement_Model movement = movementRepository.findById(id).get();

        movement.setRequisition_ID(Request.getRequisition_ID());
        movement.setIngredient_ID(Request.getIngredient_ID());
        movement.setMovement_Amount(Request.getMovement_Amount());

        //Must be a code changed
        movement.setMovement_Time(Request.getMovement_Time());

        movement.setDish_ID(Request.getDish_ID());

        movementRepository.save(movement);

        return movement;

    }

    //8.4.- Delete_Movement()
    public Boolean delete_Movement(Long id){
        try{
            movementRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }

    }



}
