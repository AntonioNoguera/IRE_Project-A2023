package com.PI_AGO23.IRE_Project;

import com.PI_AGO23.IRE_Project.Models.BackModels.Dish_Model;
import com.PI_AGO23.IRE_Project.Models.GetModels.Get_Dish_Model;
import com.PI_AGO23.IRE_Project.Models.PostModels.Post_Dish_Model;
import com.PI_AGO23.IRE_Project.Models.PutModel.Put_Dish_Model;
import com.PI_AGO23.IRE_Project.Repositories.I_Dish_Repository;
import com.PI_AGO23.IRE_Project.Repositories.I_Extra_Repository;
import com.PI_AGO23.IRE_Project.Services.Dish_Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.any;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.lang.ref.ReferenceQueue;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class Ingredient_Test {
    @InjectMocks
    private Dish_Service dishService;

    @Mock
    private I_Dish_Repository dishRepository;

    @Mock
    private I_Extra_Repository extraRep;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    //GetByIdMethods
    @Test
    public void testGetIngredientSuccess() {
        Long dishId = 1L;
        Dish_Model dishModel = new Dish_Model();
        dishModel.setDish_ID(dishId);
        dishModel.setDish_is_Active(true);

        // Utiliza Optional.of para crear un Optional con un valor presente
        when(dishRepository.findById(dishId)).thenReturn(Optional.of(dishModel));

        ResponseEntity<Get_Dish_Model> responseEntity = dishService.get_Dish_By_ID(dishId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetIngredientNotFound() {
        Long dishId = 1L;
        Dish_Model dishModel = new Dish_Model();
        dishModel.setDish_ID(dishId);
        dishModel.setDish_is_Active(false);

        // Utiliza Optional.of para crear un Optional con un valor presente
        when(dishRepository.findById(dishId)).thenReturn(Optional.of(dishModel));

        ResponseEntity<Get_Dish_Model> responseEntity = dishService.get_Dish_By_ID(dishId);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    public void testNewIngredientSucces() {
        Long dishId = 2L;
        Dish_Model dishModel = new Dish_Model();
        dishModel.setDish_ID(dishId);
        dishModel.setDish_is_Active(false);

        // Utiliza Optional.of para crear un Optional con un valor presente
        when(dishRepository.findById(dishId)).thenReturn(Optional.of(dishModel));

        ResponseEntity<Get_Dish_Model> responseEntity = dishService.get_Dish_By_ID(dishId);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    //DeleteDish
    @Test
    public void testNewIngredientConflict() {
        Dish_Model dish = new Dish_Model();
        dish.setDish_is_Active(true);
        when(dishRepository.findById(1L)).thenReturn(Optional.of(dish));

        // Llamar al método delete_Dish
        ResponseEntity<String> response = dishService.delete_Dish(1L);

        // Verificar que el plato se desactivó y se obtuvo una respuesta exitosa
        assertTrue(response.getStatusCode() == HttpStatus.OK);
        assertEquals("Dish Succesfully Covered", response.getBody());
    }

    @Test
    public void testNewIngredientUnprocessableEntity() {
        Dish_Model dish = new Dish_Model();
        dish.setDish_is_Active(false);
        when(dishRepository.findById(7L)).thenReturn(Optional.of(dish));

        // Llamar al método delete_Dish
        ResponseEntity<String> response = dishService.delete_Dish(7L);

        // Verificar que el plato se desactivó y se obtuvo una respuesta exitosa
        assertEquals(response.getStatusCode(), HttpStatus.CONFLICT);
        assertEquals("Already Disabled Dish", response.getBody());
    }

    @Test
    public void testUpdateIngredientSucces() {
        // Simular que el repositorio no encuentra un plato con el ID proporcionado
        when(dishRepository.findById(1L)).thenReturn(Optional.empty());

        // Llamar al método delete_Dish
        ResponseEntity<String> response = dishService.delete_Dish(1L);

        // Verificar que se obtiene una respuesta de no encontrado
        assertTrue(response.getStatusCode() == HttpStatus.NOT_FOUND);
        assertEquals("null", response.getBody());
    }


    @Test
    void testUpdateIngredientConflict() throws Exception {
        Dish_Service mock = mock(Dish_Service.class);
        Post_Dish_Model dish = new Post_Dish_Model("Test", true, "Frío", 1L, 8L, 9L, 6L);
        Dish_Service dishServiceMock = mock(Dish_Service.class);
        when(this.dishRepository.uniqueDish(dish.getName())).thenReturn(0);
        when(this.extraRep.verifyExtra(anyLong(), anyInt())).thenReturn(1);

        when(this.dishService.keyValidation(new Dish_Model(dish))).thenReturn(1); // Simula que keyValidation pasa la validación

        when(mock.VerifyEnumPertenency(anyString())).thenReturn(true);
        Dish_Model mockedReturn = new Dish_Model(10l, "Test", true, "Frío", String.valueOf(LocalDateTime.now()), 0, 0, 1L, 8L, 9L, 6L, "DEF", true);
        when(this.dishRepository.save(any())).thenReturn(mockedReturn);

        ResponseEntity<Put_Dish_Model> response = dishService.new_Dish(dish);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testUpdateIngredientNotFound() throws Exception {
        Dish_Service mock = mock(Dish_Service.class);
        Post_Dish_Model dish = new Post_Dish_Model("Test", true, "Fro", 1L, 8L, 9L, 6L);
        Dish_Service dishServiceMock = mock(Dish_Service.class);
        when(this.dishRepository.uniqueDish(dish.getName())).thenReturn(0);
        when(this.extraRep.verifyExtra(anyLong(), anyInt())).thenReturn(1);

        when(this.dishService.keyValidation(new Dish_Model(dish))).thenReturn(1); // Simula que keyValidation pasa la validación

        when(mock.VerifyEnumPertenency(anyString())).thenReturn(false);
        Dish_Model mockedReturn = new Dish_Model(10l, "Test", true, "Frío", String.valueOf(LocalDateTime.now()), 0, 0, 1L, 8L, 9L, 6L, "DEF", true);
        when(this.dishRepository.save(any())).thenReturn(mockedReturn);

        ResponseEntity<Put_Dish_Model> response = dishService.new_Dish(dish);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testDeleteIngredientSuccess() throws Exception {
        Dish_Service mock = mock(Dish_Service.class);
        Post_Dish_Model dish = new Post_Dish_Model("Test", true, "Fro", 1L, 8L, 9L, 6L);

        when(this.dishRepository.uniqueDish(dish.getName())).thenReturn(1);
        when(this.extraRep.verifyExtra(anyLong(), anyInt())).thenReturn(1);

        when(this.dishService.keyValidation(new Dish_Model(dish))).thenReturn(1); // Simula que keyValidation pasa la validación

        when(mock.VerifyEnumPertenency(anyString())).thenReturn(true);
        Dish_Model mockedReturn = new Dish_Model(10l, "Test", true, "Frío", String.valueOf(LocalDateTime.now()), 0, 0, 1L, 8L, 9L, 6L, "DEF", true);
        when(this.dishRepository.save(any())).thenReturn(mockedReturn);

        ResponseEntity<Put_Dish_Model> response = dishService.new_Dish(dish);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testDeleteIngredientNotFound() throws Exception {
        long ID=1;
        Dish_Service mock = mock(Dish_Service.class);

        Dish_Model dish = new Dish_Model(1L,"Testing",true,"Frío","2023-10-13 10:22:54",1,1,1,1,1,1,"des",true);
        Put_Dish_Model Request = new Put_Dish_Model(dish);

        //Existe
        when(dishRepository.findById(1L)).thenReturn(Optional.of(dish));

        //EnumCorrecto
        when(mock.VerifyEnumPertenency(anyString())).thenReturn(true);

        //unique Dish
        when(this.dishRepository.uniqueDish(dish.getDish_Name())).thenReturn(0);

        //Si duplicado

        ResponseEntity<Put_Dish_Model> response = dishService.update_Dish(Request,ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testDeleteIngredientConflict() throws Exception {
        long ID=1;
        Dish_Service mock = mock(Dish_Service.class);

        Dish_Model dish = new Dish_Model(1L,"Testing",true,
                "Frío","2023-10-13 10:22:54",1,
                1,1,1,1,1,"des",
                true);
        Put_Dish_Model Request = new Put_Dish_Model(dish);

        //Existe
        when(dishRepository.findById(1L)).thenReturn(Optional.empty());

        //unique Dish
        when(this.dishRepository.uniqueDish(dish.getDish_Name())).thenReturn(0);

        ResponseEntity<Put_Dish_Model> response = dishService.update_Dish(Request,ID);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }
}
