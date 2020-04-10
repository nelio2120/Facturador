-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: medianet
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad` (
  `idciudad` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `idprovincia` int(11) NOT NULL,
  PRIMARY KEY (`idciudad`),
  KEY `fk_provincia_idx` (`idprovincia`),
  CONSTRAINT `fk_provincia` FOREIGN KEY (`idprovincia`) REFERENCES `provincia` (`idProvincia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'GUAYAQUIL',1),(2,'LATACUNGA',2),(3,'QUEVEDO',3);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comercio`
--

DROP TABLE IF EXISTS `comercio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comercio` (
  `idcomercio` int(11) NOT NULL,
  `asesor` varchar(45) NOT NULL,
  `vip` varchar(45) NOT NULL,
  `codigo` varchar(45) NOT NULL,
  `nombre_comercial` varchar(45) NOT NULL,
  `razon_social` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `ruc` varchar(45) NOT NULL,
  `gerente` varchar(45) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `ciudad` int(11) NOT NULL,
  `giro_comercio` int(11) NOT NULL,
  `cadena` varchar(45) DEFAULT NULL,
  `nombre_cadena` varchar(45) DEFAULT NULL,
  `correo` varchar(45) NOT NULL,
  `contacto` varchar(45) NOT NULL,
  `telefono_contacto` varchar(45) NOT NULL,
  `idusuario` int(11) NOT NULL,
  PRIMARY KEY (`idcomercio`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_usuario_comercio_idx` (`idusuario`),
  KEY `fk_ciudad_idx` (`ciudad`),
  CONSTRAINT `fk_ciudad` FOREIGN KEY (`ciudad`) REFERENCES `ciudad` (`idciudad`),
  CONSTRAINT `fk_usuario_comercio` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuarios`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comercio`
--

