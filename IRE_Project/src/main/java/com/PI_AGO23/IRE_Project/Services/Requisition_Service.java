package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.BackModels.Requisition_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Requisition_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Requisition_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Service
public class Requisition_Service {
    @Autowired
    I_Requisition_Repository requisitionRepository;

    //Obtener Requisición por Id
    //InnerJoin
    public Optional<Requisition_Model> get_Requisition_By_ID(Long Id){
        return (Optional<Requisition_Model>) requisitionRepository.findById(Id);
    }

    //Obtener Requisiciones  por Semana
    //Inner Join
    public ArrayList<Requisition_Model> get_Week_Requisition(String dayReference){
        return (ArrayList<Requisition_Model>) requisitionRepository.findAll();
    }

    //Nueva Requisición
    public Post_Requisition_Model new_Requisition(String YearMonthDay){
        String[] elementos = YearMonthDay.split("-");
        //Verificar, el número miembros, el tipo y el rango
        int dia = Integer.parseInt(elementos[2]);
        int mes = Integer.parseInt(elementos[1]);
        int year =Integer.parseInt(elementos[0]);

        if (mes < 3) {
            mes += 12;
            year--;
        }

        int k = year % 100;
        int j = year / 100;

        int h = (dia + 13 * (mes + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;

        String[] diasSemana = {"Sábado", "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        requisitionRepository.save(new Requisition_Model(YearMonthDay, diasSemana[h]));

        return new Post_Requisition_Model(YearMonthDay, diasSemana[h]);

    }

}
