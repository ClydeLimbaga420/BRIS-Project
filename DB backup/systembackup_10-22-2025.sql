-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: systemdb
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `blotter`
--

DROP TABLE IF EXISTS `blotter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blotter` (
  `record_num` int NOT NULL AUTO_INCREMENT,
  `complainant_first_name` varchar(250) DEFAULT NULL,
  `complainant_middle_name` varchar(250) DEFAULT 'None',
  `complainant_last_name` varchar(250) DEFAULT NULL,
  `complainant_age` int DEFAULT NULL,
  `complainant_address` varchar(250) DEFAULT NULL,
  `blottered_first_name` varchar(250) DEFAULT NULL,
  `blottered_middle_name` varchar(250) DEFAULT 'None',
  `blottered_last_name` varchar(250) DEFAULT NULL,
  `complained_age` int DEFAULT NULL,
  `complained_address` varchar(250) DEFAULT NULL,
  `statement_of_complain` longtext,
  `action_taken` longtext,
  `location_of_incidence` varchar(250) DEFAULT NULL,
  `date_of_complain` date DEFAULT NULL,
  `blotter_status` enum('Pending','Active','Resolved','Referred') DEFAULT NULL,
  `officer_in_charge` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`record_num`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blotter`
--

LOCK TABLES `blotter` WRITE;
/*!40000 ALTER TABLE `blotter` DISABLE KEYS */;
INSERT INTO `blotter` VALUES (5,'Jayvince','None','Singco',19,'Mangako','Jaymark','None','Pimentel',19,'Sto. Nino','Nangwat ug selpon','Nothing','CTU Ginatilan','2025-10-09','Pending',NULL);
/*!40000 ALTER TABLE `blotter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificates`
--

DROP TABLE IF EXISTS `certificates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certificates` (
  `certificate_id` int NOT NULL AUTO_INCREMENT,
  `issue_date` date DEFAULT NULL,
  `certificates_choice` enum('Clearance','Indigency','Residency','Business Clearance') DEFAULT NULL,
  `purpose` longtext NOT NULL,
  `full_name` varchar(250) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sitio` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`certificate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificates`
--

LOCK TABLES `certificates` WRITE;
/*!40000 ALTER TABLE `certificates` DISABLE KEYS */;
INSERT INTO `certificates` VALUES (1,'2025-10-13','Indigency','sospasopaspa','Clyde Limbaga',19,'Proper'),(2,'2025-10-13','Business Clearance','i want to sell','Clydes Beloira',19,'Proper');
/*!40000 ALTER TABLE `certificates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history` (
  `history_no` int NOT NULL AUTO_INCREMENT,
  `history_table` longtext,
  PRIMARY KEY (`history_no`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,'Added Marcos Bong Bong in Residents'),(2,'Changed Last Name of First Laststolast'),(3,'Changed First Name of First LaststoFirsts'),(4,'Changed First Name of First lasttofirsts'),(5,'Changed Last Name of First last to last'),(6,'Changed Last Name of Bongbong marcos to socram'),(7,'Changed Last Name of bongbong socram to marcos'),(8,'Changed First Name of bongbong socramtobongbong'),(9,'Changed Last Name of bongbong marcos to socram'),(10,'Changed Last Name of bongbong socram to marcos'),(11,'Changed Last Name of bongbong marcos to socram'),(12,'Changed Last Name of bongbong socram to marcos'),(13,'Changed Last Name of bongbong socram to marcos'),(14,'Changed Last Name of bongbong socram to socram'),(15,'Changed Last Name of bongbong marcos to socram'),(16,'Changed Last Name of bongbong socram to marcos'),(17,'Changed Last Name of bongbong marcos to socram'),(18,'Changed Last Name of bongbong marcos to marcos'),(19,'Changed Last Name of bongbong marcos to marcos'),(20,'Changed Last Name of bongbong socram to marcos'),(21,'Changed First Name of bongbong socram to gnobgnob'),(22,'Changed Last Name of bongbong marcos to socram'),(23,'Changed Last Name of bongbong marcos to marcos'),(24,'Changed Last Name of bongbong socram to marcos'),(25,'Changed Last Name of bongbong socram to socram');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `residents_details`
--

DROP TABLE IF EXISTS `residents_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `residents_details` (
  `residents_id` int NOT NULL AUTO_INCREMENT,
  `last_name` varchar(50) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `suffix` varchar(250) NOT NULL,
  `sex` enum('Male','Female') DEFAULT NULL,
  `birthdate` date NOT NULL,
  `age` int NOT NULL,
  `civil_status` enum('Single','Married','Widowed','Separated') DEFAULT 'Single',
  `sitio` varchar(50) DEFAULT NULL,
  `occupation` varchar(30) NOT NULL,
  `contact_number` varchar(50) DEFAULT NULL,
  `email_address` varchar(50) DEFAULT NULL,
  `voter_status` enum('Registered','Not Registered') DEFAULT 'Not Registered',
  `no_household` varchar(50) NOT NULL,
  `senior` varchar(250) DEFAULT NULL,
  `conditions` varchar(250) DEFAULT NULL,
  `religion` varchar(250) DEFAULT NULL,
  `PWD` varchar(5) DEFAULT NULL,
  `blood_type` varchar(250) DEFAULT NULL,
  `residents_photo` longblob,
  `educational_attainment` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`residents_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residents_details`
--

LOCK TABLES `residents_details` WRITE;
/*!40000 ALTER TABLE `residents_details` DISABLE KEYS */;
INSERT INTO `residents_details` VALUES (1,'Limbaga','Clyde','Beloira','None','Male','2006-02-18',19,'Single','Proper','Student','09057705375','clydes0218@gmail.com','Registered','10','No','Alive','Roman Catholic','No','A',NULL,'Senior High School Level'),(2,'Limbaga','Maria Lourdes','Beloira','None','Female','2010-02-21',15,'Married','Proper','Student','09354625443','marialourdes4@gmail.com','Registered','10','No','Alive','Roman Catholic','No','A',NULL,'Senior High School Level'),(3,'Gay','Jaymark','Ambot','Sr.','Female','2001-12-09',23,'Married','Sto.Nino','Student','09123456789','jaymarkkeller@gmail.com','Registered','2','No','Alive','Roman Catholic','No','A',NULL,'Senior High School Level'),(4,'Mag-aso','Emmanuel','Limbaga','None','Male','2018-07-10',7,'Single','Proper','Student','09987654321','emmangay@gmail.com','Not Registered','5','No','Alive','Islam','No','A',NULL,'Senior High School Level'),(5,'Singco','Jayvince','Singco','None','Male','2006-09-30',19,'Single','Mangaco','Student','09978615243','jayvincesingco@gmail.com','Registered','4','No','Alive','Roman Catholic','No','A',NULL,'Senior High School Level'),(6,'World','Hello','None','None','Female','2000-01-01',25,'Separated','Gawahon','Unemployed','0913579246','helloworld@gmail.com','Not Registered','1','No','Deceased','Islam','Yes','A',NULL,'Senior High School Level'),(7,'Digal','Vince','None','None','Male','2000-01-01',25,'Married','Lumpan','Student','09930546145','vincedigal@gmail.com','Registered','5','No','Alive','Roman Catholic','No','A',NULL,'Senior High School Level'),(8,'Monkey','Luffy','D.','None','Male','2000-01-02',25,'Single','East Blue','Pirate','09213749272','monkeyluffy@gmail.com','Not Registered','3','No','Alive','Other','No','A',NULL,'Senior High School Level'),(9,'Resident','Senior','D.','None','Female','1962-10-08',62,'Widowed','Proper','Unemployed','09273829173','None','Registered','11','yes','Deceased','Islam','No','A',NULL,'Senior High School Level'),(10,'Sakazuki','None','Not D.','None','Female','2000-01-01',25,'Married','None','Marine Admiral','09998765432','None','Not Registered','2','No','Alive','Other','No','A',NULL,'Senior High School Level'),(11,'Apilyedo','Ngalan','Middle','V','Male','2001-09-11',63,'Single','Hello','Unemployed','09283913018','pop@gmail.com','Not Registered','11','yes','Deceased','','Yes','',NULL,'Senior High School Level'),(12,'Dela Cruz','Juan','Tamad','V','Male','1963-10-19',62,'Widowed','Gawahon','Retired','09320329329','juandelacruz@yahoo.com','Registered','10','yes','Alive','Roman Catholic','No','O+',NULL,'Senior High School Level'),(13,'last','firsts','Middle','Jr.','Male','2023-02-09',2,'Separated','rew','popop','21212121221','wwqwq','Not Registered','4','No','Alive','Islam','No','O-',NULL,'Elementary Graduate'),(14,'marcos','BongBong','None','Jr.','Male','1981-09-10',44,'Married','saas','assasa','21212','croco','Registered','5','No','Alive','Roman Catholic','Yes','AB',NULL,'Elementary Graduate');
/*!40000 ALTER TABLE `residents_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_login`
--

DROP TABLE IF EXISTS `user_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_login` (
  `username` varchar(250) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_login`
--

LOCK TABLES `user_login` WRITE;
/*!40000 ALTER TABLE `user_login` DISABLE KEYS */;
INSERT INTO `user_login` VALUES ('username','password123');
/*!40000 ALTER TABLE `user_login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-22  8:26:50
