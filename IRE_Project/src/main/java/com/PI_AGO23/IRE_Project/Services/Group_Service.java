package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.Group_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Group_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class Group_Service {
    @Autowired
    I_Group_Repository groupRepository;

    //Obtener Todos los Grupos
    public ArrayList<Group_Model> get_Groups(){
        return (ArrayList<Group_Model>) groupRepository.findAll();
    }

    //Guardar Nuevo Grupo
    public Group_Model new_Group(Group_Model Group){
        Group.setGroup_Is_Active(true);
        return groupRepository.save(Group);
    }

    //Selección de un Grupo
    public Optional<Group_Model> Get_Group_By_ID(Long Id){
        return groupRepository.findById(Id);
    }

    //Actualización de Grupo
    public Group_Model Update_Group(@org.jetbrains.annotations.NotNull Group_Model Request, Long Id){
        Group_Model Group = groupRepository.findById(Id).get();

        Group.setGroup_Name(Request.getGroup_Name());
        Group.setGroup_Description(Request.getGroup_Description());
        Group.setGroup_Hex_Color(Request.getGroup_Hex_Color());

        groupRepository.save(Group);

        return Group;
    }

    public Boolean Delete_Group(Long Id){
        try{
            groupRepository.deleteById(Id);
            return true;
        }catch(Exception e){
            return false;
    //Eliminar Grupo
        }
    }

}
