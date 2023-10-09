package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.Requisition_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Requisition_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class Requisition_Service {
    @Autowired
    I_Requisition_Repository requisitionRepository;

    /**
     * 4.1.- New_Requisition
     * 4.2.- Get_Requisition_By_Id
     * 4.3.- Get_Requisition_By_Date
     * 4.4.- Get_Requisition_By_Week
     */

    //Obtener Requisición por Id
    //InnerJoin
    public Optional<Requisition_Model> get_Requisition_By_ID(Long Id){
        return (Optional<Requisition_Model>) requisitionRepository.findById(Id);
    }

    //Obtener Requisiciones  por Semana
    //Inner Join
    public ArrayList<Requisition_Model> get_Week_Requisition(String dayReference){
        return (ArrayList<Requisition_Model>) requisitionRepository.findAll();
    }


    //Nueva Requisición
    public Requisition_Model new_Requisition(Requisition_Model Requisition){
        return requisitionRepository.save(Requisition);
    }

}
