package com.PI_AGO23.IRE_Project.Models.PostModels;

import javax.persistence.Embeddable;

@Embeddable
public class Post_Group_Model {
    private String name;
    private String hexColor;
    private String description;

    //Constructor


    public Post_Group_Model() {
    }

    public Post_Group_Model(String name, String hexColor, String description) {
        this.name = name;
        this.hexColor = hexColor;
        this.description = description;
    }


    //Getter and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHexColor() {
        return hexColor;
    }

    public void setHexColor(String hexColor) {
        this.hexColor = hexColor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
