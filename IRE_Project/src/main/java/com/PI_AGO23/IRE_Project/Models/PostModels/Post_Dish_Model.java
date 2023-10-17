package com.PI_AGO23.IRE_Project.Models.PostModels;

public class Post_Dish_Model {
    private String name;
    private String assamble;
    private String temperature;
    private Integer complement_id;
    private Long sauce_id;
    private Long protein_id;
    private Long type_id;

    //Constructor
    public Post_Dish_Model(){}

    public Post_Dish_Model(String name, String assamble, String temperature, Integer complement_id, Long sauce_id, Long protein_id, Long type_id) {
        this.name = name;
        this.assamble = assamble;
        this.temperature = temperature;
        this.complement_id = complement_id;
        this.sauce_id = sauce_id;
        this.protein_id = protein_id;
        this.type_id = type_id;
    }

    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssamble() {
        return assamble;
    }

    public void setAssamble(String assamble) {
        this.assamble = assamble;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Integer getComplement_id() {
        return complement_id;
    }

    public void setComplement_id(Integer complement_id) {
        this.complement_id = complement_id;
    }

    public Long getSauce_id() {
        return sauce_id;
    }

    public void setSauce_id(Long sauce_id) {
        this.sauce_id = sauce_id;
    }

    public Long getProtein_id() {
        return protein_id;
    }

    public void setProtein_id(Long protein_id) {
        this.protein_id = protein_id;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }
}
