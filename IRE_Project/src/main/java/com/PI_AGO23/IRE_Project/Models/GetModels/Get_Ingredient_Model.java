package com.PI_AGO23.IRE_Project.Models.GetModels;

import com.PI_AGO23.IRE_Project.Models.Ingredient_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Group_Repository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Embeddable;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.boot.context.properties.bind.Bindable.mapOf;

@Embeddable
public class Get_Ingredient_Model {

    private Long id;
    private String name;
    private Integer group_id;
    private String group_name;
    private Float existence;
    private String unit;

    //Constructor
    public Get_Ingredient_Model() {
    }

    public Get_Ingredient_Model(Ingredient_Model Model) {
        id = Model.getIngredient_ID();
        name = Model.getIngredient_Name();
        group_id = Model.getGroup_ID();
        existence = Model.getIngredient_Existence();
        unit = Model.getIngredient_Unit();
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

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
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