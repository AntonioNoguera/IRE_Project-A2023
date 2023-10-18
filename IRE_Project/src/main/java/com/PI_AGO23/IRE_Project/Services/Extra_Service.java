package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.BackModels.Extra_Model;
import com.PI_AGO23.IRE_Project.Models.GetModels.Get_Extra_Model;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Dish_Model;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Extra_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Extra_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Kind_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class Extra_Service {
    @Autowired
    I_Extra_Repository extraRepository;

    @Autowired
    I_Kind_Repository kindRepository;


    //Obtener Extras
    public ArrayList<Extra_Model> get_Extras(){
        return (ArrayList<Extra_Model>) extraRepository.findAll();
    }

    //Obtener Extra por Id
    public ResponseEntity<Get_Extra_Model> get_Extra_ByiD(Long Id){
        Optional<Extra_Model> extraM = extraRepository.findById(Id);
        if(extraM.isPresent()){
            Get_Extra_Model getModel = new Get_Extra_Model(extraM.get());
            getModel.setKind_name(kindRepository.getKindName(getModel.getKind_id()));
            return ResponseEntity.status(HttpStatus.OK).body(getModel);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    //Obtener Extra por tipo
    //Metodo Pendiente

    //Crear Extra
    public ResponseEntity<Put_Extra_Model> new_Extra(Extra_Model Extra){

        if(!repitedExtra(Extra)){
            extraRepository.save(Extra);
            return ResponseEntity.status(HttpStatus.OK).body(new Put_Extra_Model(Extra));
        }

        //Extra repetido
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);

    }

    public boolean repitedExtra(Extra_Model model){
        return extraRepository.anotherExtra(model.getExtra_Name()) >= 1;
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
