package com.PI_AGO23.IRE_Project.Repositories;

import com.PI_AGO23.IRE_Project.Models.BackModels.Dish_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface I_Dish_Repository extends JpaRepository<Dish_Model,Long> {

        @Query(value = "Select Dish_ID FROM Dish_Table WHERE Dish_isActive= 1",nativeQuery = true)
        ArrayList<Long> getIdActiveDishes();

        @Query(value="SELECT Dish_ID From Dish_Table Where Dish_Type=?1", nativeQuery = true)
        List<Integer> getTypeMembers(long id);

        @Query(value = "Select Dish_Rating FROM Dish_Table WHERE Dish_ID= ?1",nativeQuery = true)
        Integer getDishGrade(Integer id);
}