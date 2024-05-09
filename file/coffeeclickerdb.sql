-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-05-2024 a las 10:37:39
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
(2, 0, 1051.2, 0, '00:11:51', 0);

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
(2, 0, 'A', 7, 16, 0.2, 588.2, 0),
(2, 0, 'B', 2, 198, 1, 678, 0),
(2, 0, 'C', 0, 2000, 15, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stats`
--

CREATE TABLE `stats` (
  `ID_P` int(11) NOT NULL,
  `ID_G` int(11) NOT NULL,
  `Time` time NOT NULL,
  `N_Cafe` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `stats`
--

INSERT INTO `stats` (`ID_P`, `ID_G`, `Time`, `N_Cafe`) VALUES
(2, 0, '00:03:00', 48.8),
(2, 0, '00:04:00', 58),
(2, 0, '00:05:00', 94),
(2, 0, '00:06:00', 24),
(2, 0, '00:07:00', 45.8),
(2, 0, '00:08:00', 265.8),
(2, 0, '00:09:00', 469.8),
(2, 0, '00:10:00', 673.8),
(2, 0, '00:11:00', 877.8);

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
