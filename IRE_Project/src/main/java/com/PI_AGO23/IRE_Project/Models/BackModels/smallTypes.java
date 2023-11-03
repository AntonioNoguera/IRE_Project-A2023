package com.PI_AGO23.IRE_Project.Models.BackModels;

public class smallTypes {
    private Long id;
    private String name;
    private double members;

    //Constructor
    public smallTypes(Long id, String name, double members){
        this.id = id;
        this.name = name;
        this.members = members;
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

    public double getMembers() {
        return members;
    }

    public void setMembers(double members) {
        this.members = members;
    }
}
