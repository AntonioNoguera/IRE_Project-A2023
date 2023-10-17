package com.PI_AGO23.IRE_Project.Models.GetModels;

import com.PI_AGO23.IRE_Project.Models.Group_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Group_Model;

import javax.persistence.Embeddable;

@Embeddable
public class Get_Group_Model extends Post_Group_Model {
    private Long id;

    //Constructor
    public Get_Group_Model(){}

    public Get_Group_Model(long id, Boolean isActive, String name, String hexColor, String description) {
        super(name, hexColor, description);
        this.id=id;
    }

    public Get_Group_Model(Group_Model groupModel) {
        super(groupModel.getGroup_Name(), groupModel.getGroup_Hex_Color(), groupModel.getGroup_Description());
        this.id=groupModel.getGroup_ID();
    }


    //Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
