package com.PI_AGO23.IRE_Project.Models.BackModels;

import java.util.List;

public class smallExtras {
    private int id;
    private String name;

    //Constructor

    public smallExtras(int id, String name) {
        this.id = id;
        this.name = name;
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
}