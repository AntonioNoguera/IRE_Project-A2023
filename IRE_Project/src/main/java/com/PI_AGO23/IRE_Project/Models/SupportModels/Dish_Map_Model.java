package com.PI_AGO23.IRE_Project.Models.SupportModels;

import com.PI_AGO23.IRE_Project.Models.BackModels.Dish_Model;

import java.util.ArrayList;
import java.util.List;
//Clase que se usa para los arreglos de generación
public class Dish_Map_Model {
    //Attributes
    private int id;
    private String ServiceDesc;
    private List<Dish_Process_Model> members = new ArrayList<>();
    private double mean;
    private double std_dsv;

    //Constructor

    public Dish_Map_Model(int id,String ServiceDesc, List<Dish_Process_Model> members, double mean, double std_dsv) {
        this.id = id;
        this.ServiceDesc = ServiceDesc;
        this.members = members;
        this.mean = mean;
        this.std_dsv = std_dsv;
    }

    //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Dish_Process_Model> getMembers() {
        return members;
    }

    public void setMembers(List<Dish_Process_Model> members) {
        this.members = members;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getStd_dsv() {
        return std_dsv;
    }

    public void setStd_dsv(double std_dsv) {
        this.std_dsv = std_dsv;
    }

    public String getService() {
        return ServiceDesc;
    }

    public void setService(String service) {
        ServiceDesc = service;
    }
}