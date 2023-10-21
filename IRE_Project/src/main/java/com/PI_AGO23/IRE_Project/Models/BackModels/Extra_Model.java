package com.PI_AGO23.IRE_Project.Models.BackModels;

import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Extra_Model;

import javax.persistence.*;

@Entity
@Table(name="Extras_Table")
public class Extra_Model {

    //	Extras_ID	Extra_Name	Extra_Description	Kind_ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Extras_ID;

    @Column private String Extra_Name;

    @Column private String Extra_Description;

    @Column private int Kind_ID;

    public Extra_Model(){
    }

    public Long getExtras_ID() {
        return Extras_ID;
    }

    public void setExtras_ID(Long extras_ID) {
        Extras_ID = extras_ID;
    }

    public String getExtra_Name() {
        return Extra_Name;
    }

    public void setExtra_Name(String extra_Name) {
        Extra_Name = extra_Name;
    }

    public String getExtra_Description() {
        return Extra_Description;
    }

    public void setExtra_Description(String extra_Description) {
        Extra_Description = extra_Description;
    }

    public int getKind_ID() {
        return Kind_ID;
    }

    public void setKind_ID(int kind_ID) {
        Kind_ID = kind_ID;
    }
}
