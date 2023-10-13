package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.Automatization.Extra_Data_Model;
import com.PI_AGO23.IRE_Project.Models.Automatization.Menu_Data_Model;
import com.PI_AGO23.IRE_Project.Models.Dish_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Dish_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Extra_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Image_pseudoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Dish_Service {

    @Autowired I_Dish_Repository dishRepository;
    @Autowired
    I_Extra_Repository extraRep;



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

    public Dish_Model new_Dish(Dish_Model Dish) throws Exception{
        //Esta fecha no puede ser el día de hoy, se actualiza hasta que se asgina un platillo a la req.
        Dish.setDish_Image_Path("IRE_Project\\src\\main\\esources\\images\\default.png");
        //Este proceso debe de ser bien verificado
        Dish.setDish_Last_Made(String.valueOf(LocalDateTime.now()));

        return dishRepository.save(Dish);
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

    //Support Methods
    public List<Integer> Extra_List = List.of(1,2,3);
    public List<List<Integer>> getExtrasCount(){
        List<List<Integer>> ExtraCount = new ArrayList<>();

        for(Integer ExtraMember : Extra_List){
            ExtraCount.add(this.extraRep.getExtrasIDS(ExtraMember));
        }

        return ExtraCount;
    }

    public Menu_Data_Model preProcessing(){
        //Dish Type Related
        List<Long> Types = this.extraRep.getDish_Types_ID();
        List<String> NameTypes= new ArrayList<>();


        //Extra Related
        //Salsa = 1, Proteina = 2, Complementos = 3
        List<String> Extras = List.of("Sauce","Protein","Complement");
        List<List<Integer>> ExtrasCount = this.getExtrasCount();

        //Data Model
        Menu_Data_Model HashMenuModel = new Menu_Data_Model();
        // Map<String, List<Map<Integer, String>>>

        for(int i=0;i<Extras.size();i++){
            List<Extra_Data_Model> Ex = new ArrayList<>();
            for(int j=0;j<ExtrasCount.get(i).size(); j++){
                Ex.add(new Extra_Data_Model(ExtrasCount.get(i).get(j),this.extraRep.getExtra(ExtrasCount.get(i).get(j))));
            }
            HashMenuModel.Extra_Info.put(Extras.get(i),Ex);
        }


        for(long Type: Types){
            HashMenuModel.Dish_Kind_Amount_Info.put(this.extraRep.getExtra(Type),this.extraRep.getNumberOfExtras(Type));
        }

        return HashMenuModel;
    }


}
