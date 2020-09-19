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
-- Table structure for table `fq`
--

DROP TABLE IF EXISTS `fq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fq` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Question` varchar(500) NOT NULL,
  `Answer` varchar(1000) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fq`
--

LOCK TABLES `fq` WRITE;
/*!40000 ALTER TABLE `fq` DISABLE KEYS */;
INSERT INTO `fq` VALUES (1,'網路訂不到，現場購票卻有?','1.查本局座位之分配，主要係考量座位運用效益，故售票系統於進行原始配位時，即儘量以中長途旅客為主，另考量短途旅運需求多為臨時性需求，故售票系統設定於乘車日前3天，長途座位尚有剩餘時，始開放座位截短發售功能，供短途旅客購訂票。故旅客若於系統尚未開放截短期間上網訂票，是有可能發生上述情事。本局建議可於乘車前3日時，再次利用語音/網路訂票系統訂票。 \r\n2.又目前本局售票系統係全省連線售票，座位庫料檔即時更新，現場可售座位，亦隨時因旅客退換票而有所異動。 '),(2,'	網路付款完成後最晚取票時間，是否一定要於搭乘班次開車前30分鐘，至車站售票窗口完成取票？','購票乘車或取票乘車應考量排隊人潮及上下月台時間，建議您及早至車站取票，以避免過於匆忙發生危險。'),(3,'為什麼取票，座位有時會不在一起呢？','本局客座劃座原則依序為:（一）相鄰座位；（二）相同車廂；（三）零散座位。訂票後，座位即依上述原則劃定，若僅剩零散座位，則無法提供相鄰座位。如座位不符需求，乘車前可洽車站售票人員，就旅客退票相鄰剩餘座位提供協助。'),(4,'	高級列車（含自強、莒光、復興號）停靠站標準為何？','	規劃列車停靠，主要係衡量各站經濟發展情形、旅客流量、乘車人數多寡及營運收入，並考量列車等級、運轉條件及長短途各類不同旅客需求予以決定，如以西線為例，其停靠標準原則如下： \r\n(1)自強號： \r\n直達車（始發站開車後至終點站沿途停靠四至五站）。 \r\n半直達車（始發站開車後至終點站沿途停靠約八站左右）。 \r\n非直達車（始發站開車後至終點站沿途停靠十三至十六站）。 \r\n(2)莒光號：停靠十八至二十一站。 \r\n(3)復興號：停靠三十站左右。 \r\n註：基於業務考量（例如疏解自強號擁擠程度），部分復興號、莒光號或區間列車以半直達方式行駛。');
/*!40000 ALTER TABLE `fq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-07  0:04:48
