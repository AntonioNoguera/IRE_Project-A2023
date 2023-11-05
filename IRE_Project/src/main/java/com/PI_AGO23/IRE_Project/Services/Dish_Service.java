package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.SupportModels.Extra_Data_Model;
import com.PI_AGO23.IRE_Project.Models.SupportModels.Extra_Support_Model;
import com.PI_AGO23.IRE_Project.Models.SupportModels.Menu_Data_Model;
import com.PI_AGO23.IRE_Project.Models.BackModels.Dish_Model;
import com.PI_AGO23.IRE_Project.Models.GetModels.Get_Dish_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Dish_Model;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Dish_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Dish_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Extra_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.ref.ReferenceQueue;
import java.util.*;

@Service
public class Dish_Service {

    @Autowired
    I_Dish_Repository dishRepository;
    @Autowired
    I_Extra_Repository extraRep;

    public Menu_Data_Model menu = new Menu_Data_Model();

    //Done
    public ArrayList<Get_Dish_Model> get_Dishes(){
        ArrayList<Dish_Model> dishUnformatd = (ArrayList<Dish_Model>) dishRepository.getAllActiveDishes();
        ArrayList<Get_Dish_Model> dishFormatd = new ArrayList<>();

        for(Dish_Model dish: dishUnformatd){
            dishFormatd.add(turnDishGet(dish));
        }

        return dishFormatd;
    }

    public Get_Dish_Model turnDishGet(Dish_Model model){
        Get_Dish_Model getModel = new Get_Dish_Model(model);
        //Complemento
        getModel.setComplement(
                new Extra_Support_Model(
                        model.getComplement_ID(),
                        extraRep.getExtra(model.getComplement_ID()
                        )
                )
        );

        //Tipo
        getModel.setType(
                new Extra_Support_Model(
                        model.getDish_Type(),
                        extraRep.getExtra(model.getDish_Type()
                        )
                )
        );

        //Salsa
        getModel.setSauce(
                new Extra_Support_Model(
                        model.getSauce_ID(),
                        extraRep.getExtra(model.getSauce_ID()
                        )
                )
        );

        //Proteina
        getModel.setProtein(
                new Extra_Support_Model(
                        model.getProtein_ID(),
                        extraRep.getExtra(model.getProtein_ID()
                        )
                )
        );
        return getModel;
    }

