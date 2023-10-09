package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.Department_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Department_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class Department_Service {
    @Autowired
    I_Department_Repository departmentRepository;

    //Obtener todos los departamentos
    public ArrayList<Department_Model> getDepartments(){
        return (ArrayList<Department_Model>) departmentRepository.findAll();
    }

    //Guardar nuevo departamento
    public Department_Model saveDepartment(Department_Model department){
        return departmentRepository.save(department);
    }

    //Selección de un departamento
    public Optional<Department_Model> getDepartmentById(Long Id){
        return departmentRepository.findById(Id);
    }

    //Actualizar departamento
    public Department_Model updateDepartmentById(Department_Model Request, Long Id){
        Department_Model department = departmentRepository.findById(Id).get();

        department.setDepartment_Name(Request.getDepartment_Name());
        department.setDepartment_Description(Request.getDepartment_Description());
        department.setDepartment_Tag_Color(Request.getDepartment_Tag_Color());

        departmentRepository.save(department);

        return department;
    }

    //Eliminar el departamento
    public Boolean deleteDepartmentById(long Id){
        try{
            departmentRepository.deleteById(Id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
