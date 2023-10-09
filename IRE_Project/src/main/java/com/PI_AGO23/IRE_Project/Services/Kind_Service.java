package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.Kind_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Kind_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class Kind_Service {
    @Autowired
    I_Kind_Repository kindRepository;

    //Obtener Typos
    public ArrayList<Kind_Model> get_Kinds(){
        return (ArrayList<Kind_Model>) kindRepository.findAll();
    }

    //Nuevo Tipo
    public Kind_Model new_Kind(Kind_Model Kind){
        return kindRepository.save(Kind);
    }

    //Actualizar Tipo
    public Kind_Model update_Kind(Kind_Model Request, Long id){
        Kind_Model Kind = kindRepository.findById(id).get();

        Kind.setKind_Name(Kind.getKind_Name());

        kindRepository.save(Kind);

        return Kind;
    }

    //Eliminar Tipo
    public Boolean delete_Kind(Long id){
        try{
            kindRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
