package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.BackModels.postMenuModel;
import com.PI_AGO23.IRE_Project.Models.BackModels.smallTypes;
import com.PI_AGO23.IRE_Project.Models.SupportModels.Dish_String_Model;
import com.PI_AGO23.IRE_Project.Models.SupportModels.Menu_Data_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Dish_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Extra_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Automatization_Service {

    @Autowired
    I_Dish_Repository dishRepository;
    @Autowired
    I_Extra_Repository extraRep;
    public Menu_Data_Model gettingStuff(){
        //Dish Type Related
        List<Long> Types = this.extraRep.getDish_Types_ID();

        //Totalidad
        int totalPlatos = this.dishRepository.getIdActiveDishes().size();

        //Data Model
        Menu_Data_Model HashMenuModel = new Menu_Data_Model();

        //Lector de tipos
        for(int i=0;i<Types.size();i++){
            double nTipo = this.dishRepository.getTypeNumber(Types.get(i));
            HashMenuModel.getDish_Distribution().add(
                new smallTypes(
                        Types.get(i),
                        this.extraRep.getExtra(Types.get(i)),
                        (nTipo/totalPlatos)*100
                )
            );
        }

        //Seleccionando Armado o No
        for(int i=0; i<2;i++){
            HashMenuModel.getAssamble_Distribution().add(
                new smallTypes(
                        i,
                    "inferedType",
                    ((double) this.dishRepository.getAssambled(i)/totalPlatos)*100
                )
            );
        }

        //Seleccionando Temperatura
        String[] tempTipos={"Frío","Irrelevante","Caliente"};
        for(int i=0; i<3;i++){
            HashMenuModel.getTemperature_Distribution().add(
                    new smallTypes(
                            i,
                            tempTipos[i],
                            ((double) this.dishRepository.getTemperture(tempTipos[i])/totalPlatos)*100
                    )
            );
        }

        return HashMenuModel;
    }

    public postMenuModel generate(postMenuModel jsonObject){
        return jsonObject;

        /**
        List<List<Dish_String_Model>> menu = new ArrayList<>();

        for(int i=0;i<jsonObject.getTurnsOfDay().size();i++){
            //menu.get(i).add(

                    return(jsonObject.getTurnsOfDay().get(i));
        }

        return "";
         **/
    }
}
