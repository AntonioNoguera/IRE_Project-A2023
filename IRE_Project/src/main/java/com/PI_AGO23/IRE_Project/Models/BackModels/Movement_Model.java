package com.PI_AGO23.IRE_Project.Models.BackModels;

import javax.persistence.*;

@Entity
@Table(name="Movement_Table")
public class Movement_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Movement_ID;

    @Column private long Requisition_ID;
    @Column private long Ingredient_ID;
    @Column private float Movement_Amount;
    @Column private String Movement_Time;
    @Column private long Dish_ID;

    public Long getMovement_ID() {
        return Movement_ID;
    }

    public void setMovement_ID(Long movement_ID) {
        Movement_ID = movement_ID;
    }

    public long getRequisition_ID() {
        return Requisition_ID;
    }

    public void setRequisition_ID(long requisition_ID) {
        Requisition_ID = requisition_ID;
    }

    public long getIngredient_ID() {
        return Ingredient_ID;
    }

    public void setIngredient_ID(long ingredient_ID) {
        Ingredient_ID = ingredient_ID;
    }

    public float getMovement_Amount() {
        return Movement_Amount;
    }

    public void setMovement_Amount(float movement_Amount) {
        Movement_Amount = movement_Amount;
    }

    public String getMovement_Time() {
        return Movement_Time;
    }

    public void setMovement_Time(String movement_Time) {
        Movement_Time = movement_Time;
    }

    public long getDish_ID() {
        return Dish_ID;
    }

    public void setDish_ID(long dish_ID) {
        Dish_ID = dish_ID;
    }
}
