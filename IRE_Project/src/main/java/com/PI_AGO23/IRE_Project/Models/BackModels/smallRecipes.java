package com.PI_AGO23.IRE_Project.Models.BackModels;

public class smallRecipes {
    private long id;
    private String name;
    private float existence;
    private String unit;
    private Long group_id;

    //Constructor

    public smallRecipes() {
    }

    public smallRecipes(long id, String name, float existence, String unit, Long group_id) {
        this.id = id;
        this.name = name;
        this.existence = existence;
        this.unit = unit;
        this.group_id = group_id;
    }

    //Getter and setter
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

    public float getExistence() {
        return existence;
    }

    public void setExistence(float existence) {
        this.existence = existence;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }
}
