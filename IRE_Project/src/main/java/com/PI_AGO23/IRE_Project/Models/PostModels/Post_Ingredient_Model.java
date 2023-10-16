package com.PI_AGO23.IRE_Project.Models.PostModels;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Post_Ingredient_Model {

    private String name;
    private Integer group_id;
    private Float existence;
    private String unit;

    public Post_Ingredient_Model() {
    }

    public Post_Ingredient_Model(String ingredient_Name, Integer group_Id, Float ingredient_Existence, String ingredient_Unit) {
        name = ingredient_Name;
        group_id = group_Id;
        existence = ingredient_Existence;
        unit = ingredient_Unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Float getExistence() {
        return existence;
    }

    public void setExistence(Float existence) {
        this.existence = existence;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
