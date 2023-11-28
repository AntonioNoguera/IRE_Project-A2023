package com.PI_AGO23.IRE_Project.Repositories;

import com.PI_AGO23.IRE_Project.Models.BackModels.Ingredient_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface I_Ingredient_Repository extends JpaRepository<Ingredient_Model,Long> {


    @Query(value = "SELECT COUNT(*) FROM ingredient_table WHERE Ingredient_Name = ?1", nativeQuery = true)
    int countDuplicateIngredients(String name);

    @Query(value = "SELECT Ingredient_Is_Active FROM ingredient_table WHERE Ingredient_ID = ?1", nativeQuery = true)
    boolean verifyActiveIngredient(long id);

    @Query(value = "SELECT * FROM ingredient_table WHERE Ingredient_Is_Active = 1", nativeQuery = true)
    ArrayList<Ingredient_Model> findAllActiveMembers();

    @Query(value = "SELECT Ingredient_Name FROM ingredient_table WHERE Ingredient_ID = ?1", nativeQuery = true)
    String getName(long id);

    @Query(value = "SELECT Ingredient_Unit FROM ingredient_table WHERE Ingredient_ID = ?1", nativeQuery = true)
    String getUnit(long id);

    @Query(value = "SELECT Group_ID FROM ingredient_table WHERE Ingredient_ID = ?1", nativeQuery = true)
    Long getGroupID(long id);
}