package com.PI_AGO23.IRE_Project.Repositories;

import com.PI_AGO23.IRE_Project.Models.BackModels.Kind_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface I_Kind_Repository extends JpaRepository<Kind_Model,Long>{
    @Query(value = "Select Kind_Name FROM kind_table Where Kind_ID = ?1",nativeQuery = true)
    String getKindName(long id);

    @Query(value = "Select Kind_ID FROM kind_table Where Kind_Name = ?1",nativeQuery = true)
    int getKindID(String id);

}
