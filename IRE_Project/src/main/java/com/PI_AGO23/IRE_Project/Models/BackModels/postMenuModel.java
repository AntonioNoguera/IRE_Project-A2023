package com.PI_AGO23.IRE_Project.Models.BackModels;

import com.PI_AGO23.IRE_Project.Models.SupportModels.turnModel;

import java.util.List;
import java.util.Map;

public class postMenuModel {
    private int id;
    private boolean booleanTemp;
    private List<String> nameServiceDays;
    private List<String> turnsOfDay;
    private List<turnModel> turnFormat;

    //Constructor
    public postMenuModel(boolean booleanTemp, List<String> nameServiceDays, List<String> turnsOfDay, List<turnModel> turnFormat) {
        this.id= id;
        this.booleanTemp = booleanTemp;
        this.nameServiceDays = nameServiceDays;
        this.turnsOfDay = turnsOfDay;
        this.turnFormat = turnFormat;
    }

    public postMenuModel() {}

    //Getter and Setter
    public boolean isBooleanTemp() {
        return booleanTemp;
    }

    public void setBooleanTemp(boolean booleanTemp) {
        this.booleanTemp = booleanTemp;
    }

    public List<String> getNameServiceDays() {
        return nameServiceDays;
    }

    public void setNameServiceDays(List<String> nameServiceDays) {
        this.nameServiceDays = nameServiceDays;
    }

    public List<String> getTurnsOfDay() {
        return turnsOfDay;
    }

    public void setTurnsOfDay(List<String> turnsOfDay) {
        this.turnsOfDay = turnsOfDay;
    }

    public List<turnModel> getTurnFormat() {
        return turnFormat;
    }

    public void setTurnFormat(List<turnModel> turnFormat) {
        this.turnFormat = turnFormat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
