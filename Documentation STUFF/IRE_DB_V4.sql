-- DataBase First Session
-- Dev Notes:
-- 07/09/2023
-- V2
-- 01/09/2023
-- v3
-- 9/10/2023

CREATE DATABASE IRE_DB_V1;
USE IRE_DB_V1;

Drop table Group_Table;

CREATE TABLE Group_Table(
	Group_ID INT PRIMARY KEY AUTO_INCREMENT,
    Group_Name VARCHAR(20) NOT NULL UNIQUE,
    Group_Description TINYTEXT NOT NULL,
    Group_Hex_Color VARCHAR(7) DEFAULT '#FFF',
    Group_Is_Active BOOLEAN DEFAULT TRUE
    -- NO FOREIGN KEYS
);

INSERT INTO Group_Table (Group_Name, Group_Description, Group_Hex_Color)
VALUES
    ('Servicios', 'Entran carnes de todo tipo de animales, se excluyen embutidos.', '#FF5733');
    
    Select * from Group_Table;


CREATE TABLE Ingredient_Table(
	Ingredient_ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Ingredient_Name VARCHAR(30) NOT NULL UNIQUE,
    Group_ID INT NOT NULL,
    Ingredient_Existence FLOAT UNSIGNED NOT NULL,
    Ingredient_Unit VARCHAR(15) NOT NULL,
    Ingredient_Last_Used TIMESTAMP NOT NULL,
    
    -- KEYS
    FOREIGN KEY (Group_ID) REFERENCES Group_Table(Group_ID)
);

INSERT INTO Ingredient_Table (Ingredient_Name, Group_ID,Ingredient_Unit,Ingredient_Existence)
VALUES
    ('Tomate Morado', 3, 'KG', 20.12);

Select * from Ingredient_Table;

CREATE TABLE Dish_Table(
	Dish_ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Dish_Name VARCHAR(60) NOT NULL UNIQUE,
    Dish_Assamble BOOLEAN NOT NULL,
    Dish_Temperature ENUM('Frío','Irrelevante','Caliente'),
    Dish_Last_Made TIMESTAMP NOT NULL,
    Dish_Services INT UNSIGNED NOT NULL,
    Dish_Rating TINYINT UNSIGNED NOT NULL,
    Sauce_ID INT UNSIGNED NOT NULL,
    Protein_ID INT UNSIGNED NOT NULL,
    Complement_ID INT UNSIGNED NOT NULL,
    Dish_Type INT UNSIGNED NOT NULL 
    -- NO FOREIGN KEYS
); 

CREATE TABLE Recipe_Table(
	Recipe_ID INT PRIMARY KEY AUTO_INCREMENT,
	Dish_ID INT UNSIGNED NOT NULL,
    Ingredient_ID INT UNSIGNED NOT NULL,
    Recipe_Ingredient_Amount FLOAT UNSIGNED NOT NULL,

    -- KEY
	FOREIGN KEY (Ingredient_ID) REFERENCES Ingredient_Table(Ingredient_ID), 
    FOREIGN KEY (Dish_ID) REFERENCES Dish_Table(Dish_ID)
);

CREATE TABLE Requisition_Table(
	Requisition_ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Requsition_Day_Name VARCHAR(8) NOT NULL,
    Requisition_Date DATE NOT NULL
    -- NO FOREIGN KEYS
);

CREATE TABLE Movement_Table(
	Movement_ID INT PRIMARY KEY AUTO_INCREMENT,
    Requisition_ID INT UNSIGNED NOT NULL,
    Ingredient_ID INT UNSIGNED NOT NULL,
    Movement_Amount FLOAT UNSIGNED NOT NULL,
    Movement_Time TIME NOT NULL,
    Dish_ID INT UNSIGNED NOT NULL,
    
    -- KEYS
	FOREIGN KEY (Requisition_ID) REFERENCES Requisition_Table(Requisition_ID), 
	FOREIGN KEY (Ingredient_ID) REFERENCES Ingredient_Table(Ingredient_ID), 
    FOREIGN KEY (Dish_ID) REFERENCES Dish_Table(Dish_ID)
);

CREATE TABLE Kind_Table(
	Kind_ID INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Kind_Name VARCHAR(30) NOT NULL UNIQUE
    -- NO FOREIGN KEYS
);

INSERT INTO Kind_Table (Kind_Name)
VALUES
    ('Comdias'); 
    
Select * from Kind_Table;

CREATE TABLE Extras_Table(
	Extras_ID INT PRIMARY KEY AUTO_INCREMENT,
    Extra_Name VARCHAR(50) NOT NULL UNIQUE,
    Extra_Description TINYTEXT NOT NULL,
    Kind_ID INT UNSIGNED NOT NULL,
    
	 -- KEYS
	FOREIGN KEY (Kind_ID) REFERENCES Kind_Table(Kind_ID)
);

INSERT INTO Extras_Table (Extra_Name,Extra_Description, Kind_ID)
VALUES
    ('sss','Aqui van todos los complementos de la comida',1); 