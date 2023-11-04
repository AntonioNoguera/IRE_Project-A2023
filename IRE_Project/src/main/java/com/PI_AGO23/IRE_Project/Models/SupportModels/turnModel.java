package com.PI_AGO23.IRE_Project.Models.SupportModels;

public class turnModel {
    private String name;
    private int recurency;

    public turnModel(){}

    public turnModel(String name, int recurency) {
        this.name = name;
        this.recurency = recurency;
    }

    //Getter and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecurency() {
        return recurency;
    }

    public void setRecurency(int recurency) {
        this.recurency = recurency;
    }
}
