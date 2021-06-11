-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 28-05-2014 a las 06:02:30
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `controlaula`
--
CREATE DATABASE `controlaula` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `controlaula`;

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `generarContrase`(cod char(9))
begin
	declare contrase varchar(30);
	declare estudian varchar(30);
	
	set estudian = (select contraseña from estudiante where codigo=cod);
	select estudian;
	
	if(estudian is NULL or estudian="")then
		set contrase = (select concat(left(nombre1,1),right(codigo,7),left(apellido1,1)) from estudiante where codigo=cod);
		update estudiante set contraseña=contrase where codigo=cod;
	end if;

end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula`
--

CREATE TABLE IF NOT EXISTS `aula` (
  `codigo` char(2) NOT NULL DEFAULT '',
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aula`
--

INSERT INTO `aula` (`codigo`, `descripcion`) VALUES
('01', 'SALA INFORMÁTICA 1'),
('02', 'SALA INFORMÁTICA 2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora`
--

CREATE TABLE IF NOT EXISTS `bitacora` (
  `codigo` int(11) NOT NULL DEFAULT '0',
  `fecha` date DEFAULT NULL,
  `horainicio` time DEFAULT NULL,
  `horafin` time DEFAULT NULL,
  `estudiante` char(9) DEFAULT NULL,
  `aula` char(2) DEFAULT NULL,
  `equipo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `estudiante` (`estudiante`),
  KEY `aula` (`aula`),
  KEY `equipo` (`equipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE IF NOT EXISTS `equipo` (
  `codigo` varchar(20) NOT NULL DEFAULT '',
  `mac` varchar(20) DEFAULT NULL,
  `aula` char(2) DEFAULT NULL,
  `procesador` varchar(10) DEFAULT NULL,
  `modelo_procesador` varchar(50) DEFAULT NULL,
  `mgz_procesador` varchar(10) DEFAULT NULL,
  `sistema_archivos` varchar(50) DEFAULT NULL,
  `tamaño_disco_duro` varchar(10) DEFAULT NULL,
  `particiones_disco` varchar(50) DEFAULT NULL,
  `ram_total` varchar(20) DEFAULT NULL,
  `nombre_usuario` varchar(30) DEFAULT NULL,
  `sistema_operativo` varchar(15) DEFAULT NULL,
  `arquitectura_so` varchar(10) DEFAULT NULL,
  `version_so` varchar(5) DEFAULT NULL,
  `serial` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `serial` (`serial`),
  KEY `aula` (`aula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`codigo`, `mac`, `aula`, `procesador`, `modelo_procesador`, `mgz_procesador`, `sistema_archivos`, `tamaño_disco_duro`, `particiones_disco`, `ram_total`, `nombre_usuario`, `sistema_operativo`, `arquitectura_so`, `version_so`, `serial`) VALUES
('01', '9C-B7-0D-3B-14-AF', '02', 'Intel', 'Core(TM) i5-2450M CPU @ 2.50GHz', '2494', 'C: NTFS;D: NTFS;H: NTFS;Q: NTFS;', '542 GB', '[C:, D:, F:, H:, Q:]', '4240289792 KB', 'GermanV', 'Windows 8', 'amd64', '6.2', '1C224853W');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo_novedad`
--

CREATE TABLE IF NOT EXISTS `equipo_novedad` (
  `equipo` varchar(20) DEFAULT NULL,
  `novedad` char(3) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `estado` char(1) DEFAULT NULL,
  KEY `equipo` (`equipo`),
  KEY `novedad` (`novedad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `equipo_novedad`
--

INSERT INTO `equipo_novedad` (`equipo`, `novedad`, `descripcion`, `fecha`, `hora`, `estado`) VALUES
('01', '001', 'jajajajajaja', '2014-05-27', '23:16:11', '1'),
('01', '001', 'ensayo', '2014-05-28', '00:53:39', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE IF NOT EXISTS `estudiante` (
  `codigo` char(9) NOT NULL DEFAULT '',
  `nombre1` varchar(20) DEFAULT NULL,
  `nombre2` varchar(20) DEFAULT NULL,
  `apellido1` varchar(20) DEFAULT NULL,
  `apellido2` varchar(20) DEFAULT NULL,
  `programa` char(4) DEFAULT NULL,
  `semestre` char(2) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `contraseña` varchar(30) DEFAULT NULL,
  `tipo` char(1) DEFAULT NULL,
  `estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `programa` (`programa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`codigo`, `nombre1`, `nombre2`, `apellido1`, `apellido2`, `programa`, `semestre`, `correo`, `contraseña`, `tipo`, `estado`) VALUES
('201251027', 'JHONNY', '', 'SIERRA', 'PARRA', '2711', '5', 'jhonny.sierra@correounivalle.edu.co', 'jhonny', '1', '1'),
('201251103', 'MAURICIO', '', 'RIVERA', 'AVALO', '2711', '5', 'jhonny.sierra@correounivalle.edu.co', '12345', '0', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `novedad`
--

CREATE TABLE IF NOT EXISTS `novedad` (
  `codigo` char(3) NOT NULL DEFAULT '',
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `novedad`
--

INSERT INTO `novedad` (`codigo`, `descripcion`) VALUES
('001', 'SOFTWARE'),
('002', 'HARDWARE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `programa`
--

CREATE TABLE IF NOT EXISTS `programa` (
  `codigo` char(4) NOT NULL DEFAULT '',
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `programa`
--

INSERT INTO `programa` (`codigo`, `nombre`) VALUES
('2711', 'TECNOLOGÍA EN SISTEMAS DE INFORMACIÓN');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bitacora`
--
ALTER TABLE `bitacora`
  ADD CONSTRAINT `bitacora_ibfk_1` FOREIGN KEY (`estudiante`) REFERENCES `estudiante` (`codigo`),
  ADD CONSTRAINT `bitacora_ibfk_2` FOREIGN KEY (`aula`) REFERENCES `aula` (`codigo`),
  ADD CONSTRAINT `bitacora_ibfk_3` FOREIGN KEY (`equipo`) REFERENCES `equipo` (`codigo`);

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `equipo_ibfk_1` FOREIGN KEY (`aula`) REFERENCES `aula` (`codigo`);

--
-- Filtros para la tabla `equipo_novedad`
--
ALTER TABLE `equipo_novedad`
  ADD CONSTRAINT `equipo_novedad_ibfk_1` FOREIGN KEY (`equipo`) REFERENCES `equipo` (`codigo`),
  ADD CONSTRAINT `equipo_novedad_ibfk_2` FOREIGN KEY (`novedad`) REFERENCES `novedad` (`codigo`);

--
-- Filtros para la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD CONSTRAINT `estudiante_ibfk_1` FOREIGN KEY (`programa`) REFERENCES `programa` (`codigo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
