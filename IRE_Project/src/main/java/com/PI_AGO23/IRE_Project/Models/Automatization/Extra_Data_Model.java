package com.PI_AGO23.IRE_Project.Models.Automatization;

public class Extra_Data_Model {
    private Integer Extra_ID;
    private String Extra_Name;

    public Extra_Data_Model(Integer extra_ID, String extra_Name) {
        Extra_ID = extra_ID;
        Extra_Name = extra_Name;
    }

    public Integer getExtra_ID() {
        return Extra_ID;
    }

    public void setExtra_ID(Integer extra_ID) {
        Extra_ID = extra_ID;
    }

    public String getExtra_Name() {
        return Extra_Name;
    }

    public void setExtra_Name(String extra_Name) {
        Extra_Name = extra_Name;
    }
}
