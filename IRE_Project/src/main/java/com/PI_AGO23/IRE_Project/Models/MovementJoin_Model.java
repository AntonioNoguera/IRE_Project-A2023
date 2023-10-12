package com.PI_AGO23.IRE_Project.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.print.DocFlavor;

@Entity
public class MovementJoin_Model {
    @Id private int Movement_ID;
    @Column private String Requsition_Day_Name;
    @Column private String Requisition_Date;
    @Column private String Dish_Name;
    @Column private String Ingredient_Name;
    @Column private float Movement_Amount;
    @Column private String Ingredient_Unit;
    @Column private String Movement_Time;

    public MovementJoin_Model(int movement_ID, String requsition_Day_Name, String requisition_Date, String dish_Name, String ingredient_Name, float movement_Amount, String ingredient_Unit, String movement_Time) {
        Movement_ID = movement_ID;
        Requsition_Day_Name = requsition_Day_Name;
        Requisition_Date = requisition_Date;
        Dish_Name = dish_Name;
        Ingredient_Name = ingredient_Name;
        Movement_Amount = movement_Amount;
        Ingredient_Unit = ingredient_Unit;
        Movement_Time = movement_Time;
    }

    public int getMovement_ID() {
        return Movement_ID;
    }

    public void setMovement_ID(int movement_ID) {
        Movement_ID = movement_ID;
    }

    public String getRequsition_Day_Name() {
        return Requsition_Day_Name;
    }

    public void setRequsition_Day_Name(String requsition_Day_Name) {
        Requsition_Day_Name = requsition_Day_Name;
    }

    public String getRequisition_Date() {
        return Requisition_Date;
    }

    public void setRequisition_Date(String requisition_Date) {
        Requisition_Date = requisition_Date;
    }

    public String getDish_Name() {
        return Dish_Name;
    }

    public void setDish_Name(String dish_Name) {
        Dish_Name = dish_Name;
    }

    public String getIngredient_Name() {
        return Ingredient_Name;
    }

    public void setIngredient_Name(String ingredient_Name) {
        Ingredient_Name = ingredient_Name;
    }

    public float getMovement_Amount() {
        return Movement_Amount;
    }

    public void setMovement_Amount(float movement_Amount) {
        Movement_Amount = movement_Amount;
    }

    public String getIngredient_Unit() {
        return Ingredient_Unit;
    }

    public void setIngredient_Unit(String ingredient_Unit) {
        Ingredient_Unit = ingredient_Unit;
    }

    public String getMovement_Time() {
        return Movement_Time;
    }

    public void setMovement_Time(String movement_Time) {
        Movement_Time = movement_Time;
    }
}
