-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-10-2023 a las 06:39:38
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ire_db_v1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dish_table`
--

CREATE TABLE `dish_table` (
  `Dish_ID` int(10) UNSIGNED NOT NULL,
  `Dish_Name` varchar(60) NOT NULL,
  `Dish_Assamble` tinyint(1) NOT NULL,
  `Dish_Temperature` enum('Frío','Irrelevante','Caliente') DEFAULT NULL,
  `Dish_Last_Made` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Dish_Services` int(10) UNSIGNED NOT NULL,
  `Dish_Rating` tinyint(3) UNSIGNED NOT NULL,
  `Sauce_ID` int(10) UNSIGNED NOT NULL,
  `Protein_ID` int(10) UNSIGNED NOT NULL,
  `Complement_ID` int(10) UNSIGNED NOT NULL,
  `Dish_Type` int(10) UNSIGNED NOT NULL,
  `Dish_isActive` tinyint(1) NOT NULL DEFAULT 1,
  `Dish_Image_Path` varchar(100) NOT NULL DEFAULT 'IRE_Project\\IRE_Project\\src\\main\\resources\\images\\placeholder.png'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dish_table`
--

INSERT INTO `dish_table` (`Dish_ID`, `Dish_Name`, `Dish_Assamble`, `Dish_Temperature`, `Dish_Last_Made`, `Dish_Services`, `Dish_Rating`, `Sauce_ID`, `Protein_ID`, `Complement_ID`, `Dish_Type`, `Dish_isActive`, `Dish_Image_Path`) VALUES
(1, 'ss', 1, 'Frío', '2023-10-13 16:22:54', 123, 122, 1, 1, 1, 2, 1, 'IRE_Project\\IRE_Project\\src\\main\\resources\\images\\placeholder.png'),
(2, 'ssssars', 1, 'Frío', '2023-10-13 16:22:58', 123, 122, 1, 1, 1, 3, 1, 'IRE_Project\\IRE_Project\\src\\main\\resources\\images\\placeholder.png'),
(3, 'Nuevo Registro', 1, 'Frío', '2023-10-13 16:23:01', 121, 1, 1, 1, 1, 4, 1, 'IRE_Project\\IRE_Project\\src\\main\\resources\\images\\placeholder.png'),
(4, 'Nuesvo Registro', 1, 'Frío', '2023-10-13 16:23:03', 121, 1, 1, 1, 1, 5, 1, 'IRE_Project\\IRE_Project\\src\\main\\resources\\images\\placeholder.png'),
(5, 'Nsuesvo Registro', 1, 'Frío', '2023-10-13 16:23:06', 121, 1, 1, 1, 1, 6, 1, 'IRE_Project\\IRE_Project\\src\\main\\resources\\images\\placeholder.png'),
(6, 'Tacos Nuevo Des', 0, 'Frío', '2023-10-13 17:21:44', 555, 80, 1, 2, 3, 2, 1, 'IRE_Project\\IRE_Project\\src\\main\\resources\\images\\placeholder.png'),
(7, 'Quesadillas de Postman', 1, 'Caliente', '2023-10-17 22:34:00', 0, 0, 8, 9, 7, 2, 1, 'IRE_Project\\src\\main\\esources\\images\\default.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `extras_table`
--

CREATE TABLE `extras_table` (
  `Extras_ID` int(11) NOT NULL,
  `Extra_Name` varchar(50) NOT NULL,
  `Extra_Description` tinytext NOT NULL,
  `Kind_ID` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `extras_table`
--

INSERT INTO `extras_table` (`Extras_ID`, `Extra_Name`, `Extra_Description`, `Kind_ID`) VALUES
(1, 'General Extra', '', 2),
(2, 'Desayuno', 'Aqui van todos los complementos de la comida', 4),
(3, 'Comida', 'Aqui van todos los complementos de la comida', 4),
(4, 'Postre', 'Insertado desde Post ', 4),
(5, 'Guarnición A', '', 4),
(6, 'Guarnición B', '', 4),
(7, 'Tortilla', '', 3),
(8, 'Salsa Roja', '', 1),
(9, 'Pollo', '', 2),
(10, 'Salsa Verde', '', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `group_table`
--

CREATE TABLE `group_table` (
  `Group_ID` int(11) NOT NULL,
  `Group_Name` varchar(20) NOT NULL,
  `Group_Description` tinytext NOT NULL,
  `Group_Hex_Color` varchar(7) DEFAULT '#FFF',
  `Group_is_active` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `group_table`
--

INSERT INTO `group_table` (`Group_ID`, `Group_Name`, `Group_Description`, `Group_Hex_Color`, `Group_is_active`) VALUES
(1, 'jk', 'Entran carnes de todo tipo de animales, se excluyen embutidos.', '#FF5733', NULL),
(3, 'Verduras', 'Las verduras no pueden durar mas de 4 dias refrigeradas.', '#33FF57', 0),
(8, 'bug?', 'bug?', '#FF5733', NULL),
(9, 'Servicios', 'Entran carnes de todo tipo de animales, se excluyen embutidos.', '#FF5733', 1),
(10, 'testing b', 'Entran carnes desdf todo tipo de animales, se excluyen embutidos.', '#FF33', 1),
(11, 'Testing Z', 'Entran carnes desdf todo tipo de animales, se excluyen embutidos.', '#FF33', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingredient_table`
--

