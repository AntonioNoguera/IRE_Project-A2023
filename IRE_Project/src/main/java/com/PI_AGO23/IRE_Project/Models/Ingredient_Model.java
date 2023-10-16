package com.PI_AGO23.IRE_Project.Models;

import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Ingredient_Model;

import javax.persistence.*;

@Entity
@Table(name="Ingredient_Table")
public class Ingredient_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Ingredient_ID;
    @Column private String Ingredient_Name;
    @Column private Integer Group_ID;
    @Column private Float Ingredient_Existence;
    @Column private String Ingredient_Unit;
    @Column private String Ingredient_Last_Used;


    public Ingredient_Model() {
    }

    public Ingredient_Model(Post_Ingredient_Model Model) {
        Ingredient_Name = Model.getName();
        Group_ID = Model.getGroup_id();
        Ingredient_Existence = Model.getExistence();
        Ingredient_Unit = Model.getUnit();
    }

    //rAtributes

    public Long getIngredient_ID() {
        return Ingredient_ID;
    }

    public void setIngredient_ID(Long ingredient_ID) {
        Ingredient_ID = ingredient_ID;
    }

    public String getIngredient_Name() {
        return Ingredient_Name;
    }

    public void setIngredient_Name(String ingredient_Name) {
        Ingredient_Name = ingredient_Name;
    }

    public Float getIngredient_Existence() {
        return Ingredient_Existence;
    }

    public void setIngredient_Existence(Float ingredient_Existence) {
        Ingredient_Existence = ingredient_Existence;
    }

    public String getIngredient_Unit() {
        return Ingredient_Unit;
    }

    public void setIngredient_Unit(String ingredient_Unit) {
        Ingredient_Unit = ingredient_Unit;
    }

    public String getIngredient_Last_Used() {
        return Ingredient_Last_Used;
    }

    public void setIngredient_Last_Used(String ingredient_Last_Used) {
        Ingredient_Last_Used = ingredient_Last_Used;
    }

    public Integer getGroup_ID() {
        return Group_ID;
    }

    public void setGroup_ID(Integer group_ID) {
        Group_ID = group_ID;
    }
}
