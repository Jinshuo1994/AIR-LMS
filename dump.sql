CREATE DATABASE  IF NOT EXISTS `airlmsdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `airlmsdb`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: airlmsdb
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Table structure for table `annc`
--

DROP TABLE IF EXISTS `annc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `annc` (
  `anncId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `anncTitle` varchar(100) DEFAULT NULL,
  `annc` varchar(1000) DEFAULT NULL,
  `courseId` int(10) unsigned NOT NULL,
  `anncPublish` tinyint(4) NOT NULL,
  PRIMARY KEY (`anncId`),
  UNIQUE KEY `annc_id_UNIQUE` (`anncId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annc`
--

LOCK TABLES `annc` WRITE;
/*!40000 ALTER TABLE `annc` DISABLE KEYS */;
INSERT INTO `annc` VALUES (3,'exam','sdfsdfsd',2,1),(4,'break','today is break',3,1),(5,'new student','Hkhhhkjerewrewr',3,1),(6,'new course','Khjbbhjjbjbhj',3,1),(8,'quiz','sdfdsf fdsfdd dsdsfdfdfsfdsdfd dfsfdffds sdfdsfdsf sdfdsfdfdsf',2,0),(9,'quiz-latest','dsfdsfdssdfdsf',2,0),(10,'exam change','jbkjbk',2,0),(11,'group study','jn,nmnm, ,n,n',2,0),(19,'final exam','cvcv',2,0),(21,'dsfsd','dsfdsfdsf',1,0),(22,'Final exam time change','The final is changed to Dec 12th',1,0),(23,'Final exam time change','The final exam will be changed to Dec12th',1,0),(24,'Test','this is a test for new announcement',1,0);
/*!40000 ALTER TABLE `annc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `courseId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `courseName` varchar(45) DEFAULT NULL,
  `courseLoc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`courseId`),
  UNIQUE KEY `courseid_UNIQUE` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=909001 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'computer vision','CSI'),(2,'enpm612','CSI'),(3,'algorithm','JMP'),(4,'data science','abc'),(5,'data mining','JMP'),(10,'music','AVW'),(77,'drawing','AVW'),(123,'art','TBA'),(1211,'vollyball','JMP'),(1999,'football','TBA'),(12345,'vollyball','ABD'),(909000,'XML technoloy','JMP');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollment`
--

DROP TABLE IF EXISTS `enrollment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enrollment` (
  `courseId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`courseId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollment`
--

LOCK TABLES `enrollment` WRITE;
/*!40000 ALTER TABLE `enrollment` DISABLE KEYS */;
INSERT INTO `enrollment` VALUES (1,3),(1,4),(1,8),(1,22),(2,3),(2,15),(2,22),(3,3),(3,15),(3,22),(123,13),(123,14),(1999,2),(909000,22);
/*!40000 ALTER TABLE `enrollment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syllabus`
--

DROP TABLE IF EXISTS `syllabus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syllabus` (
  `syllabusId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `syllabus` varchar(3000) DEFAULT NULL,
  `courseId` int(10) unsigned NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `published` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`syllabusId`),
  UNIQUE KEY `syllabus_id_UNIQUE` (`syllabusId`)
) ENGINE=InnoDB AUTO_INCREMENT=390 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syllabus`
--

LOCK TABLES `syllabus` WRITE;
/*!40000 ALTER TABLE `syllabus` DISABLE KEYS */;
INSERT INTO `syllabus` VALUES (376,'this a test syllabus',2,'1','1'),(383,'test here!',3,'1','0'),(389,'this is a new syllabus',1,'1','0');
/*!40000 ALTER TABLE `syllabus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `userRole` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userid_UNIQUE` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin','admin'),(2,'Danmei Ye','root','student'),(3,'Jinan','root','student'),(4,'Jinshuo','12345','student'),(5,'Kanaha','fsdfsd','student'),(6,'Joe','111111','student'),(7,'Jack','sdf','student'),(8,'Lisa','111111','student'),(9,'Minging','111111','instructor'),(10,'Zhang','sdfdsdsfsdf','student'),(21,'Mike','123456','instructor'),(22,'instructor','instructor','instructor'),(23,'Jinan1234','12345','student'),(24,'Ming Lee','123456','student');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-10  0:16:37
