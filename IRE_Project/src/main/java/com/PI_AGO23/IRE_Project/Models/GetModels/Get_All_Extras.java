package com.PI_AGO23.IRE_Project.Models.GetModels;

import com.PI_AGO23.IRE_Project.Models.BackModels.smallExtras;
import com.PI_AGO23.IRE_Project.Repositories.I_Extra_Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class Get_All_Extras {
    private List<smallExtras> proteins;
    private List<smallExtras> sauces;
    private List<smallExtras> complements;
    private List<smallExtras> types;

    //Constructor
    @Autowired I_Extra_Repository extraRepository;

    public Get_All_Extras(){
    }

    //Getter and Setter
    public List<smallExtras> getProteins() {
        return proteins;
    }

    public void setProteins(List<smallExtras> proteins) {
        this.proteins = proteins;
    }

    public List<smallExtras> getSauces() {
        return sauces;
    }

    public void setSauces(List<smallExtras> sauces) {
        this.sauces = sauces;
    }

    public List<smallExtras> getComplements() {
        return complements;
    }

    public void setComplements(List<smallExtras> complements) {
        this.complements = complements;
    }

    public List<smallExtras> getTypes() {
        return types;
    }

    public void setTypes(List<smallExtras> types) {
        this.types = types;
    }
}
