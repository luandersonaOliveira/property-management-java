CREATE DATABASE  IF NOT EXISTS `property_management` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `property_management`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: property_management
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `landlord`
--

DROP TABLE IF EXISTS `landlord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `landlord` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `landlord`
--

LOCK TABLES `landlord` WRITE;
/*!40000 ALTER TABLE `landlord` DISABLE KEYS */;
INSERT INTO `landlord` VALUES (1,'LIANG','746.785.060-39','(86) 98601-2358','Liang@gmail.com.br'),(2,'RAVI','898.670.018-26','(62) 98933-5737','Ravi@gmail.com.br'),(3,'ELLI','214.221.879-26','(63) 99884-5787','Elli@gmail.com.br'),(4,'NORABEL','387.667.186-86','(92) 99904-2606','Norabel@gmail.com.br'),(5,'YUYAN','946.141.564-87','(62) 99104-6653','YuYan@gmail.com.br');
/*!40000 ALTER TABLE `landlord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lease`
--

DROP TABLE IF EXISTS `lease`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lease` (
  `id` int NOT NULL AUTO_INCREMENT,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `id_property` int NOT NULL,
  `cpf_landlord` varchar(14) NOT NULL,
  `cpf_tenant` varchar(14) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_property` (`id_property`),
  KEY `cpf_landlord` (`cpf_landlord`),
  KEY `cpf_tenant` (`cpf_tenant`),
  CONSTRAINT `lease_ibfk_1` FOREIGN KEY (`id_property`) REFERENCES `property` (`id`),
  CONSTRAINT `lease_ibfk_2` FOREIGN KEY (`cpf_landlord`) REFERENCES `landlord` (`cpf`),
  CONSTRAINT `lease_ibfk_3` FOREIGN KEY (`cpf_tenant`) REFERENCES `tenant` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lease`
--

LOCK TABLES `lease` WRITE;
/*!40000 ALTER TABLE `lease` DISABLE KEYS */;
INSERT INTO `lease` VALUES (1,'2024-10-19','2025-10-10',2,'898.670.018-26','157.842.369-00');
/*!40000 ALTER TABLE `lease` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `property` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `rental_value` double NOT NULL,
  `type` enum('RESIDENTIAL','COMMERCIAL') NOT NULL,
  `occupation` enum('UNOCCUPIED','OCCUPIED') NOT NULL,
  `cpf_landlord` varchar(14) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cpf_landlord` (`cpf_landlord`),
  CONSTRAINT `property_ibfk_1` FOREIGN KEY (`cpf_landlord`) REFERENCES `landlord` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (1,'RUA GONÇALO DE CARVALHO (RS)',1000,'RESIDENTIAL','OCCUPIED','746.785.060-39'),(2,'RUA DO MUCUGÊ (BA)',1200,'COMMERCIAL','UNOCCUPIED','898.670.018-26'),(3,'RUA DAS PEDRAS (RJ)',1600,'RESIDENTIAL','UNOCCUPIED','214.221.879-26'),(4,'RUA DA AURORA (PE)',1800,'COMMERCIAL','UNOCCUPIED','387.667.186-86'),(5,'RUA BENTO GONÇALVES (RS)',2000,'RESIDENTIAL','UNOCCUPIED','946.141.564-87');
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant`
--

DROP TABLE IF EXISTS `tenant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tenant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `balance` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant`
--

LOCK TABLES `tenant` WRITE;
/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` VALUES (1,'GURU','157.842.369-00','12365-4789','guru@gmail.com',1265);
/*!40000 ALTER TABLE `tenant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant_lease`
--

DROP TABLE IF EXISTS `tenant_lease`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tenant_lease` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_tenant` int NOT NULL,
  `id_lease` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `id_tenant` (`id_tenant`),
  KEY `id_lease` (`id_lease`),
  CONSTRAINT `tenant_lease_ibfk_1` FOREIGN KEY (`id_tenant`) REFERENCES `tenant` (`id`),
  CONSTRAINT `tenant_lease_ibfk_2` FOREIGN KEY (`id_lease`) REFERENCES `lease` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant_lease`
--

LOCK TABLES `tenant_lease` WRITE;
/*!40000 ALTER TABLE `tenant_lease` DISABLE KEYS */;
/*!40000 ALTER TABLE `tenant_lease` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-21 15:55:46
