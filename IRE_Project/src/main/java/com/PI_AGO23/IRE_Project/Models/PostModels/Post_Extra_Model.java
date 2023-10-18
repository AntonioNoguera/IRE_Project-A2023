package com.PI_AGO23.IRE_Project.Models.PostModels;

public class Post_Extra_Model {
    private String name;
    private String description;
    private int kind_id;

    //Constructor
    public Post_Extra_Model(){}

    public Post_Extra_Model(String name, String description, int kind_id) {
        this.name = name;
        this.description = description;
        this.kind_id = kind_id;
    }


    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKind_id() {
        return kind_id;
    }

    public void setKind_id(int kind_id) {
        this.kind_id = kind_id;
    }
}
