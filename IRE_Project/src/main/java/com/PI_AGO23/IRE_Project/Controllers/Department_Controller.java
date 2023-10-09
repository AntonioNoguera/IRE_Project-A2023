package com.PI_AGO23.IRE_Project.Controllers;

import com.PI_AGO23.IRE_Project.Models.Department_Model;
import com.PI_AGO23.IRE_Project.Services.Department_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class Department_Controller {
    @Autowired
    private Department_Service departmentService;

    @GetMapping
    public ArrayList<Department_Model> getDepartments(){
        return this.departmentService.getDepartments();
    }

    @GetMapping(path="/{id}")
    public Optional<Department_Model> getDepartmentById(@PathVariable("id") long id){
        return this.departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department_Model saveNewDepartment(@RequestBody Department_Model department){
        return this.departmentService.saveDepartment(department);
    }

    @PutMapping(path="/{id}")
    public Department_Model updateDepartmentById(@RequestBody Department_Model Request,@PathVariable("id") long id){
        return this.departmentService.updateDepartmentById(Request,id);
    }

    @DeleteMapping(path="/{id}")
    public String deleteDepartmentById(@PathVariable("id") long Id ){

        boolean ok = this.departmentService.deleteDepartmentById(Id);

        if(ok){
            return "The Department with the id: " + Id + "was successfully deleted!";
        }else{
            return "It wasn´t possible to delete the department!";
        }
    }
}
