package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.Automatization.Extra_Data_Model;
import com.PI_AGO23.IRE_Project.Models.Automatization.Menu_Data_Model;
import com.PI_AGO23.IRE_Project.Models.Dish_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Dish_Model;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Dish_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Dish_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Extra_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Image_pseudoRepo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class Dish_Service {

    @Autowired I_Dish_Repository dishRepository;
    @Autowired
    I_Extra_Repository extraRep;

    public Menu_Data_Model menu = new Menu_Data_Model();

    public ArrayList<Dish_Model> get_Dishes(){
        return (ArrayList<Dish_Model>) dishRepository.findAll();
    }

    public Optional<Dish_Model> get_Dish_By_ID(Long id){
        Optional<Dish_Model> optionalDish = dishRepository.findById(id);

        if (optionalDish.isPresent()) {
            Dish_Model dish = optionalDish.get();
            dish.setV_Sauce_Name(extraRep.getExtra(dish.getSauce_ID()));
            dish.setV_Complement_Name(extraRep.getExtra(dish.getComplement_ID()));
            dish.setV_Protein_Name(extraRep.getExtra(dish.getProtein_ID()));
            dish.setV_Type_Name(extraRep.getExtra(dish.getDish_Type()));
            return optionalDish;
        } else {
            // Handle the case where the dish is not found by ID.
            // You can return an empty Optional or take appropriate action.
            return Optional.empty();
        }
    }

    public Put_Dish_Model new_Dish(Post_Dish_Model Dish) throws Exception{

        Dish_Model model = dishRepository.save(new Dish_Model(Dish));
        return new Put_Dish_Model(model);
    }

    public Dish_Model update_Dish(Dish_Model Request, Long Id){
        Dish_Model Dish = dishRepository.findById(Id).get();

        Dish.setDish_Name(Request.getDish_Name());
        Dish.setDish_Assamble(Request.getDish_Assamble());
        Dish.setDish_Temperature(Request.getDish_Temperature());
        Dish.setDish_Services(Request.getDish_Services());
        Dish.setComplement_ID(Request.getComplement_ID());
        Dish.setSauce_ID(Request.getSauce_ID());
        Dish.setProtein_ID(Request.getProtein_ID());
        Dish.setDish_Type(Request.getDish_Type());

        dishRepository.save(Dish);

        return Dish;
    }

    public String update_Image_Path(long id, String imagePath){
        Dish_Model dish = dishRepository.findById(id).orElse(null);
        dish.setDish_Image_Path(imagePath);

        dishRepository.save(dish);

        return "Image Path Correctly Updated!";
    }

    public Boolean delete_Dish(Long Id){
        try{
            dishRepository.deleteById(Id);
            return true;
        }catch (Exception e){
            return false;
        }
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
    public Menu_Data_Model preProcessing(){
        //Dish Type Related
        List<Long> Types = this.extraRep.getDish_Types_ID();


        //Extra Related
        //Salsa = 1, Proteina = 2, Complementos = 3
        List<List<Long>> ExtrasCount = this.getExtrasCount();

        //Data Model
        Menu_Data_Model HashMenuModel = new Menu_Data_Model();

        //Lector de extras
        for(int i=0;i<Extras.size();i++){
            List<Extra_Data_Model> Ex = new ArrayList<>();
            for(int j=0;j<ExtrasCount.get(i).size(); j++){

                HashMenuModel.getExtra_Info().put(
                        Extras.get(i),
                        new Extra_Data_Model(ExtrasCount.get(i).get(j),
                                this.extraRep.getExtra(ExtrasCount.get(i).get(j))
                        ));
            }
        }


        //Lector de tipos
        idGrades.clear();
        for(int i=0;i<Types.size();i++){
            List<Integer> members = this.dishRepository.getTypeMembers(Types.get(i));
            HashMenuModel.getDish_Kind_Amount_Info().put(
                    this.extraRep.getExtra(Types.get(i)),
                    members.size()

            );

            List<List<Integer>> idAndGradeLevel = new ArrayList<>();
            //Arranque media y stdDev
            for(int j=0;j<members.size();j++){
                idAndGradeLevel.add(List.of(
                                members.get(j),
                                this.dishRepository.getDishGrade(members.get(j))
                        )
                );

            }


            idGrades.add(idAndGradeLevel);

        }

        menu = HashMenuModel;
        return HashMenuModel;
    }

    public String getActives() {
        String debug="";
        //List<String> Types = dishRepository.
        Map<String,Extra_Data_Model> DishesInDB = new HashMap<String, Extra_Data_Model>();
        if(!idGrades.isEmpty()){
            int limite = idGrades.size();
            for(int i=0; i<limite; i++){
                for(int j=0;j<idGrades.get(i).size();j++){
                    debug+= idGrades.get(i).get(j).get(0).toString() +"-";
                    //Dish_Type - Dish_String_Model
                    //DishesInDB.put(Types.get(i),new Extra_Data_Model());
                }

            }
        }

        return debug;
    }
}