package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.BackModels.Extra_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Extra_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class Extra_Service {
    @Autowired
    I_Extra_Repository extraRepository;

    /**
     * 6.2.- Get_Extra_By_ID ()
     * 6.3.- Get_Extra_By_Kind ()
     * 6.4.- Get_Extras ()
     * 6.5.- Update_Extra_By_ID ()
     * 6.6.- Delete_Extra ()
     */

    //Obtener Extras
    public ArrayList<Extra_Model> get_Extras(){
        return (ArrayList<Extra_Model>) extraRepository.findAll();
    }

    //Obtener Extra por Id
    public Optional<Extra_Model> get_Extra_ByiD(Long Id){
        return extraRepository.findById(Id);
    }

    //Obtener Extra por tipo
    //Metodo Pendiente

    //Crear Extra
    public Extra_Model new_Extra(Extra_Model Extra){
        return extraRepository.save(Extra);
    }


    //Actualizar Extra
    public Extra_Model update_Extra(Extra_Model Request, Long Id){
        Extra_Model Extra = extraRepository.findById(Id).get();

        Extra.setExtra_Name(Request.getExtra_Name());
        Extra.setExtra_Description(Request.getExtra_Description());
        Extra.setKind_ID(Request.getKind_ID());

        extraRepository.save(Extra);

        return Extra;
    }


    //Eliminar Extra
    public Boolean delete_Extra(Long Id){
        try{
            extraRepository.deleteById(Id);
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
