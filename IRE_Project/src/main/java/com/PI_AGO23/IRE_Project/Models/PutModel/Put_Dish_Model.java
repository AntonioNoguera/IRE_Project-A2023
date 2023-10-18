package com.PI_AGO23.IRE_Project.Models.PutModel;

import com.PI_AGO23.IRE_Project.Models.Dish_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Dish_Model;

import java.time.LocalDateTime;

public class Put_Dish_Model extends Post_Dish_Model {
    private long id;
    private String last_made;
    private long services;
    private int rating;
    private String image_path;
    private String active;

    //Super Constructor
    public Put_Dish_Model(Dish_Model model){

        super(
                model.getDish_Name(),
                model.getDish_Assamble(),
                model.getDish_Temperature(),
                model.getComplement_ID(),
                model.getSauce_ID(),
                model.getProtein_ID(),
                model.getDish_Type()
        );

        id = model.getDish_ID();

        last_made = model.getDish_Last_Made();
        services = model.getDish_Services();
        rating = model.getDish_Rating();
        image_path = model.getDish_Image_Path();
        active = model.getDish_isActive();
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

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}