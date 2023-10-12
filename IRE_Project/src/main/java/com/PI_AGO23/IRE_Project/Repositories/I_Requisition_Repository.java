package com.PI_AGO23.IRE_Project.Repositories;

import com.PI_AGO23.IRE_Project.Models.Requisition_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface I_Requisition_Repository extends JpaRepository<Requisition_Model, Long> {
    @Query(value = "Select Requisition_ID FROM Requisition_Table",nativeQuery = true)
    ArrayList<Long> getRequisitions();

}