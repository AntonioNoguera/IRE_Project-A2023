package com.PI_AGO23.IRE_Project.Models.SupportModels;

public class Extra_Support_Model {
    private long id;
    private String name;

    public Extra_Support_Model(long id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
