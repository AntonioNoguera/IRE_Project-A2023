package com.PI_AGO23.IRE_Project.Repositories;

import com.PI_AGO23.IRE_Project.Models.Dish_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface I_Dish_Repository extends JpaRepository<Dish_Model,Long> {

        @Query(value = "Select Dish_ID FROM Dish_Table WHERE Dish_isActive= 1",nativeQuery = true)
        ArrayList<Long> getIdActiveDishes();

        @Query(value="SELECT COUNT(*) From Dish_Table Where Dish_Type=?1", nativeQuery = true)
        Integer getNameDish(long id);
}