package com.PI_AGO23.IRE_Project.Models.BackModels;

public class smallTypes {
    private long id;
    private String name;
    private double members;

    //Constructor
    public smallTypes(long id, String name, double members){
        this.id = id;
        this.name = name;
        this.members = members;
    }

    //Getter and Setter
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

    public double getMembers() {
        return members;
    }

    public void setMembers(double members) {
        this.members = members;
    }
}
