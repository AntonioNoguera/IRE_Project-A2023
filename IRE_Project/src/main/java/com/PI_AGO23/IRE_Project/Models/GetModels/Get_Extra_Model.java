package com.PI_AGO23.IRE_Project.Models.GetModels;

import com.PI_AGO23.IRE_Project.Models.BackModels.Extra_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Extra_Model;

public class Get_Extra_Model extends Post_Extra_Model {
    private String kind_name;

    //Constructor
    public Get_Extra_Model(Extra_Model model){
        super(model.getExtra_Name(),model.getExtra_Description(),model.getKind_ID());
    }

    //Getter n Setter
    public String getKind_name() {
        return kind_name;
    }

    public void setKind_name(String kind_name) {
        this.kind_name = kind_name;
    }
}
