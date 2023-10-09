package com.PI_AGO23.IRE_Project.Models;

import javax.persistence.*;

@Entity
@Table(name="Requisition_Table")
public class Requisition_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Reisition_ID;
    @Column private String Requisition_Day_Name;
    @Column private String Requsition_Date;

    public Long getReisition_ID() {
        return Reisition_ID;
    }

    public void setReisition_ID(Long reisition_ID) {
        Reisition_ID = reisition_ID;
    }

    public String getRequisition_Day_Name() {
        return Requisition_Day_Name;
    }

    public void setRequisition_Day_Name(String requisition_Day_Name) {
        Requisition_Day_Name = requisition_Day_Name;
    }

    public String getRequsition_Date() {
        return Requsition_Date;
    }

    public void setRequsition_Date(String requsition_Date) {
        Requsition_Date = requsition_Date;
    }
}
