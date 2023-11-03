package com.PI_AGO23.IRE_Project.Repositories;

import com.PI_AGO23.IRE_Project.Models.BackModels.Dish_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface I_Dish_Repository extends JpaRepository<Dish_Model,Long> {

        @Query(value = "Select Dish_Name FROM dish_table WHERE Dish_ID = ?1",nativeQuery = true)
        String getDishName(long id);

        @Query(value = "Select Dish_ID FROM dish_table WHERE Dish_is_Active= 1",nativeQuery = true)
        ArrayList<Long> getIdActiveDishes();

        @Query(value = "Select * FROM dish_table WHERE Dish_is_Active = 1",nativeQuery = true)
        ArrayList<Dish_Model> getAllActiveDishes();

        @Query(value="SELECT Dish_ID From dish_table Where Dish_Type=?1", nativeQuery = true)
        List<Integer> getTypeMembers(long id);

        @Query(value = "Select Dish_Rating FROM dish_table WHERE Dish_ID= ?1",nativeQuery = true)
        Integer getDishGrade(Integer id);

        @Query(value = "SELECT COUNT(*) FROM dish_table WHERE Dish_Type=?1 AND Dish_is_Active = 1",nativeQuery = true)
        double getTypeNumber(Long id);

        /**
        @Query(value = "Select COUNT(*) FROM dish_table WHERE :id ",nativeQuery = true)
        Integer verifyColumnPertenency(Integer id, String extraId);
        */

        @Query(value = "SELECT COUNT(*) FROM dish_table WHERE Sauce_ID = :id OR Protein_ID = :id OR Complement_ID = :id OR Dish_Type = :id", nativeQuery = true)
        Integer verifyExtraBeingUsed(@Param("id") long id);

        @Query(value=" SELECT COUNT(*) FROM dish_table WHERE Dish_Name = ?1", nativeQuery = true)
        Integer uniqueDish(String name);
}