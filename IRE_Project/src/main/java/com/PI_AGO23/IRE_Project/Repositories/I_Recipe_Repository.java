package com.PI_AGO23.IRE_Project.Repositories;

import com.PI_AGO23.IRE_Project.Models.BackModels.Recipe_Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface I_Recipe_Repository extends JpaRepository<Recipe_Model, Long> {
    /**
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Usuario findByEmail(@Param("email") String email);

    */
    //Utilizando la libreria fuerza (por lo menos en un principio) el join completo
    //ArrayList<Recipe_Model> findByDishID(long Dish_ID);
    //Comentarios acerca de springboot (Que no aparecen en su documentación)
    //Si utilizas los metodos query predefinidos por spring, el nombre de la variable siempre
    //será modificado a camelCase, por que si estas utilizando Snake_Case, tendrás que añadir
    //nombre, y modificar los nombre del modelo a camelCase, (cosa que ya hace), sin embargo la primer
    //letra es mayuscula, por lo que el camelCase no es correcto.

    // Consulta personalizada utilizando SQL nativo
    /**
    @Query(value="SELECT * FROM RECIPE_TABLE WHERE DISH_ID = ?1", nativeQuery = true)
    ArrayList<Recipe_Model> getRecipeById(long Dish_ID);
    **/
    //Join Personalizada utilizando SQL Nativo
    @Query(value = """
            Select Recipe_Table.Recipe_ID AS Recipe_ID,\s
            Dish_Table.Dish_Name AS Dish_Name,\s
            Ingredient_Table.Ingredient_Name AS Ingredient_Name,\s
            Recipe_Table.Recipe_Ingredient_Amount AS Recipe_Ingredient_Amount,\s
            Ingredient_Table.Ingredient_Unit AS Ingredient_Unit
              FROM recipe_table
              INNER JOIN dish_table ON Recipe_Table.Dish_ID = dish_table.Dish_ID
              INNER JOIN ingredient_table ON Recipe_Table.Ingredient_ID = ingredient_table.Ingredient_ID
              WHERE Recipe_Table.Dish_ID = ?1""",nativeQuery = true)
    ArrayList<Object[]> getRecipeById(long Dish_ID);
}