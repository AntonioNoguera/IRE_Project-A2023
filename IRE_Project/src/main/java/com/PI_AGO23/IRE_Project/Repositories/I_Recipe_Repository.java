package com.PI_AGO23.IRE_Project.Repositories;

import com.PI_AGO23.IRE_Project.Models.Recipe_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface I_Recipe_Repository extends JpaRepository<Recipe_Model, Long> {
    /**
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Usuario findByEmail(@Param("email") String email);

    */

    ArrayList<Recipe_Model> findByDishID(long Dish_ID);
    //Comentarios acerca de springboot (Que no aparecen en su documentación)
    //Si utilizas los metodos query predefinidos por spring, el nombre de la variable siempre
    //será modificado a camelCase, por que si estas utilizando Snake_Case, tendrás que añadir
    //nombre, y modificar los nombre del modelo a camelCase, (cosa que ya hace), sin embargo la primer
    //letra es mayuscula, por lo que el camelCase no es correcto.
}