package com.PI_AGO23.IRE_Project.Models.SupportModels;

import java.util.ArrayList;
import java.util.List;

public class TurnFormat {
    private String Day;
    private List<Food_Time_Model> turnEspecification;

    public TurnFormat(String turn, List<Food_Time_Model> members){
        this.Day = turn;
        this.turnEspecification=members;
    }

    public String getTurn() {
        return Day;
    }

    public void setTurn(String turn) {
        Day = turn;
    }

    public List<Food_Time_Model> getTurnEspecification() {
        return turnEspecification;
    }

    public void setTurnEspecification(List<Food_Time_Model> turnEspecification) {
        this.turnEspecification = turnEspecification;
    }
}
