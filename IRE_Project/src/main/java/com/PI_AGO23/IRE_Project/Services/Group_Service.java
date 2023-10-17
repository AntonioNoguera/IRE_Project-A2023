package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.GetModels.Get_Group_Model;
import com.PI_AGO23.IRE_Project.Models.GetModels.Get_Ingredient_Model;
import com.PI_AGO23.IRE_Project.Models.Group_Model;
import com.PI_AGO23.IRE_Project.Models.Ingredient_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Group_Model;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Group_Model;
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
    public ArrayList<Get_Group_Model> get_Groups(){
        ArrayList<Group_Model> modelActive= (ArrayList<Group_Model>) groupRepository.findActiveMembers();
        ArrayList<Get_Group_Model> getActive = new ArrayList<>();
        for(Group_Model member: modelActive){
            Get_Group_Model GetModel = new Get_Group_Model(member);
            getActive.add(GetModel);
        }
        return getActive;
    }

    //Guardar Nuevo Grupo
    public Put_Group_Model new_Group(Post_Group_Model Group){
        Group_Model postGrupo = new Group_Model(Group);
        groupRepository.save(postGrupo);
        return new Put_Group_Model(postGrupo);
    }

    //Selección de un Grupo
    public Optional<Get_Group_Model> Get_Group_By_ID(Long Id){
        Optional<Group_Model> group = groupRepository.findById(Id);
        if (group.isPresent()) {
            Group_Model groupModel = group.get();
            Get_Group_Model getModel = new Get_Group_Model(groupModel);
            return Optional.of(getModel);
        } else {
            return Optional.empty();
        }
    }

    //Actualización de Grupo
    public Put_Group_Model Update_Group(@org.jetbrains.annotations.NotNull Put_Group_Model Request, Long Id){
        Group_Model Group = groupRepository.findById(Id).get();

        Group.setGroup_Name(Request.getName());
        Group.setGroup_Description(Request.getDescription());
        Group.setGroup_Hex_Color(Request.getHexColor());
        Group.setGroup_Is_Active(Request.getIsActive());

        groupRepository.save(Group);



        return new Put_Group_Model(Group);
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
