-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-05-2024 a las 19:21:47
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
(2, 0, 0, 0, '00:00:00', 1),
(2, 1, 0, 0, '00:00:00', 1),
(2, 2, 1, 0, '00:00:00', 1),
(2, 3, 10, 0, '00:00:00', 1),
(2, 4, 0, 0, '00:00:00', 1),
(2, 5, 1, 0, '00:00:00', 1),
(2, 6, 10, 0, '00:00:00', 1),
(2, 7, 4.4, 0, '00:00:00', 1),
(2, 8, 3.4, 0, '00:00:00', 1),
(2, 9, 2.2, 0, '00:00:00', 1),
(2, 10, 5300.2, 0, '00:00:00', 1),
(2, 11, 21.2, 0, '00:00:00', 1),
(2, 12, 222.8, 0, '00:00:00', 1),
(2, 13, 8.2, 0, '00:00:00', 1),
(2, 14, 146.6, 0, '00:00:00', 1),
(2, 15, 22706.4, 0, '00:00:00', 1),
(2, 16, 162.6, 0, '00:00:00', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generators`
--

CREATE TABLE `generators` (
  `ID_P` int(11) NOT NULL,
  `ID_G` int(11) NOT NULL,
  `Type` varchar(255) NOT NULL,
  `Quantitat` int(11) NOT NULL,
  `CostActual` float NOT NULL,
  `ProduccioActual` float NOT NULL,
  `ProduccioGlobal` float NOT NULL,
  `Num_Millores` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `generators`
--

INSERT INTO `generators` (`ID_P`, `ID_G`, `Type`, `Quantitat`, `CostActual`, `ProduccioActual`, `ProduccioGlobal`, `Num_Millores`) VALUES
(2, 0, 'A', 1, 11, 0, 0, 0),
(2, 0, 'B', 0, 150, 1, 0, 0),
(2, 0, 'C', 0, 2000, 15, 0, 0),
(2, 1, 'A', 1, 11, 0, 0, 0),
(2, 1, 'B', 0, 150, 1, 0, 0),
(2, 1, 'C', 0, 2000, 15, 0, 0),
(2, 2, 'A', 1, 11, 0, 0, 0),
(2, 2, 'B', 0, 150, 1, 0, 0),
(2, 2, 'C', 0, 2000, 15, 0, 0),
(2, 3, 'A', 1, 11, 0, 0, 0),
(2, 3, 'B', 0, 150, 1, 0, 0),
(2, 3, 'C', 0, 2000, 15, 0, 0),
(2, 4, 'A', 1, 11, 0, 0, 0),
(2, 4, 'B', 0, 150, 1, 0, 0),
(2, 4, 'C', 0, 2000, 15, 0, 0),
(2, 5, 'A', 1, 11, 0, 0, 0),
(2, 5, 'B', 0, 150, 1, 0, 0),
(2, 5, 'C', 0, 2000, 15, 0, 0),
(2, 6, 'A', 1, 11, 0, 0, 0),
(2, 6, 'B', 0, 150, 1, 0, 0),
(2, 6, 'C', 0, 2000, 15, 0, 0),
(2, 7, 'A', 1, 11, 1.2, 0, 0),
(2, 7, 'B', 0, 150, 1, 0, 0),
(2, 7, 'C', 0, 2000, 15, 0, 0),
(2, 8, 'A', 1, 11, 1.2, 0, 0),
(2, 8, 'B', 0, 150, 1, 0, 0),
(2, 8, 'C', 0, 2000, 15, 0, 0),
(2, 9, 'A', 1, 11, 1.2, 0, 0),
(2, 9, 'B', 0, 150, 1, 0, 0),
(2, 9, 'C', 0, 2000, 15, 0, 0),
(2, 10, 'A', 24, 50.7237, 0.2, 0, 0),
(2, 10, 'B', 5, 301.704, 1, 0, 0),
(2, 10, 'C', 1, 2240, 15, 0, 0),
(2, 11, 'A', 6, 15.0073, 0.2, 0, 0),
(2, 11, 'B', 0, 150, 1, 0, 0),
(2, 11, 'C', 0, 2000, 15, 0, 0),
(2, 12, 'A', 8, 17, 0.2, 326.8, 0),
(2, 12, 'B', 1, 172.5, 1, 0, 0),
(2, 12, 'C', 0, 2000, 15, 0, 0),
(2, 13, 'A', 1, 11, 0.2, 6.2, 0),
(2, 13, 'B', 0, 150, 1, 0, 0),
(2, 13, 'C', 0, 2000, 15, 0, 0),
(2, 14, 'A', 7, 16, 0.2, 163.6, 0),
(2, 14, 'B', 2, 198.375, 1, 0, 0),
(2, 14, 'C', 0, 2000, 15, 0, 0),
(2, 15, 'A', 23, 47, 0.2, 5123.4, 0),
(2, 15, 'B', 3, 228, 1, 3700, 0),
(2, 15, 'C', 2, 2509, 15, 19020, 0),
(2, 16, 'A', 15, 28, 0.2, 286.2, 0),
(2, 16, 'B', 5, 302, 1, 758, 0),
(2, 16, 'C', 0, 2000, 15, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stats`
--

CREATE TABLE `stats` (
  `Time` time NOT NULL,
  `N_Cafe` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

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
(2, 'g', 'g@gmail.com', 'Gerard1234_', 1);

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
