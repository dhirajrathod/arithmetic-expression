CREATE DATABASE  IF NOT EXISTS `pegasus_test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `pegasus_test`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: pegasus_test
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `arithmetic_expression_details`
--

DROP TABLE IF EXISTS `arithmetic_expression_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `arithmetic_expression_details` (
  `id` bigint(8) NOT NULL AUTO_INCREMENT,
  `expression` varchar(500) DEFAULT NULL,
  `output` varchar(500) DEFAULT NULL,
  `created_datetime` datetime DEFAULT NULL,
  `updated_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arithmetic_expression_details`
--

LOCK TABLES `arithmetic_expression_details` WRITE;
/*!40000 ALTER TABLE `arithmetic_expression_details` DISABLE KEYS */;
INSERT INTO `arithmetic_expression_details` VALUES (1,'(2+4)*5 ','30','2020-03-29 16:56:27','2020-03-29 16:56:27'),(2,'(2+4)*4','24','2020-03-29 16:56:57','2020-03-29 16:56:57'),(3,'(2+4)*3','18','2020-03-29 16:57:20','2020-03-29 16:57:20'),(4,'(4-2)*2','4','2020-03-29 16:57:26','2020-03-29 16:57:26');
/*!40000 ALTER TABLE `arithmetic_expression_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pegasus_test'
--

--
-- Dumping routines for database 'pegasus_test'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-29 17:00:00
