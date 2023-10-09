package com.PI_AGO23.IRE_Project.Models;

import com.PI_AGO23.IRE_Project.Services.Department_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

@Entity
@Table(name="Department_Table")
public class Department_Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Department_ID;

    @Column
    private String Department_Name;

    @Column
    private String Department_Description;

    @Column
    private String Department_Tag_Color;

    public Long getId() {   return Department_ID;  }

    public void setId(Long id) {    this.Department_ID = id;   }

    public String getDepartment_Name() {    return Department_Name;     }

    public void setDepartment_Name(String department_Name) {    Department_Name = department_Name;      }

    public String getDepartment_Description() { return Department_Description;  }

    public void setDepartment_Description(String department_Description) {  Department_Description = department_Description;    }

    public String getDepartment_Tag_Color() {   return Department_Tag_Color;    }

    public void setDepartment_Tag_Color(String department_Tag_Color) {  Department_Tag_Color = department_Tag_Color;    }
}
