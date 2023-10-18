package com.PI_AGO23.IRE_Project.Models.PutModel;

import com.PI_AGO23.IRE_Project.Models.BackModels.Group_Model;

import javax.persistence.Embeddable;

@Embeddable
public class Put_Group_Model {
    private Long id;
    private String name;
    private String description;
    private String hexColor;
    private Boolean isActive;


    public Put_Group_Model(){}

    //Constructor
    public Put_Group_Model(Group_Model model){
        id = model.getGroup_ID();
        name= model.getGroup_Name();
        description= model.getGroup_Description();
        hexColor=model.getGroup_Hex_Color();
        isActive=model.getGroup_Is_Active();
    }



    //Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHexColor() {
        return hexColor;
    }

    public void setHexColor(String hexColor) {
        this.hexColor = hexColor;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        isActive = isActive;
    }
}
