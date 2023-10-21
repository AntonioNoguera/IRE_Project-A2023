package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.GetModels.Get_Group_Model;
import com.PI_AGO23.IRE_Project.Models.BackModels.Group_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Group_Model;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Group_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Group_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class Group_Service {
    @Autowired
    I_Group_Repository groupRepository;

    //Obtener Todos los Grupos
    public ArrayList<Get_Group_Model> get_Groups(){
        ArrayList<Group_Model> modelActive = (ArrayList<Group_Model>) groupRepository.findActiveMembers();
        ArrayList<Get_Group_Model> getActive = new ArrayList<>();
        for(Group_Model member: modelActive){
            Get_Group_Model GetModel = new Get_Group_Model(member);
            getActive.add(GetModel);
        }
        return getActive;
    }

    //Guardar Nuevo Grupo (Validated)
    public ResponseEntity<Put_Group_Model> new_Group(Post_Group_Model Group){
        if(noDupNames(Group.getName())){
            Group_Model postGrupo = new Group_Model(Group);
            groupRepository.save(postGrupo);
            return ResponseEntity.status(HttpStatus.OK).body(new Put_Group_Model(postGrupo));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }

    //Selección de un Grupo(Validated)
    public ResponseEntity<Get_Group_Model> Get_Group_By_ID(Long Id){
        Optional<Group_Model> group = groupRepository.findById(Id);
        if (group.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new Get_Group_Model(group.get()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //Actualización de Grupo
    public ResponseEntity<Put_Group_Model> Update_Group(@org.jetbrains.annotations.NotNull Put_Group_Model Request, Long Id){
        Optional<Group_Model> Group = groupRepository.findById(Id);

        if(Group.isPresent()){
            Group_Model neoGroup = Group.get();
            if(noDupNames(Request.getName())){
                if(Request.getName().equals(neoGroup.getGroup_Name())){
                    neoGroup.setGroup_Name(Request.getName());
                    neoGroup.setGroup_Description(Request.getDescription());
                    neoGroup.setGroup_Hex_Color(Request.getHexColor());
                    neoGroup.setGroup_Is_Active(Request.getIsActive());
                    groupRepository.save(neoGroup);
                    return ResponseEntity.status(HttpStatus.OK).body(new Put_Group_Model(neoGroup));
                }
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    public ResponseEntity<String> Delete_Group(Long Id){
        Optional<Group_Model> GrupoF = groupRepository.findById(Id);
        if(GrupoF.isPresent()){
            if(GrupoF.get().getGroup_Is_Active()){
                Group_Model groupFormatted = GrupoF.get();
                groupFormatted.setGroup_Is_Active(false);
                groupRepository.save( groupFormatted);
                return ResponseEntity.status(HttpStatus.OK).body("Group Disabled with Success!");
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already Inactive Group");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Non-Existence Group");
    }

    //validation functions
    boolean noDupNames(String name){
        if(groupRepository.getGroupsName(name) < 1){
            return true;
        }else{
            return false;
        }
    }
}