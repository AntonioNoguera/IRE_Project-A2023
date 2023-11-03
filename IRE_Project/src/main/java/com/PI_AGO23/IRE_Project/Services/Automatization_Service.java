package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.BackModels.smallTypes;
import com.PI_AGO23.IRE_Project.Models.SupportModels.Menu_Data_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Dish_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Extra_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
            HashMenuModel.getDish_Kind_Amount_Info().add(
                    new smallTypes(
                            Types.get(i),
                            this.extraRep.getExtra(Types.get(i)),
                            (nTipo/totalPlatos)*100
                    )
            );
        }

        return HashMenuModel;
    }
}