LOCK TABLES `comercio` WRITE;
/*!40000 ALTER TABLE `comercio` DISABLE KEYS */;
INSERT INTO `comercio` VALUES (1,'BYRON NIETO','NO','877352','DISTRIBUIDORA SALAZAR','SALAZAR OBANDO VIVIANA PRISCILA','ACTIVO','1206092528001','SALAZAR OBANDO VIVIANA PRISCILA','SAN CAMILO AV GUAYAQUIL 322 Y GUATEMALA',1,5532,NULL,NULL,'abgvivianasalazar2017 gmail com','SALAZAR OBANDO VIVIANA PRISCILA','0958996419',1),(2,'VICTOR CAMPOVERDE','NO','881434','NAFIT','CANCIO SALAZAR DICK JONATHAN','ACTIVO','0927754085001','CANCIO SALAZAR DICK JONATHAN','CEIBOS 3 EDIF MBC PB ,AV LEOPOLDO CARRERA MZ 60 V4',1,7298,NULL,NULL,'dick_kidi@hotmail.com','CANCIO SALAZAR DICK JONATHAN','0963062346',1),(3,'JUAN CARLOS GUAMA','NO','861109','RUMIPAMBA DE LAS ROSAS','RUMIPAMBA DE LAS ROSAS S A','ACTIVO','1790269450001','LUIS GILBERTO MENESES MONCRIEFF','AV NORTE 3501 Y AV ELOY YEROVI JNT HOSP SALCEDO',1,7011,NULL,NULL,'cobranzas@rumipamba.com','GABY RODRIGUEZ','03 2726128',1);
/*!40000 ALTER TABLE `comercio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_equipo`
--

DROP TABLE IF EXISTS `detalle_equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_equipo` (
  `iddetalle_equipo` int(11) NOT NULL,
  `idequipo` int(11) NOT NULL,
  `idcomercio` int(11) NOT NULL,
  PRIMARY KEY (`iddetalle_equipo`),
  UNIQUE KEY `idequipo_UNIQUE` (`idequipo`),
  KEY `fk_comercio_cabecera_idx` (`idcomercio`),
  CONSTRAINT `fk_comercio_cabecera` FOREIGN KEY (`idcomercio`) REFERENCES `comercio` (`idcomercio`),
  CONSTRAINT `fk_equipos_cabecera` FOREIGN KEY (`idequipo`) REFERENCES `equipo` (`idequipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_equipo`
--

LOCK TABLES `detalle_equipo` WRITE;
/*!40000 ALTER TABLE `detalle_equipo` DISABLE KEYS */;
INSERT INTO `detalle_equipo` VALUES (1,1,1),(2,2,2),(3,3,3);
/*!40000 ALTER TABLE `detalle_equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entidad_bancaria`
--

DROP TABLE IF EXISTS `entidad_bancaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entidad_bancaria` (
  `identidad_bancaria` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`identidad_bancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entidad_bancaria`
--

LOCK TABLES `entidad_bancaria` WRITE;
/*!40000 ALTER TABLE `entidad_bancaria` DISABLE KEYS */;
INSERT INTO `entidad_bancaria` VALUES (1,'INTERNACIONAL','ACTIVO'),(2,'AMAZONAS','ACTIVO'),(3,'MACHALA','ACTIVO'),(4,'SOLIDARIO','ACTIVO'),(5,'BOLIVARIANO','ACTIVO'),(6,'PRODUBANCO','ACTIVO');
/*!40000 ALTER TABLE `entidad_bancaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipo` (
  `idequipo` int(11) NOT NULL,
  `serie` int(11) NOT NULL,
  `terminal` int(11) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `estado_registro` varchar(45) NOT NULL,
  `idestatus` int(11) NOT NULL,
  `fecha_estatus` date NOT NULL,
  ` coneccion` varchar(45) NOT NULL,
  `nfc` varchar(45) NOT NULL,
  `transaccion_manual` varchar(45) NOT NULL,
  `idbanco` int(11) NOT NULL,
  PRIMARY KEY (`idequipo`),
  UNIQUE KEY `serie_UNIQUE` (`serie`),
  UNIQUE KEY `terminal_UNIQUE` (`terminal`),
  KEY `fk_estatus_idx` (`idestatus`),
  KEY `fk_banco_idx` (`idbanco`),
  CONSTRAINT `fk_banco` FOREIGN KEY (`idbanco`) REFERENCES `entidad_bancaria` (`identidad_bancaria`),
  CONSTRAINT `fk_estatus` FOREIGN KEY (`idestatus`) REFERENCES `estatus` (`idestatus`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES (1,333754019,33754019,'C680','ACTIVO',1,'2020-03-03','GPRS','NO','NO HABILITADO',6),(2,333754020,33754020,'C680','ACTIVO',1,'2020-03-03','GPRS','NO','NO HABILITADO',5),(3,333753462,33753462,'C680','ACTIVO',1,'2020-03-03','GPRS','NO','NO HABILITADO',6);
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estatus`
--

DROP TABLE IF EXISTS `estatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estatus` (
  `idestatus` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idestatus`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estatus`
--

LOCK TABLES `estatus` WRITE;
/*!40000 ALTER TABLE `estatus` DISABLE KEYS */;
INSERT INTO `estatus` VALUES (1,'INSTALADO','ACTIVO'),(2,'SINIESTRADO','ACTIVO'),(3,'DAÑADO','ACTIVO');
/*!40000 ALTER TABLE `estatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `cedula` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `estado` varchar(8) NOT NULL,
  PRIMARY KEY (`idpersona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'MATEO SEBASTIAN','HIDALGO BRAVO','1724911217','0987256083','mateo.hidalgo@akroscorp.com','ACTIVO'),(2,'NELIO REYNALDO ','CIGUENCIA CADENA','0953864177','0939428383','neliomarcos@gmail.com','ACTIVO');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provincia` (
  `idProvincia` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idProvincia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (1,'GUAYAS','ACTIVO'),(2,'COTOPAXI','ACTIVO'),(3,'LOS RIOS','ACTIVO');
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `estado` varchar(8) NOT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'TECNICO','ACTIVO'),(2,'SUPERVISOR','ACTIVO');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idusuarios` int(11) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `idrol` int(11) NOT NULL,
  `idpersona` int(11) NOT NULL,
  PRIMARY KEY (`idusuarios`),
  KEY `fk_persona_idx` (`idpersona`),
  KEY `fk_rol_idx` (`idrol`),
  CONSTRAINT `fk_persona` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`),
  CONSTRAINT `fk_rol` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'GOLDST72','123456789',1,1),(2,'NELIO2120','123456789',2,2);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'medianet'
--

--
-- Dumping routines for database 'medianet'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-04 19:48:18
