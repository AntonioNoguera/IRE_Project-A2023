package com.PI_AGO23.IRE_Project.Models.PutModel;

import com.PI_AGO23.IRE_Project.Models.BackModels.Extra_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Extra_Model;

public class Put_Extra_Model extends Post_Extra_Model {
    private long id;

    public Put_Extra_Model(Extra_Model model){
        super(model.getExtra_Name(),model.getExtra_Description(),model.getKind_ID());
        this.id = model.getExtras_ID();
    }
    //Getter and Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
