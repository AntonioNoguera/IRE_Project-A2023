package com.PI_AGO23.IRE_Project.Repositories;

import com.PI_AGO23.IRE_Project.Models.Movement_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface I_Movement_Repository extends JpaRepository<Movement_Model, Long> {

    @Query(value = "Select ?1",nativeQuery = true)
     List<Object> getMovementByRequisition(Long id);
}