    //Get by ID(DONE)
    public ResponseEntity<Get_Dish_Model> get_Dish_By_ID(Long id){
        Optional<Dish_Model> optionalDish = dishRepository.findById(id);
        if (optionalDish.isPresent()){
            if (optionalDish.get().getDish_is_Active()){
                return ResponseEntity.status(HttpStatus.OK).body(turnDishGet(optionalDish.get()));
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(turnDishGet(null));
    }

    public int keyValidation (Dish_Model modelToVerify){
        int a = extraRep.verifyExtra(modelToVerify.getSauce_ID(),1);
        int b = extraRep.verifyExtra(modelToVerify.getProtein_ID(),2);
        int c = extraRep.verifyExtra(modelToVerify.getComplement_ID(),3);
        int d = extraRep.verifyExtra(modelToVerify.getDish_Type(),4);
        int test = a + b + c + d;
        System.out.println(test);
        return (a + b + c + d);
    }

    ArrayList<String> enumMembers = new ArrayList<>(List.of("Frío", "Irrelevante", "Caliente"));

    public boolean VerifyEnumPertenency(String dishTem){
        for(String enu : enumMembers){
            if(enu.equals(dishTem)){
                return true;
            }
        }
        return false;
    }

    //New Dish
    public ResponseEntity<Put_Dish_Model> new_Dish(Post_Dish_Model Dish) throws Exception{
        if(dishRepository.uniqueDish(Dish.getName())==0){
            //ComplementValidation
            if((keyValidation(new Dish_Model(Dish)))==4){
                //Pendient to check if necesary to use all the validations, talking about the enums and the
                if(VerifyEnumPertenency(Dish.getTemperature())){
                    Put_Dish_Model model = new Put_Dish_Model(this.dishRepository.save(new Dish_Model(Dish)));
                    return ResponseEntity.status(HttpStatus.OK).body(model);
                }
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }

    //Metodo que verifica pertenencia al ENUM

    public ResponseEntity<Put_Dish_Model> update_Dish(Put_Dish_Model Request, Long Id){
        Optional<Dish_Model> Dish = dishRepository.findById(Id);

        if(Dish.isPresent()){
            //ID NO EXISTENTE
            Dish_Model DishGet = Dish.get();
            if(VerifyEnumPertenency(Request.getTemperature())){
                System.out.println("SE ENTRA?");
                if(dishRepository.uniqueDish(Request.getName())==0){
                    //Nombre Nuevo
                    DishGet.setDish_Name(Request.getName());
                    DishGet.setDish_Assamble(Request.getAssamble());
                    DishGet.setDish_Temperature(Request.getTemperature());
                    DishGet.setDish_Services(Request.getServices());
                    DishGet.setComplement_ID(Request.getComplement_id());
                    //Date unModifible + 9

                    DishGet.setDish_Rating(Request.getRating());
                    DishGet.setDish_Image_Path(Request.getImage_path());
                    DishGet.setDish_is_Active(Request.getActive());

                    DishGet.setSauce_ID(Request.getSauce_id());
                    DishGet.setProtein_ID(Request.getProtein_id());
                    DishGet.setDish_Type(Request.getType_id());
                    dishRepository.save(DishGet);
                    return ResponseEntity.status(HttpStatus.OK).body(new Put_Dish_Model(DishGet));
                }else{
                    if(DishGet.getDish_Name().equals(Request.getName())){
                        //Actualización del mismo valor
                        DishGet.setDish_Name(Request.getName());
                        DishGet.setDish_Assamble(Request.getAssamble());
                        DishGet.setDish_Temperature(Request.getTemperature());
                        DishGet.setDish_Services(Request.getServices());
                        DishGet.setComplement_ID(Request.getComplement_id());
                        //Date unModifible + 9

                        DishGet.setDish_Rating(Request.getRating());
                        DishGet.setDish_Image_Path(Request.getImage_path());
                        DishGet.setDish_is_Active(Request.getActive());

                        DishGet.setSauce_ID(Request.getSauce_id());
                        DishGet.setProtein_ID(Request.getProtein_id());
                        DishGet.setDish_Type(Request.getType_id());
                        dishRepository.save(DishGet);
                        return ResponseEntity.status(HttpStatus.OK).body(new Put_Dish_Model(DishGet));
                    }
                    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
                }
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }

    public String update_Image_Path(long id, String imagePath){
        Dish_Model dish = dishRepository.findById(id).orElse(null);
        dish.setDish_Image_Path(imagePath);

        dishRepository.save(dish);

        return "Image Path Correctly Updated!";
    }

    //Delete Dish - (Done
    public ResponseEntity<String> delete_Dish(Long Id){
        Optional<Dish_Model> dishDeleted = dishRepository.findById(Id);
        if(dishDeleted.isPresent()){
            if(dishDeleted.get().getDish_is_Active()){
                Dish_Model format = dishDeleted.get();
                format.setDish_is_Active(false);
                dishRepository.save(format);
                return ResponseEntity.status(HttpStatus.OK).body("Dish Succesfully Covered");
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already Disabled Dish");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("null");
    }

    public List<List<List<Integer>>> idGrades = new ArrayList<>();

    //Support Methods
    public List<Integer> Extra_List = List.of(1,2,3);
    public List<List<Long>> getExtrasCount(){
        List<List<Long>> ExtraCount = new ArrayList<>();

        for(int i=0;i<Extra_List.size();i++){
            ExtraCount.add(this.extraRep.getExtrasIDS(i+1));
        }
        return ExtraCount;
    }

    public void getGrades(ArrayList<List<Long>> members){
    }

    public List<String> Extras = List.of("Sauce","Protein","Complement");
}