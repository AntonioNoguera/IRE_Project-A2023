package com.PI_AGO23.IRE_Project.Models.PutModel;

import com.PI_AGO23.IRE_Project.Models.Ingredient_Model;

import javax.persistence.*;

@Embeddable
public class Put_Ingredient_Model {
    private Long id;
    private String name;
    private Integer group_id;
    private Float existence;
    private String unit;
    private String last_used;

    public Put_Ingredient_Model(Ingredient_Model ingredient) {
        id = ingredient.getIngredient_ID();
        name = ingredient.getIngredient_Name();
        group_id = ingredient.getGroup_ID();
        existence = ingredient.getIngredient_Existence();
        unit = ingredient.getIngredient_Unit();
        last_used = ingredient.getIngredient_Last_Used();
    }


    //Getter And Setter

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

    public String getLast_used() {
        return last_used;
    }

    public void setLast_used(String last_used) {
        this.last_used = last_used;
    }
}
