package com.PI_AGO23.IRE_Project.Repositories;

import com.PI_AGO23.IRE_Project.Models.BackModels.Movement_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface I_Movement_Repository extends JpaRepository<Movement_Model, Long> {


    @Query(value = "Select Movement_Table.Movement_ID AS Movement_ID, \n" +
            "Requisition_Table.Requsition_Day_Name AS Requsition_Day_Name, \n" +
            "Requisition_Table.Requisition_Date AS Requisition_Date, \n" +
            "Dish_Table.Dish_Name AS Dish_Name, \n" +
            "Ingredient_Table.Ingredient_Name AS Ingredient_Name, \n " +
            "Movement_Table.Movement_Amount AS Movement_Amount, \n  " +
            "Ingredient_Table.Ingredient_Unit AS Ingredient_Unit, \n " +
            "Movement_Table.Movement_Time AS Movement_Time\n " +
            " FROM Movement_Table \n " +

            " INNER JOIN Dish_Table ON Movement_Table.Dish_ID = Dish_Table.Dish_ID\n " +
            " INNER JOIN Requisition_Table ON Movement_Table.Requisition_ID = Requisition_Table.Requisition_ID\n " +
            " INNER JOIN Ingredient_Table ON Movement_Table.Ingredient_ID = Ingredient_Table.Ingredient_ID\n " +
            " WHERE Movement_Table.Requisition_ID = ?1",nativeQuery = true)
    List<Object[]> getMovementsByRequisition(long Dish_ID);



}