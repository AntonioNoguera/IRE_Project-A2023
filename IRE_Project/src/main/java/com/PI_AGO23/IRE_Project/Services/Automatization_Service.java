package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.BackModels.Dish_Model;
import com.PI_AGO23.IRE_Project.Models.BackModels.postMenuModel;
import com.PI_AGO23.IRE_Project.Models.BackModels.smallTypes;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Dish_Model;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Dish_Model;
import com.PI_AGO23.IRE_Project.Models.SupportModels.*;
import com.PI_AGO23.IRE_Project.Repositories.I_Dish_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Extra_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
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

    public List<Dish_Map_Model> generate(postMenuModel jsonObject){
        List<Food_Time_Model> test = new ArrayList<>();
        test. add(new Food_Time_Model(
                1,
                "Desayuno",
                List.of(new Put_Dish_Model( this.dishRepository.findById(1L).get()))
        ));

        test. add(new Food_Time_Model(
                2,
                "Comida",
                List.of(new Put_Dish_Model( this.dishRepository.findById(2L).get()))
        ));

        //Variable de Retorno
        List<Weekly_Turn_Model> menu = new ArrayList<>();

        //Variable de Proceseo
        List<Dish_Map_Model> distribution = new ArrayList<>();


        //PROCESAMIENTO
        List<Dish_Map_Model> dishMap = new ArrayList<>();

        for(int i=0;i<jsonObject.getTurnFormat().size();i++){
            List<Dish_Model> model = this.dishRepository.getSpecificType(jsonObject.getTurnFormat().get(i).getId());

            //RETURN VAR


            List<Dish_Process_Model> members = new ArrayList<>();
            double mean=0;
            double m2 = 0.0;
            double std=0;
            int n = 0;

            for(Dish_Model modelUnit : model){
                n++;
                double delta = modelUnit.getDish_Rating() - mean;
                mean += delta / n;
                double delta2 = modelUnit.getDish_Rating() - mean;
                m2 += delta * delta2;
                members.add(new Dish_Process_Model(modelUnit));
            }

            double desviacionEstandar = Math.sqrt(m2 / (n - 1));
            //Es muestral
            if (Double.isNaN(desviacionEstandar)) {
                desviacionEstandar=-1;
            }
            dishMap.add(
                    new Dish_Map_Model(
                        jsonObject.getTurnFormat().get(i).getId(),
                        members,
                        mean,
                        desviacionEstandar
                    )
            );
        }

        //CREANDO RETORNO

        return dishMap;
    }
}
