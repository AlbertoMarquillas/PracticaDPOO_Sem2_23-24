-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-05-2024 a las 05:22:11
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `coffeeclickerdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `game`
--

CREATE TABLE `game` (
  `ID_P` int(11) NOT NULL,
  `ID_G` int(11) NOT NULL,
  `N_Coffees` float NOT NULL,
  `PowerUpClicker` int(11) NOT NULL,
  `Time` time NOT NULL,
  `Ended` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `game`
--

INSERT INTO `game` (`ID_P`, `ID_G`, `N_Coffees`, `PowerUpClicker`, `Time`, `Ended`) VALUES
(2, 0, 3, 0, '00:00:00', 1),
(2, 1, 519.8, 0, '00:00:00', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generators`
--

CREATE TABLE `generators` (
  `ID_P` int(11) NOT NULL,
  `ID_G` int(11) NOT NULL,
  `Type` varchar(255) NOT NULL,
  `Quantitat` int(11) NOT NULL,
  `CostActual` int(11) NOT NULL,
  `ProduccioActual` float NOT NULL,
  `ProduccioGlobal` float NOT NULL,
  `Num_Millores` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `generators`
--

INSERT INTO `generators` (`ID_P`, `ID_G`, `Type`, `Quantitat`, `CostActual`, `ProduccioActual`, `ProduccioGlobal`, `Num_Millores`) VALUES
(2, 0, 'A', 1, 0, 0, 0, 0),
(2, 0, 'B', 1, 1, 0, 0, 0),
(2, 0, 'C', 0, 15, 0, 0, 0),
(2, 1, 'A', 1, 10, 0.2, 0, 0),
(2, 1, 'B', 1, 150, 1, 0, 0),
(2, 1, 'C', 0, 2000, 15, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `UserName` text DEFAULT NULL,
  `Email` text NOT NULL,
  `Password` text NOT NULL,
  `Connected` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `UserName`, `Email`, `Password`, `Connected`) VALUES
(1, 'a', 'a', 'a12345678?A', 0),
(2, 'g', 'g@gmail.com', 'Gerard1234_', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
