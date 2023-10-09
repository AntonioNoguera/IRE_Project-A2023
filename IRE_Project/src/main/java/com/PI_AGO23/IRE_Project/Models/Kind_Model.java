package com.PI_AGO23.IRE_Project.Models;

import javax.persistence.*;

@Entity
@Table(name="Kind_Table")
public class Kind_Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Kind_ID;

    @Column private String Kind_Name;

    public Long getKind_ID() {
        return Kind_ID;
    }

    public void setKind_ID(Long kind_ID) {
        Kind_ID = kind_ID;
    }

    public String getKind_Name() {
        return Kind_Name;
    }

    public void setKind_Name(String kind_Name) {
        Kind_Name = kind_Name;
    }


}
