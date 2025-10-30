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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blotter`
--

LOCK TABLES `blotter` WRITE;
/*!40000 ALTER TABLE `blotter` DISABLE KEYS */;
INSERT INTO `blotter` VALUES (1,'Clyde','Beloira','Limbaga',19,'Poblacion Dos, Malabuyoc, Cebu','Jaymark','None','Pimentel',19,'Sto. Nino, Malabuyoc, Cebu','Hit and Run','Arrested','Ginatilan, Cebu','2025-10-26','Resolved','Kagawad Juan Dela Cruz'),(2,'Clyde','b.','Limbaga',19,'Poblacion Dos','Nicole','None','Benlot',19,'Sliring','Stole a phonr','Custody','Ginatilan','2025-10-28','Resolved','Kap Jaymark');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificates`
--

LOCK TABLES `certificates` WRITE;
/*!40000 ALTER TABLE `certificates` DISABLE KEYS */;
INSERT INTO `certificates` VALUES (1,'2025-10-26','Business Clearance','Lemon Shop','Clyde B. Limbaga',19,'Proper'),(2,'2025-10-28','Business Clearance','Lemon Stand','Clyde B. Limbaga',19,'Proper'),(3,'2025-10-28','Residency','Resident','Clyde B. Limbaga',19,'Proper');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,'Added Limbaga Clyde Beloira in Residents'),(2,'Added A New Blotter for Jaymark Pimentel'),(3,'Added A New Blotter for Nicole Benlot'),(4,'Made a Business Clearance  for Clyde B. Limbaga'),(5,'Made a Certificate of Residency for Clyde B. Limbaga');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residents_details`
--

LOCK TABLES `residents_details` WRITE;
/*!40000 ALTER TABLE `residents_details` DISABLE KEYS */;
INSERT INTO `residents_details` VALUES (1,'Limbaga','Clyde','Beloira','None','Male','2006-02-18',19,'Single','Proper','Student','09208757608','clydes0218@gmail.com','Registered','5','No','Alive','Roman Catholic','No','O',NULL,'College Level');
/*!40000 ALTER TABLE `residents_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_login`
--

DROP TABLE IF EXISTS `user_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_login` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `gmail_account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `gmail` CHECK ((`gmail_account` like _utf8mb4'%@gmail.com'))
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_login`
--

LOCK TABLES `user_login` WRITE;
/*!40000 ALTER TABLE `user_login` DISABLE KEYS */;
INSERT INTO `user_login` VALUES (1,'username@gmail.com','ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f');
/*!40000 ALTER TABLE `user_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-30 21:53:55
