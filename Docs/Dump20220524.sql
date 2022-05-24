CREATE DATABASE  IF NOT EXISTS `JMBtravels` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `JMBtravels`;
-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: fsd03-project-ii.cbtniy7jzwps.us-east-1.rds.amazonaws.com    Database: JMBtravels
-- ------------------------------------------------------
-- Server version	8.0.28

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `bookingcars`
--

DROP TABLE IF EXISTS `bookingcars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookingcars` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `arrival` date NOT NULL,
  `car` varchar(255) DEFAULT NULL,
  `departure` date NOT NULL,
  `email` varchar(20) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `hotel` varchar(255) DEFAULT NULL,
  `last_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookingcars`
--

LOCK TABLES `bookingcars` WRITE;
/*!40000 ALTER TABLE `bookingcars` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookingcars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(20) NOT NULL,
  `image` varchar(200) DEFAULT NULL,
  `make` varchar(20) NOT NULL,
  `model` varchar(20) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotels`
--

DROP TABLE IF EXISTS `hotels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotels` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `beds` varchar(20) NOT NULL,
  `city` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `hotel` varchar(20) NOT NULL,
  `image` varchar(200) DEFAULT NULL,
  `price` double NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotels`
--

LOCK TABLES `hotels` WRITE;
/*!40000 ALTER TABLE `hotels` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_bookings`
--

DROP TABLE IF EXISTS `room_bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_bookings` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `city` varchar(200) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `final_price` double DEFAULT NULL,
  `hotel` varchar(20) NOT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `room_id` bigint DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `type` varchar(20) NOT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_bookings`
--

LOCK TABLES `room_bookings` WRITE;
/*!40000 ALTER TABLE `room_bookings` DISABLE KEYS */;
INSERT INTO `room_bookings` VALUES (1,'Cancun','2022-05-30',720,'Hilton','Pending',1,3,'2022-05-26','Junior suite',2),(2,'Montreal','2022-05-29',699.98,'Mariott','Pending',2,4,'2022-05-27','Executive Suite',3),(3,'Cancun','2022-06-11',2200,'Iberostar ','Pending',1,5,'2022-06-01','Suite',2),(4,'Cancun','2022-05-28',660,'Iberostar ','Pending',1,5,'2022-05-25','Suite',2),(5,'Paris','2022-06-04',779.97,'Accor','Pending',3,10,'2022-06-01','Luxury',3),(6,'Cancun','2022-06-25',1150,'Occidental cozumel ','Pending',1,1,'2022-06-20','Junior suite',3),(7,'Cancun','2022-05-31',880,'Iberostar ','Pending',2,5,'2022-05-27','Suite',2);
/*!40000 ALTER TABLE `room_bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `beds` varchar(20) NOT NULL,
  `city` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `hotel` varchar(20) NOT NULL,
  `image` varchar(200) DEFAULT NULL,
  `is_booked` bit(1) NOT NULL,
  `price` double NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (1,'2 Double','Cancun','All inclusive','Occidental cozumel ',NULL,_binary '\0',230,'Junior suite'),(2,'King','Cancun','Ocean view','Hilton',NULL,_binary '\0',140,'Suite'),(3,'2 Double','Cancun','Ocean view','Hilton',NULL,_binary '\0',180,'Junior suite'),(4,'2 Queen','Montreal','','Mariott',NULL,_binary '\0',349.99,'Executive Suite'),(5,'2 Double','Cancun','All inclusive, Royal level, Ocean view','Iberostar ',NULL,_binary '\0',220,'Suite'),(6,'King','Montreal','City center','Hilton',NULL,_binary '\0',110,'Suite'),(7,'1 King, 1 Queen','Montreal','','Opus',NULL,_binary '\0',369.99,'Suite'),(8,'Queen + Double','Toronto','','Hilton',NULL,_binary '\0',289.99,'Junior Suite'),(9,'Queen','Toronto','','Four Seasons',NULL,_binary '\0',229.99,'Business Class'),(10,'King','Paris','','Accor',NULL,_binary '\0',259.99,'Luxury');
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'fsd03@gmail.com',_binary '','Group','Project','$2a$10$.FDsdDprlkKBfxD6dRXNk.jrg2gH6rYgix8nAcZ/SSZJMFVcEqj5C','ADMIN'),(2,'bog777@ukr.net',_binary '','Bogdan','Pristinskyi','$2a$10$DuEqtkWb8smyRNNLxz03YeA9PUW0RT13mU2VF7gx6fLDMHXi8OHh6','ADMIN'),(3,'test1@gmail.com',_binary '','Testy','Testerson','$2a$10$c/J9.tLZVgjQlzvuj3itG.ZHPj2saGg3NK3ARts.c6NrrQJ.iH3du','USER');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-24  9:01:54
