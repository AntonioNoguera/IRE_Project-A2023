package com.PI_AGO23.IRE_Project.Repositories;

import com.PI_AGO23.IRE_Project.Models.Extra_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface I_Extra_Repository extends JpaRepository<Extra_Model, Long> {

    @Query(value = "Select Extra_Name FROM Extras_Table Where Extras_ID = ?1",nativeQuery = true)
    String getExtra(long id);
}
