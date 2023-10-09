package com.PI_AGO23.IRE_Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.PI_AGO23.IRE_Project.Models.Group_Model;

@Repository
public interface I_Group_Repository extends JpaRepository<Group_Model,Long> { }