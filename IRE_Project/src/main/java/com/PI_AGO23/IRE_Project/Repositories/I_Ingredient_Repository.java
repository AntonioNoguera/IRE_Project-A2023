package com.PI_AGO23.IRE_Project.Repositories;

import com.PI_AGO23.IRE_Project.Models.BackModels.Ingredient_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface I_Ingredient_Repository extends JpaRepository<Ingredient_Model,Long> {


    @Query(value = "SELECT COUNT(*) FROM Ingredient_Table WHERE Ingredient_Name = ?1", nativeQuery = true)
    int countDuplicateIngredients(String name);



}