-- phpMyAdmin SQL Dump
-- version 4.0.4.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 12-04-2026 a las 17:48:18
-- Versión del servidor: 5.6.13
-- Versión de PHP: 5.4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `bdalmacen`
--
CREATE DATABASE IF NOT EXISTS `bdalmacen` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bdalmacen`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `codigo` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `unidades` int(11) NOT NULL,
  `precio` float NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `descripcion`, `unidades`, `precio`) VALUES
(1, 'Naranjas', 10, 2),
(2, 'Mandarinas', 5, 2),
(3, 'Platanos', 50, 1),
(4, 'Ordenador', 2, 1000),
(5, 'Ratón', 5, 49.99);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_proveedores`
--

CREATE TABLE IF NOT EXISTS `productos_proveedores` (
  `codigo_producto` int(11) NOT NULL,
  `codigo_proveedor` int(11) NOT NULL,
  PRIMARY KEY (`codigo_producto`,`codigo_proveedor`),
  KEY `codigo_proveedor` (`codigo_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos_proveedores`
--

INSERT INTO `productos_proveedores` (`codigo_producto`, `codigo_proveedor`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 2),
(5, 2),
(1, 3),
(3, 3),
(5, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE IF NOT EXISTS `proveedores` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`codigo`, `nombre`) VALUES
(1, 'Eroski'),
(2, 'Sima'),
(3, 'Frutas Iñaki'),
(4, 'PComponents');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `productos_proveedores`
--
ALTER TABLE `productos_proveedores`
  ADD CONSTRAINT `productos_proveedores_ibfk_1` FOREIGN KEY (`codigo_producto`) REFERENCES `productos` (`codigo`),
  ADD CONSTRAINT `productos_proveedores_ibfk_2` FOREIGN KEY (`codigo_proveedor`) REFERENCES `proveedores` (`codigo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
