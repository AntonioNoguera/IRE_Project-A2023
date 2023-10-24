package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.BackModels.Extra_Model;
import com.PI_AGO23.IRE_Project.Models.BackModels.RecipeJoin_Model;
import com.PI_AGO23.IRE_Project.Models.BackModels.smallExtras;
import com.PI_AGO23.IRE_Project.Models.GetModels.Get_All_Extras;
import com.PI_AGO23.IRE_Project.Models.GetModels.Get_Extra_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Extra_Model;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Dish_Model;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Extra_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Dish_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Extra_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Kind_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Extra_Service {
    @Autowired
    I_Extra_Repository extraRepository;

    @Autowired
    I_Kind_Repository kindRepository;

    @Autowired
    I_Dish_Repository dishRepository;

    //Obtener Extras
    public Get_All_Extras get_Extras(){
        Get_All_Extras getExtras = new Get_All_Extras();

        for(int i=1;i<=4;i++){
            List<Object[]> extrasFromType = extraRepository.getExtrasFromType(i);
            List<smallExtras> formated = new ArrayList<>();

            for(Object[] objT : extrasFromType){
                formated.add(
                        new smallExtras(
                                (int) objT[0],
                                (String) objT[1]
                        )
                );
            }

            switch (i) {
                case 1 -> getExtras.setSauces(formated);
                case 2 -> getExtras.setProteins(formated);
                case 3 -> getExtras.setComplements(formated);
                case 4 -> getExtras.setTypes(formated);
                default -> {
                }
            }
        }
        return getExtras;
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

    //Crear Extra (Done)
    public ResponseEntity<Put_Extra_Model> new_Extra(Post_Extra_Model Extra){
        if(!repitedExtra(Extra.getName())){
            if(kindRepository.getKindName(Extra.getKind_id())!=null){
               //Verificar la existencia del kind id
                Extra_Model modelFormated = new Extra_Model(Extra);
                extraRepository.save(modelFormated);
                return ResponseEntity.status(HttpStatus.OK).body(new Put_Extra_Model(modelFormated));
            }
            //
            return  ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
        //Extra repetido
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }

    public boolean repitedExtra(String nameExtra){
        return extraRepository.anotherExtra(nameExtra) >= 1;
    }

    //Actualizar Extra (Done)
    public ResponseEntity<Put_Extra_Model> update_Extra(Post_Extra_Model Request, Long Id) {
        Optional<Extra_Model> Extra = extraRepository.findById(Id);

        if (Extra.isPresent()) {
            Extra_Model extraUpdate = Extra.get();
            if (!repitedExtra(Request.getName())) {

                extraUpdate.setExtra_Name(Request.getName());
                extraUpdate.setExtra_Description(Request.getDescription());
                extraUpdate.setKind_ID(Request.getKind_id());
                extraRepository.save(extraUpdate);

                return ResponseEntity.status(HttpStatus.OK).body(new Put_Extra_Model(extraUpdate));

            } else {
                if (Request.getName().equals(extraUpdate.getExtra_Name())) {

                    //SE REPITE EL ATRIBUTO, PERTENECE A LA MISMA PETICIÓN
                    extraUpdate.setExtra_Name(Request.getName());
                    extraUpdate.setExtra_Description(Request.getDescription());
                    extraUpdate.setKind_ID(Request.getKind_id());
                    extraRepository.save(extraUpdate);

                    return ResponseEntity.status(HttpStatus.OK).body(new Put_Extra_Model(extraUpdate));

                }
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    //Eliminar Extra (Done)
    public ResponseEntity<String> delete_Extra(Long Id){
        Optional<Extra_Model> modelDeleted = extraRepository.findById(Id);
        if(modelDeleted.isPresent()){
            if(!(dishRepository.verifyExtraBeingUsed(Id)<1)){
                //The extra is not being used!
                extraRepository.deleteById(Id);
                return ResponseEntity.status(HttpStatus.OK).body("Extra was deleted Succesfully");
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Extra is being used, need replacement");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Extra Not Found");
    }
}
