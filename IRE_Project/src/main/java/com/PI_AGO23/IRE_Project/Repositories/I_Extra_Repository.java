package com.PI_AGO23.IRE_Project.Repositories;

import com.PI_AGO23.IRE_Project.Models.Extra_Model;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface I_Extra_Repository extends JpaRepository<Extra_Model, Long> {

    @Query(value = "Select Extra_Name FROM Extras_Table Where Extras_ID = ?1",nativeQuery = true)
    String getExtra(long id);



    //Maybe this r irrelevant Methods, but they´re necessary to have a more readable code

    //Dish Types Getter
    @Query(value = "Select Extras_ID From Extras_Table Where Kind_ID=4", nativeQuery = true)
    List<Long> getDish_Types_ID();

    @Query(value = "Select Extras_ID From Extras_Table Where Kind_ID=?1", nativeQuery = true)
    List<Integer> getExtrasIDS(Integer id);


    //Number Of member
    @Query(value = "SELECT COUNT(*) From Extras_Table Where Kind_ID=?1",nativeQuery = true)
    Integer getNumberOfExtras(long id);


}