CREATE TABLE `ingredient_table` (
  `Ingredient_ID` int(10) UNSIGNED NOT NULL,
  `Ingredient_Name` varchar(30) NOT NULL,
  `Group_ID` int(11) NOT NULL,
  `Ingredient_Existence` float UNSIGNED NOT NULL,
  `Ingredient_Unit` varchar(15) NOT NULL,
  `Ingredient_Last_Used` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Ingredient_Is_Active` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ingredient_table`
--

INSERT INTO `ingredient_table` (`Ingredient_ID`, `Ingredient_Name`, `Group_ID`, `Ingredient_Existence`, `Ingredient_Unit`, `Ingredient_Last_Used`, `Ingredient_Is_Active`) VALUES
(3, 'Tomate Verde', 3, 20.12, 'KG', '0000-00-00 00:00:00', 1),
(5, 'string', 10, 20.12, 'string', '2023-10-09 20:04:54', 0),
(6, 'Cebolla', 3, 20.12, 'KG', '2023-10-09 20:11:14', 1),
(8, 'Cacahuate', 8, 20.12, 'Pz', '2023-10-09 20:12:22', 1),
(9, 'Banano', 3, 10, 'kg', '2023-10-18 19:17:48', 1),
(10, 'Bananito', 3, 10, 'kg', '2023-10-18 19:19:57', 1),
(11, 'Mango', 3, 10, 'kg', '2023-10-18 19:34:30', 1),
(12, 'Durazno', 3, 10, 'kg', '2023-10-18 19:36:59', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `kind_table`
--

CREATE TABLE `kind_table` (
  `Kind_ID` int(10) UNSIGNED NOT NULL,
  `Kind_Name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `kind_table`
--

INSERT INTO `kind_table` (`Kind_ID`, `Kind_Name`) VALUES
(3, 'Complementos'),
(2, 'Proteina'),
(1, 'Salsas'),
(4, 'Tipos De Platillos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movement_table`
--

CREATE TABLE `movement_table` (
  `Movement_ID` int(11) NOT NULL,
  `Requisition_ID` int(10) UNSIGNED NOT NULL,
  `Ingredient_ID` int(10) UNSIGNED NOT NULL,
  `Movement_Amount` float UNSIGNED NOT NULL,
  `Movement_Time` time NOT NULL,
  `Dish_ID` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recipe_table`
--

CREATE TABLE `recipe_table` (
  `Recipe_ID` int(11) NOT NULL,
  `Dish_ID` int(10) UNSIGNED NOT NULL,
  `Ingredient_ID` int(10) UNSIGNED NOT NULL,
  `Recipe_Ingredient_Amount` float UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `requisition_table`
--

CREATE TABLE `requisition_table` (
  `Requisition_ID` int(10) UNSIGNED NOT NULL,
  `Requsition_Day_Name` varchar(8) NOT NULL,
  `Requisition_Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `dish_table`
--
ALTER TABLE `dish_table`
  ADD PRIMARY KEY (`Dish_ID`),
  ADD UNIQUE KEY `Dish_Name` (`Dish_Name`);

--
-- Indices de la tabla `extras_table`
--
ALTER TABLE `extras_table`
  ADD PRIMARY KEY (`Extras_ID`),
  ADD UNIQUE KEY `Extra_Name` (`Extra_Name`),
  ADD KEY `Kind_ID` (`Kind_ID`);

--
-- Indices de la tabla `group_table`
--
ALTER TABLE `group_table`
  ADD PRIMARY KEY (`Group_ID`),
  ADD UNIQUE KEY `Group_Name` (`Group_Name`);

--
-- Indices de la tabla `ingredient_table`
--
ALTER TABLE `ingredient_table`
  ADD PRIMARY KEY (`Ingredient_ID`),
  ADD UNIQUE KEY `Ingredient_ID_Name` (`Ingredient_Name`),
  ADD KEY `Group_ID` (`Group_ID`);

--
-- Indices de la tabla `kind_table`
--
ALTER TABLE `kind_table`
  ADD PRIMARY KEY (`Kind_ID`),
  ADD UNIQUE KEY `Kind_Name` (`Kind_Name`);

--
-- Indices de la tabla `movement_table`
--
ALTER TABLE `movement_table`
  ADD PRIMARY KEY (`Movement_ID`),
  ADD KEY `Requisition_ID` (`Requisition_ID`),
  ADD KEY `Ingredient_ID` (`Ingredient_ID`),
  ADD KEY `Dish_ID` (`Dish_ID`);

--
-- Indices de la tabla `recipe_table`
--
ALTER TABLE `recipe_table`
  ADD PRIMARY KEY (`Recipe_ID`),
  ADD UNIQUE KEY `Dish_ID` (`Dish_ID`,`Ingredient_ID`),
  ADD KEY `Ingredient_ID` (`Ingredient_ID`);

--
-- Indices de la tabla `requisition_table`
--
ALTER TABLE `requisition_table`
  ADD PRIMARY KEY (`Requisition_ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `dish_table`
--
ALTER TABLE `dish_table`
  MODIFY `Dish_ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `extras_table`
--
ALTER TABLE `extras_table`
  MODIFY `Extras_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `group_table`
--
ALTER TABLE `group_table`
  MODIFY `Group_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `ingredient_table`
--
ALTER TABLE `ingredient_table`
  MODIFY `Ingredient_ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `kind_table`
--
ALTER TABLE `kind_table`
  MODIFY `Kind_ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `movement_table`
--
ALTER TABLE `movement_table`
  MODIFY `Movement_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `recipe_table`
--
ALTER TABLE `recipe_table`
  MODIFY `Recipe_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `requisition_table`
--
ALTER TABLE `requisition_table`
  MODIFY `Requisition_ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `extras_table`
--
ALTER TABLE `extras_table`
  ADD CONSTRAINT `extras_table_ibfk_1` FOREIGN KEY (`Kind_ID`) REFERENCES `kind_table` (`Kind_ID`);

--
-- Filtros para la tabla `ingredient_table`
--
ALTER TABLE `ingredient_table`
  ADD CONSTRAINT `ingredient_table_ibfk_1` FOREIGN KEY (`Group_ID`) REFERENCES `group_table` (`Group_ID`);

--
-- Filtros para la tabla `movement_table`
--
ALTER TABLE `movement_table`
  ADD CONSTRAINT `movement_table_ibfk_1` FOREIGN KEY (`Requisition_ID`) REFERENCES `requisition_table` (`Requisition_ID`),
  ADD CONSTRAINT `movement_table_ibfk_2` FOREIGN KEY (`Ingredient_ID`) REFERENCES `ingredient_table` (`Ingredient_ID`),
  ADD CONSTRAINT `movement_table_ibfk_3` FOREIGN KEY (`Dish_ID`) REFERENCES `dish_table` (`Dish_ID`);

--
-- Filtros para la tabla `recipe_table`
--
ALTER TABLE `recipe_table`
  ADD CONSTRAINT `recipe_table_ibfk_1` FOREIGN KEY (`Ingredient_ID`) REFERENCES `ingredient_table` (`Ingredient_ID`),
  ADD CONSTRAINT `recipe_table_ibfk_2` FOREIGN KEY (`Dish_ID`) REFERENCES `dish_table` (`Dish_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
