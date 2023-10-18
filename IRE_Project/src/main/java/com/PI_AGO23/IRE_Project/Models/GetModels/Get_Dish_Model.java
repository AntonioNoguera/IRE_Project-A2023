package com.PI_AGO23.IRE_Project.Models.GetModels;

import com.PI_AGO23.IRE_Project.Models.SupportModels.Extra_Support_Model;
import com.PI_AGO23.IRE_Project.Models.BackModels.Dish_Model;

public class Get_Dish_Model {
    private long id;
    private String name;
    private String assamble;
    private String temperature;
    private String last_made;
    private long services;
    private int rating;

    private Extra_Support_Model complement;
    private Extra_Support_Model  sauce;
    private Extra_Support_Model  protein;
    private Extra_Support_Model  type;


    //Constructor
    public Get_Dish_Model(){}
    public Get_Dish_Model(Dish_Model model){
            id = model.getDish_ID();
            name = model.getDish_Name();
            assamble = model.getDish_Assamble();
            temperature = model.getDish_Temperature();
            last_made = model.getDish_Last_Made();
            services = model.getDish_Services();
            rating = model.getDish_Rating();
    }

    //Getter and Setter
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAssamble() {
        return assamble;
    }
    public void setAssamble(String assamble) {
        this.assamble = assamble;
    }
    public String getTemperature() {
        return temperature;
    }
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
    public String getLast_made() {
        return last_made;
    }
    public void setLast_made(String last_made) {
        this.last_made = last_made;
    }
    public long getServices() {
        return services;
    }
    public void setServices(long services) {
        this.services = services;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public Extra_Support_Model getComplement() {
        return complement;
    }

    public void setComplement(Extra_Support_Model complement) {
        this.complement = complement;
    }

    public Extra_Support_Model getSauce() {
        return sauce;
    }

    public void setSauce(Extra_Support_Model sauce) {
        this.sauce = sauce;
    }

    public Extra_Support_Model getProtein() {
        return protein;
    }

    public void setProtein(Extra_Support_Model protein) {
        this.protein = protein;
    }

    public Extra_Support_Model getType() {
        return type;
    }

    public void setType(Extra_Support_Model type) {
        this.type = type;
    }
}
