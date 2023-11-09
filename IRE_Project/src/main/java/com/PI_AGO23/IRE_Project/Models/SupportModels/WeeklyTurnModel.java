package com.PI_AGO23.IRE_Project.Models.SupportModels;

import java.util.List;

public class WeeklyTurnModel {
    private int week_ID;
    private String periodo_Semanal;
    private List<OneDay_Turn_Model> turnoSemanal;
    private Double calificacion_Prom;

    //Constructor


    public WeeklyTurnModel(int week_ID, String periodo_Semanal, List<OneDay_Turn_Model> turnoSemanal, Double calificacion_Prom) {
        this.week_ID = week_ID;
        this.periodo_Semanal = periodo_Semanal;
        this.turnoSemanal = turnoSemanal;
        this.calificacion_Prom = calificacion_Prom;
    }

    //Getter And Setter
    public int getWeek_ID() {
        return week_ID;
    }

    public void setWeek_ID(int week_ID) {
        this.week_ID = week_ID;
    }

    public String getPeriodo_Semanal() {
        return periodo_Semanal;
    }

    public void setPeriodo_Semanal(String periodo_Semanal) {
        this.periodo_Semanal = periodo_Semanal;
    }

    public List<OneDay_Turn_Model> getTurnoSemanal() {
        return turnoSemanal;
    }

    public void setTurnoSemanal(List<OneDay_Turn_Model> turnoSemanal) {
        this.turnoSemanal = turnoSemanal;
    }

    public Double getCalificacion_Prom() {
        return calificacion_Prom;
    }

    public void setCalificacion_Prom(Double calificacion_Prom) {
        this.calificacion_Prom = calificacion_Prom;
    }
}
