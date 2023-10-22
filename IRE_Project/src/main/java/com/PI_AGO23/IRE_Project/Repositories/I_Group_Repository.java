package com.PI_AGO23.IRE_Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.PI_AGO23.IRE_Project.Models.BackModels.Group_Model;

import java.util.ArrayList;

@Repository
public interface I_Group_Repository extends JpaRepository<Group_Model,Long> {

    @Query(value = "Select Group_Name FROM group_table WHERE Group_ID= ?1",nativeQuery = true)
    String getGroupName(Integer id);

    @Query(value="SELECT COUNT(*) FROM group_table WHERE Group_Name = ?1",nativeQuery = true)
    int getGroupsName(String name);

    @Query(value = "Select * FROM group_table WHERE Group_Is_Active= true",nativeQuery = true)
    ArrayList<Group_Model> findActiveMembers();
}