package com.PI_AGO23.IRE_Project.Models.Automatization;

public class Dish_String_Model {
    private String Dish_ID;
    private String Dish_Name;
    private String Dish_Assemble;
    private String Dish_Temperature;
    private String Dish_Last_Made;
    private String Dish_Sauce;
    private String Dish_Protein;
    private String Dish_Complement;
    private String Dish_Type;
    private Integer Dish_Grade;

    //Constructor
    public Dish_String_Model(){};

    public Dish_String_Model(String dish_ID, String dish_Name, String dish_Assemble, String dish_Temperature, String dish_Last_Made, String dish_Sauce, String dish_Protein, String dish_Complement, String dish_Type, Integer dish_Grade) {
        Dish_ID = dish_ID;
        Dish_Assemble = dish_Assemble;
        Dish_Temperature = dish_Temperature;
        Dish_Last_Made = dish_Last_Made;
        Dish_Sauce = dish_Sauce;
        Dish_Protein = dish_Protein;
        Dish_Complement = dish_Complement;
        Dish_Type = dish_Type;
        Dish_Grade = dish_Grade;
    }

    // Getter and Setter
    public String getDish_ID() {
        return Dish_ID;
    }

    public void setDish_ID(String dish_ID) {
        Dish_ID = dish_ID;
    }

    public String getDish_Name() {
        return Dish_Name;
    }

    public void setDish_Name(String dish_Name) {
        Dish_Name = dish_Name;
    }

    public String getDish_Assemble() {
        return Dish_Assemble;
    }

    public void setDish_Assemble(String dish_Assemble) {
        Dish_Assemble = dish_Assemble;
    }

    public String getDish_Temperature() {
        return Dish_Temperature;
    }

    public void setDish_Temperature(String dish_Temperature) {
        Dish_Temperature = dish_Temperature;
    }

    public String getDish_Last_Made() {
        return Dish_Last_Made;
    }

    public void setDish_Last_Made(String dish_Last_Made) {
        Dish_Last_Made = dish_Last_Made;
    }

    public String getDish_Sauce() {
        return Dish_Sauce;
    }

    public void setDish_Sauce(String dish_Sauce) {
        Dish_Sauce = dish_Sauce;
    }

    public String getDish_Protein() {
        return Dish_Protein;
    }

    public void setDish_Protein(String dish_Protein) {
        Dish_Protein = dish_Protein;
    }

    public String getDish_Complement() {
        return Dish_Complement;
    }

    public void setDish_Complement(String dish_Complement) {
        Dish_Complement = dish_Complement;
    }

    public String getDish_Type() {
        return Dish_Type;
    }

    public void setDish_Type(String dish_Type) {
        Dish_Type = dish_Type;
    }

    public Integer getDish_Grade() {
        return Dish_Grade;
    }

    public void setDish_Grade(Integer dish_Grade) {
        Dish_Grade = dish_Grade;
    }
}
