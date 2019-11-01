CREATE DATABASE  IF NOT EXISTS `api_facturacion` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `api_facturacion`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: api_facturacion
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `tb_cargo`
--

DROP TABLE IF EXISTS `tb_cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cargo` (
  `id_cargo` bigint(20) NOT NULL AUTO_INCREMENT,
  `estado` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `total` double NOT NULL,
  `id_evento` int(11) NOT NULL,
  `id_factura` bigint(20) NOT NULL,
  PRIMARY KEY (`id_cargo`),
  KEY `FKrauj5frugis4si841sw75o55o` (`id_evento`),
  KEY `FK9750t7m8f37a21fcn3amxiw00` (`id_factura`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cargo`
--

LOCK TABLES `tb_cargo` WRITE;
/*!40000 ALTER TABLE `tb_cargo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cargo_pago`
--

DROP TABLE IF EXISTS `tb_cargo_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cargo_pago` (
  `id_cargo_pago` bigint(20) NOT NULL AUTO_INCREMENT,
  `monto_asociado` double NOT NULL,
  `id_cargo` bigint(20) NOT NULL,
  `id_pago` bigint(20) NOT NULL,
  PRIMARY KEY (`id_cargo_pago`),
  KEY `FKj64n3xgdn4nnesi328hy84ubi` (`id_cargo`),
  KEY `FKeejc9cqfk96dflechf31fuqib` (`id_pago`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cargo_pago`
--

LOCK TABLES `tb_cargo_pago` WRITE;
/*!40000 ALTER TABLE `tb_cargo_pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_cargo_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_categoria_evento`
--

DROP TABLE IF EXISTS `tb_categoria_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_categoria_evento` (
  `id_categoria_evento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id_categoria_evento`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_categoria_evento`
--

LOCK TABLES `tb_categoria_evento` WRITE;
/*!40000 ALTER TABLE `tb_categoria_evento` DISABLE KEYS */;
INSERT INTO `tb_categoria_evento` VALUES (1,'Market Place'),(2,'Servicios'),(3,'Externo');
/*!40000 ALTER TABLE `tb_categoria_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_evento`
--

DROP TABLE IF EXISTS `tb_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_evento` (
  `id_evento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `id_categoria_evento` int(11) NOT NULL,
  PRIMARY KEY (`id_evento`),
  KEY `FK7coeqh2l2iq86mt835lt9alcs` (`id_categoria_evento`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_evento`
--

LOCK TABLES `tb_evento` WRITE;
/*!40000 ALTER TABLE `tb_evento` DISABLE KEYS */;
INSERT INTO `tb_evento` VALUES (1,'Clasificado',1),(2,'Venta',1),(3,'Publicidad',2),(4,'Envío',1),(5,'Crédito',2),(6,'MercadoPago',3),(7,'MercadoShop',3),(8,'Fidelidad',2);
/*!40000 ALTER TABLE `tb_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_factura`
--

DROP TABLE IF EXISTS `tb_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_factura` (
  `id_factura` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_facturacion` date NOT NULL,
  `id_usuario` bigint(20) NOT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `FKf929t2i2o9rspk8v9ahadc97x` (`id_usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_factura`
--

LOCK TABLES `tb_factura` WRITE;
/*!40000 ALTER TABLE `tb_factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_moneda`
--

DROP TABLE IF EXISTS `tb_moneda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_moneda` (
  `id_moneda` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`id_moneda`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_moneda`
--

LOCK TABLES `tb_moneda` WRITE;
/*!40000 ALTER TABLE `tb_moneda` DISABLE KEYS */;
INSERT INTO `tb_moneda` VALUES (1,'Peso Argentino',1),(2,'Dólar',60);
/*!40000 ALTER TABLE `tb_moneda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pago`
--

DROP TABLE IF EXISTS `tb_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_pago` (
  `id_pago` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `monto` double NOT NULL,
  PRIMARY KEY (`id_pago`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pago`
--

LOCK TABLES `tb_pago` WRITE;
/*!40000 ALTER TABLE `tb_pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `fecha_alta` datetime NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `UK_spmnyb4dsul95fjmr5kmdmvub` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'Smith','msmith@gmail.com','2017-10-05 12:24:34','Mario'),(2,'López','jlopez@gmail.com','2018-12-07 16:34:40','Jorge'),(3,'Perlo','aperlo@gmail.com','2019-01-27 21:42:15','Antonio'),(4,'Risco','orisco@gmail.com','2019-04-12 04:50:31','Omar');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-01  0:16:56
