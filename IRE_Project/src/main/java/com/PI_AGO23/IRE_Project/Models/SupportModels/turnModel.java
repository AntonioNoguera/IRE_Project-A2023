package com.PI_AGO23.IRE_Project.Models.SupportModels;

public class turnModel {
    private int id;
    private String name;
    private int recurrence;

    public turnModel(){}

    public turnModel(int id, String name, int recurrence) {
        this.name = name;
        this.recurrence = recurrence;
    }

    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(int recurency) {
        this.recurrence = recurency;
    }
}
