package com.PI_AGO23.IRE_Project.Models.BackModels;

import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Dish_Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="Dish_Table")
public class Dish_Model {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Dish_ID;

    @Column private String Dish_Name;
    @Column private boolean Dish_Assamble;
    @Column private String Dish_Temperature;
    @Column private String Dish_Last_Made;
    @Column private long Dish_Services;
    @Column private int Dish_Rating;
    @Column private long Complement_ID;
    @Column private long Sauce_ID;
    @Column private long Protein_ID;
    @Column private long Dish_Type;
    @Column private String Dish_Image_Path;
    @Column private boolean Dish_isActive;

    //Constructor
    public Dish_Model(){}

    public Dish_Model(Post_Dish_Model model){
        Dish_Name = model.getName();
        Dish_Assamble = model.getAssamble();
        Dish_Temperature = model.getTemperature();

        Dish_Last_Made = String.valueOf(LocalDateTime.now());
        Dish_Services = 0;
        Dish_Rating = 0;
        Dish_isActive = true;


        Complement_ID = model.getComplement_id();
        Sauce_ID = model.getSauce_id();
        Protein_ID = model.getProtein_id();
        Dish_Type = model.getType_id();

        Dish_Image_Path = "IRE_Project\\src\\main\\esources\\images\\default.png";
    }

    //Getters And Setters - Atributos Reales
    public Long getDish_ID() {
        return Dish_ID;
    }

    public void setDish_ID(Long dish_ID) {
        Dish_ID = dish_ID;
    }

    public String getDish_Name() {
        return Dish_Name;
    }

    public void setDish_Name(String dish_Name) {
        Dish_Name = dish_Name;
    }

    public boolean getDish_Assamble() {
        return Dish_Assamble;
    }

    public void setDish_Assamble(boolean dish_Assamble) {
        Dish_Assamble = dish_Assamble;
    }

    public String getDish_Temperature() {
        return Dish_Temperature;
    }

    public void setDish_Temperature(String dish_Temperature) {
        Dish_Temperature = dish_Temperature;
    }

    public String getDish_Last_Made() {
        return Dish_Last_Made;
    }

    public void setDish_Last_Made(String dish_Last_Made) {
        Dish_Last_Made = dish_Last_Made;
    }

    public long getDish_Services() {
        return Dish_Services;
    }

    public void setDish_Services(long dish_Services) {
        Dish_Services = dish_Services;
    }

    public int getDish_Rating() {
        return Dish_Rating;
    }

    public void setDish_Rating(int dish_Rating) {
        Dish_Rating = dish_Rating;
    }

    public long getSauce_ID() {
        return Sauce_ID;
    }

    public void setSauce_ID(long sauce_ID) {
        Sauce_ID = sauce_ID;
    }

    public long getProtein_ID() {
        return Protein_ID;
    }

    public void setProtein_ID(long protein_ID) {
        Protein_ID = protein_ID;
    }

    public long getDish_Type() {
        return Dish_Type;
    }

    public void setDish_Type(long dish_Type) {
        Dish_Type = dish_Type;
    }

    public long getComplement_ID() {
        return Complement_ID;
    }

    public void setComplement_ID(long complement_ID) {
        Complement_ID = complement_ID;
    }

    public String getDish_Image_Path() {
        return Dish_Image_Path;
    }

    public void setDish_Image_Path(String dish_Image_Path) {
        Dish_Image_Path = dish_Image_Path;
    }

    public boolean getDish_isActive() {
        return Dish_isActive;
    }

    public void setDish_isActive(boolean dish_isActive) {
        Dish_isActive = dish_isActive;
    }
}