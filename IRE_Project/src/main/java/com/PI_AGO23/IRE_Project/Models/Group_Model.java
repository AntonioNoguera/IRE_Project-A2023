package com.PI_AGO23.IRE_Project.Models;

import javax.persistence.*;

@Entity
@Table(name="Group_Table")
public class Group_Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Group_ID;

    @Column
    private String Group_Name;

    @Column
    private String Group_Description;

    @Column
    private String Group_Hex_Color;

    @Column
    private Boolean Group_Is_Active;

}
