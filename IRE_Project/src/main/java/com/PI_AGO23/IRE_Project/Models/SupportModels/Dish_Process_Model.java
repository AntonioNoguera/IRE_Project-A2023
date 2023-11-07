package com.PI_AGO23.IRE_Project.Models.SupportModels;

import com.PI_AGO23.IRE_Project.Models.BackModels.Dish_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Dish_Model;

public class Dish_Process_Model extends Post_Dish_Model {
    private long id;
    private String last_made;
    private int rating;
    private double aptitude;

    //Constructor
    public Dish_Process_Model(){}

    public Dish_Process_Model(Dish_Model model) {
        super(
                model.getDish_Name(),
                model.getDish_Assamble(),
                model.getDish_Temperature(),
                model.getComplement_ID(),
                model.getSauce_ID(),
                model.getProtein_ID(),
                model.getDish_Type()
        );
        this.id=model.getDish_ID();
        this.last_made=model.getDish_Last_Made();
        this.rating=model.getDish_Rating();
    }

    //Getter and Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLast_made() {
        return last_made;
    }

    public void setLast_made(String last_made) {
        this.last_made = last_made;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getAptitude() {
        return aptitude;
    }

    public void setAptitude(double aptitude) {
        this.aptitude = aptitude;
    }
}