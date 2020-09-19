-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: demo
-- ------------------------------------------------------
-- Server version	5.6.37-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `trainsclass`
--

DROP TABLE IF EXISTS `trainsclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trainsclass` (
  `Serno` int(11) NOT NULL AUTO_INCREMENT,
  `ClassNo` varchar(80) NOT NULL,
  `ClassName` varchar(80) NOT NULL,
  `ClassColor` varchar(50) NOT NULL,
  `ClassFare` varchar(50) NOT NULL,
  PRIMARY KEY (`Serno`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainsclass`
--

LOCK TABLES `trainsclass` WRITE;
/*!40000 ALTER TABLE `trainsclass` DISABLE KEYS */;
INSERT INTO `trainsclass` VALUES (1,'1100','自強','red','成自'),(2,'1101','自強','red','成自'),(3,'1102','太魯閣','blue','成自'),(4,'1103','自強','red','成自'),(5,'1107','普悠瑪','pink','成自'),(6,'1108','自強','red','成自'),(7,'1110','莒光','orange','成莒'),(8,'1111','莒光','orange','成莒'),(9,'1114','莒光','orange','成莒'),(10,'1115','莒光','orange','成莒'),(11,'1120','復興','','成復'),(12,'1131','區間車','','成復'),(13,'1132','區間快車','grey','成復'),(14,'1140','普快車','','成普');
/*!40000 ALTER TABLE `trainsclass` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-07  0:04:49
