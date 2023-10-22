package com.PI_AGO23.IRE_Project.Models.PostModels;

public class Post_Requisition_Model {
    private String date;
    private String dayName;



    public Post_Requisition_Model(String date, String dayName) {
        this.date = date;
        this.dayName = dayName;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
