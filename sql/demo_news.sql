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
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Date1` int(80) NOT NULL,
  `Subject1` varchar(80) NOT NULL,
  `Content1` varchar(2000) NOT NULL,
  `Link` varchar(50) DEFAULT NULL,
  `Picture` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,20170814,'臺鐵局定於106年9月6日進行年度列車時刻調整','臺鐵局定於106年9月6日進行年度列車時刻調整\n臺鐵局為配合新富站啟用，暨因應南迴線電氣化工程施工需要，自106年9月6日零時起調整列車時刻。相關列車車次、時刻，即日起請參閱本局列車時刻查詢系統網站（網址：http://twtraffic.tra.gov.tw/twrail/)及各車站公告。\n另南迴鐵路因地處偏遠，施工條件不佳，為增加夜間施工時間，潮州－臺東間自106年9月6日至108年6月30日止，逢週一至週四、週六19點起至翌日6點止停駛客運列車，改採公路客運替代運輸，惟寒假、暑假及3天以上連續假日及補上班之週六除外，相關資訊可參閱交通部鐵路改建工程局網站（網址：http://www.rrb.gov.tw/02310.aspx?lan=ch&id=742）。',NULL,NULL),(2,20170814,' 為疏運暑期出遊人潮需要，指定日期再次加開臨時旅客列車','為疏運暑期出遊人潮需要，指定日期再次加開臨時旅客列車\n為疏運暑期出遊人潮需要，指定日期再次加開臨時旅客列車如下：\n一、加開旅客列車：\n(一)8月16~31日(共16天) 樹林=花蓮 5204次。【普悠瑪號】\n(二)8月16~31日(共16天) 花蓮=樹林 5215次。【普悠瑪號】',NULL,NULL),(3,20170814,'  為因應海洋音樂祭及暑假期間旅客疏運需要，指定日期區間快車增停福隆站','為因應海洋音樂祭及暑假期間旅客疏運需要，指定日期區間快車增停福隆站\n為因應海洋音樂祭及暑假期間旅客疏運需要，指定日期區間快車增停【福隆站】如下：\n一、區間快車增停福隆站：\n(一)7月28、29、30日；8月5、6、12、13、19、20、26、27日【共11天】\n1.下行：樹林=蘇澳 4026次。\n2.上行：蘇澳=樹林 4027次。',NULL,NULL),(4,20170814,'  為疏運暑假出遊人潮需要，指定日期再加開臨時旅客列車','為疏運暑假出遊人潮需要，指定日期再加開臨時旅客列車\n為疏運暑假出遊人潮需要，指定日期再加開臨時旅客列車如下：\n一、加開旅客列車：\n(一) 7月15、16、22、23、29、30日；8月5、6、12、13、19、20、26、27日(共14天)\n新竹=花蓮 5694次。【復興號】(使用區間車編組)\n(二) 7月15、16、22、23、29、30日；8月5、6、12、13、19、20、26、27日(共14天)\n花蓮=新竹 5699次。【復興號】(使用區間車編組)\n二、7月15-16日、22-23日、29-30日之加開班次，訂於106年7月14日(星期五)0時起，開放網路及電話音訂票。',NULL,NULL),(5,20170814,' 配合業務需要，指定日期加開旅客列車','配合業務需要，指定日期加開旅客列車\n配合業務需要，指定日期加開旅客列車如下：\n一、加開區間快車：\n(一)7月7~9、14~16、21~23、28~30日；8月4~6、11~13、18~20、25~27日。(共24天)\n\n花蓮=宜蘭 5403次。【區間快車】\n\n(二)7月7~9、14~16、21~23、28~30日；8月4~6、11~13、18~20、25~27日。(共24天)\n\n宜蘭=花蓮 5402次。【區間快車】',NULL,NULL),(58,20170830,'配合基隆市政府舉辦『2017丁酉雞籠中元祭活動』疏運旅客需要，指定日期加開列車','配合基隆市政府舉辦『2017丁酉雞籠中元祭活動』疏運旅客需要，指定日期加開列車\r\n配合基隆市政府舉辦『2017丁酉雞籠中元祭活動』疏運旅客需要，指定日期加開旅客列車如下：\r\n一、加開【區間車】：\r\n\r\n（一）9月5日 基隆=樹林 1303次。 \r\n（二）9月5日 基隆=台北 1307次。 ','aa','null'),(40,20170827,'臺鐵局106年9月6日起實施潮州－臺東間公路客運替代運輸','臺鐵局106年9月6日起實施潮州－臺東間公路客運替代運輸\r\n南迴鐵路因地處偏遠，施工條件不佳，臺鐵局配合南迴線電氣化工程施工需要，為增加夜間施工時間，潮州－臺東間自106年9月6日至108年6月30日止，逢週一至週四、週六自19點起至翌日6點止停駛客運列車，改採公路客運替代運輸，惟寒假、暑假期間、國定假日及3天以上連續假日及補上班之週六除外。\r\n','ll','null');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
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
