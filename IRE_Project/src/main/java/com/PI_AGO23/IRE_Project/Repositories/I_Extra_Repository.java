package com.PI_AGO23.IRE_Project.Repositories;

import com.PI_AGO23.IRE_Project.Models.BackModels.Extra_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
    List<Long> getExtrasIDS(Integer id);


    //Number Of member
    @Query(value = "SELECT COUNT(*) From Extras_Table Where Kind_ID=?1",nativeQuery = true)
    Integer getNumberOfExtras(long id);

    @Query(value = "SELECT COUNT(*) FROM Extras_Table WHERE Extra_Name = ?1",nativeQuery = true)
    int anotherExtra(String name);
}
