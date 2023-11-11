package com.PI_AGO23.IRE_Project.Services;

import com.PI_AGO23.IRE_Project.Models.BackModels.Dish_Model;
import com.PI_AGO23.IRE_Project.Models.BackModels.postMenuModel;
import com.PI_AGO23.IRE_Project.Models.BackModels.smallTypes;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Dish_Model;
import com.PI_AGO23.IRE_Project.Models.SupportModels.*;
import com.PI_AGO23.IRE_Project.Repositories.I_Dish_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Extra_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class Automatization_Service {
    @Autowired
    I_Dish_Repository dishRepository;
    @Autowired
    I_Extra_Repository extraRep;

    private postMenuModel globalObject;

    public Menu_Data_Model gettingStuff(){
        //Dish Type Related
        List<Long> Types = this.extraRep.getDish_Types_ID();

        //Totalidad
        int totalPlatos = this.dishRepository.getIdActiveDishes().size();

        //Data Model
        Menu_Data_Model HashMenuModel = new Menu_Data_Model();

        //Lector de tipos
        for(int i=0;i<Types.size();i++){
            double nTipo = this.dishRepository.getTypeNumber(Types.get(i));
            HashMenuModel.getDish_Distribution().add(
                new smallTypes(
                        Types.get(i),
                        this.extraRep.getExtra(Types.get(i)),
                        (nTipo/totalPlatos)*100
                )
            );
        }

        //Seleccionando Armado o No
        for(int i=0; i<2;i++){
            HashMenuModel.getAssamble_Distribution().add(
                new smallTypes(
                        i,
                    "inferedType",
                    ((double) this.dishRepository.getAssambled(i)/totalPlatos)*100
                )
            );
        }

        //Seleccionando Temperatura
        String[] tempTipos={"Frío","Irrelevante","Caliente"};
        for(int i=0; i<3;i++){
            HashMenuModel.getTemperature_Distribution().add(
                    new smallTypes(
                            i,
                            tempTipos[i],
                            ((double) this.dishRepository.getTemperture(tempTipos[i])/totalPlatos)*100
                    )
            );
        }

        return HashMenuModel;
    }

    public Long diferenceBeetwen(String dateString){
        //Making Aptitude
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime lastMaded = null;

        try {
            lastMaded = LocalDateTime.parse(dateString, formatter);
        } catch (Exception e) {
            System.err.println("No se pudo convertir la cadena en LocalDateTime: " + e.getMessage());
        }

        if (lastMaded != null) {
            LocalDate today = LocalDate.now();

            long daysDifference = ChronoUnit.DAYS.between(lastMaded.toLocalDate(), today);
            return daysDifference;
        }
        return null;
    }

    public String generatingLapse(LocalDate startingTd){

        String[] fechasplt = (startingTd.toString()).split("-");
        String[] fechaFin = (startingTd.plusDays(7).toString()).split("-");

        String[] meses= {"","Ene","Feb","Mar","Abril","Mayo","Jun","Jul","Ago","Sep","Oct","Nov","Dic"} ;
        // Sumar 7 días a la fecha actual
        if(Integer.parseInt(fechasplt[1])==Integer.parseInt(fechaFin[1])){
            return fechasplt[2] + " a "+fechaFin[2] + " de " + meses[Integer.parseInt(fechaFin[1])];
        }else{
            return fechasplt[2] + " " + meses[Integer.parseInt(fechasplt[1])] + " a "+fechaFin[2] + " " + meses[Integer.parseInt(fechaFin[1])];
        }
    }

    List<Dish_Map_Model> finalHash;
    public List<WeeklyTurnModel> generandoReturn(){

        List<WeeklyTurnModel> WeeklyModel = new ArrayList<>();

        //Variable de Retorno
        List<OneDay_Turn_Model> menu = new ArrayList<>();

        //Días por semana Laboral
        List<String> week = globalObject.getNameServiceDays();

        //Turnos Diarios
        List<String> turns = globalObject.getTurnsOfDay();

        //Formato del Turno
        List<turnModel> turnObj = globalObject.getTurnFormat();
        double globalItemCount=0;
        int ident=1;
        double mean = 0;
        for(String spcfDay : week){
            List<TurnFormat> day= new ArrayList<>();
            for(int k=0;k<turns.size();k++){
                List<Food_Time_Model> turnMembers = new ArrayList<>();
                System.out.println("POR ALGUNA RAZON SE REINICIA AQUÍ?");
                for(turnModel spcfTurnTime : turnObj){

                    List<Put_Dish_Model> dishesOfTurn = new ArrayList<>();
                    //Significa que es el último
                    if(spcfTurnTime.getId()==0){
                        for(int i=0; i<spcfTurnTime.getRecurrence();i++){
                            System.out.println("TURNOOOO: "+spcfDay+" - "+turns.get(k));
                            //Condiciones que determinan si se agregan o no
                            // turnsOfDay

                            List<Dish_Process_Model> actualArrays = new ArrayList<>(finalHash.get(k).getMembers());


                            for(int w=0;w<actualArrays.size();w++){
                                System.out.print(w+".- SupPrint"+actualArrays.get(w).getName());
                            }
                            System.out.println("/");

                            if (!actualArrays.isEmpty()) {
                                Random random = new Random();

                                int iA = random.nextInt(actualArrays.size());

                                Put_Dish_Model dish = new Put_Dish_Model(this.dishRepository.findById((actualArrays.get(iA)).getId()).get());

                                actualArrays.remove(iA);

                                System.out.println("Miembro eliminado" + iA);

                                finalHash.get(k).setMembers(actualArrays);

                                dishesOfTurn.add(dish);
                                mean += dish.getRating();
                            }
                        }
                    }else{
                        for(int i=0; i<spcfTurnTime.getRecurrence();i++){
                            //Condiciones que determinan si se agregan o no

                            Put_Dish_Model dish = new Put_Dish_Model((this.dishRepository.findById(this.dishRepository.getRandomType(spcfTurnTime.getId())).get()));
                            dishesOfTurn.add(dish);
                            mean+=dish.getRating();

                        }
                    }
                    globalItemCount++;
                    //Se agrega el Time Model
                    if(!(dishesOfTurn.isEmpty())){
                        turnMembers.add(new Food_Time_Model(ident,spcfTurnTime.getName(),dishesOfTurn));
                    }

                }
                //Se agrega al Formato del Turno
                day.add(new TurnFormat(turns.get(k),turnMembers));
            }
            menu.add(new OneDay_Turn_Model(1,spcfDay, day));
        }
        WeeklyModel.add(new WeeklyTurnModel(
                1,
                generatingLapse(LocalDate.now()),
                menu,
                mean/globalItemCount)
        );
        return WeeklyModel;
    }

    public List<WeeklyTurnModel> creandoMenu(List<Dish_Map_Model> hash){
        //Clearing
        finalHash=hash;
        System.out.println("SE ARRANCAN LOS VALORES DEL MAP");
        return generandoReturn();
    }

    public List<WeeklyTurnModel> generate(postMenuModel jsonObject){
        globalObject= jsonObject;
        //PROCESAMIENTO
        //Esto es un día (Ocupamos aun un iterador semanal, cuantas semanas se van a intentar devolver)
        List<Dish_Map_Model> dishMap = new ArrayList<>();
        for(int i=0;i<jsonObject.getTurnsOfDay().size();i++){

            List<Dish_Model> model = this.dishRepository.getSpecificType(this.extraRep.getExtraID(jsonObject.getTurnsOfDay().get(i)).intValue());

            // GET TURN NAME
            //RETURN VAR
            List<Dish_Process_Model> members = new ArrayList<>();
            double mean=0; double m2 = 0.0; double std=0; int n = 0;

            for(Dish_Model modelUnit : model){
                n++;
                double delta = modelUnit.getDish_Rating() - mean;
                mean += delta / n;
                double delta2 = modelUnit.getDish_Rating() - mean;
                m2 += delta * delta2;

                modelUnit.setAptitude(diferenceBeetwen(modelUnit.getDish_Last_Made()));
                members.add(new Dish_Process_Model(modelUnit));
            }
            //Es muestral
            double desviacionEstandar = Math.sqrt(m2 / (n - 1));

            if (Double.isNaN(desviacionEstandar)) { desviacionEstandar=-1; }

            int iteratorV=-1;

            for(Dish_Map_Model types : dishMap ){
                if(jsonObject.getTurnsOfDay().get(i).equals(types.getService())){
                    iteratorV=types.getId();
                    break;
                }
            }

            if(!(iteratorV!=-1)){
                dishMap.add(
                        new Dish_Map_Model(
                                iteratorV,
                                jsonObject.getTurnsOfDay().get(i),
                                members,
                                mean,
                                desviacionEstandar
                        )
                );
            }else{
                dishMap.add(
                        new Dish_Map_Model(
                                jsonObject.getTurnFormat().get(i).getId(),
                                jsonObject.getTurnsOfDay().get(i),
                                members,
                                mean,
                                desviacionEstandar
                        )
                );
            }


        }

        //CREANDO RETORNO
        return creandoMenu(dishMap);
    }
}