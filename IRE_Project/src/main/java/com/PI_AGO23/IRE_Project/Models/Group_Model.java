package com.PI_AGO23.IRE_Project.Models;

import javax.persistence.*;

@Entity
@Table(name="Group_Table")
public class Group_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Group_ID;

    @Column private String Group_Name;

    @Column private String Group_Description;

    @Column private String Group_Hex_Color;

    @Column(columnDefinition = "BOOLEAN DEFAULT true") private Boolean Group_Is_Active;

    public Long getGroup_ID() {
        return Group_ID;
    }

    public void setGroup_ID(Long group_ID) {
        Group_ID = group_ID;
    }

    public String getGroup_Name() {
        return Group_Name;
    }

    public void setGroup_Name(String group_Name) {
        Group_Name = group_Name;
    }

    public String getGroup_Description() {
        return Group_Description;
    }

    public void setGroup_Description(String group_Description) {
        Group_Description = group_Description;
    }

    public String getGroup_Hex_Color() {
        return Group_Hex_Color;
    }

    public void setGroup_Hex_Color(String group_Hex_Color) {
        Group_Hex_Color = group_Hex_Color;
    }

    public Boolean getGroup_Is_Active() {
        return Group_Is_Active;
    }

    public void setGroup_Is_Active(Boolean group_Is_Active) {
        Group_Is_Active = group_Is_Active;
    }
}
