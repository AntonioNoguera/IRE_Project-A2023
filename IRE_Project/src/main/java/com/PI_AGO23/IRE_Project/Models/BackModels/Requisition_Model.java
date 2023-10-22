package com.PI_AGO23.IRE_Project.Models.BackModels;

import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Requisition_Model;

import javax.persistence.*;

@Entity
@Table(name="Requisition_Table")
public class Requisition_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Requisition_ID;
    @Column private String Requisition_Day_Name;
    @Column private String Requisition_Date;

    public Requisition_Model(){}

    public Requisition_Model(String requDate,String dayName){
        this.Requisition_Date = requDate;
        this.Requisition_Day_Name = dayName;
    }

    public Requisition_Model(Post_Requisition_Model model){
        Requisition_Day_Name = model.getDayName();
        Requisition_Date = model.getDate();
    }

    public Long getRequisition_ID() {
        return Requisition_ID;
    }

    public void setRequisition_ID(Long requisition_ID) {
        Requisition_ID = requisition_ID;
    }

    public String getRequisition_Day_Name() {
        return Requisition_Day_Name;
    }

    public void setRequisition_Day_Name(String requisition_Day_Name) {
        Requisition_Day_Name = requisition_Day_Name;
    }

    public String getRequisition_Date() {
        return Requisition_Date;
    }

    public void setRequisition_Date(String requisition_Date) {
        Requisition_Date = requisition_Date;
    }
}
