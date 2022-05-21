CREATE DATABASE  IF NOT EXISTS `JMBtravels` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `JMBtravels`;
-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: rds-elder-devcourse.cyyi00annpeo.us-east-2.rds.amazonaws.com    Database: JMBtravels
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (1,'Economy','https://elder-aws-s3-2.s3.amazonaws.com/images/car-economy.png','Toyota','Prius',29.95),(2,'Luxury','https://elder-aws-s3-2.s3.amazonaws.com/images/car-luxury.png','Mercedes','E-Class',149.95),(3,'Midsize','https://elder-aws-s3-2.s3.amazonaws.com/images/car-midsize.png','Acura','TL',59.99),(4,'SUV','https://elder-aws-s3-2.s3.amazonaws.com/images/car-suv.png','Toyota','Land Cruiser',79.99);
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
  `hotel` varchar(20) NOT NULL,
  `image` varchar(200) DEFAULT NULL,
  `price` double NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotels`
--

LOCK TABLES `hotels` WRITE;
/*!40000 ALTER TABLE `hotels` DISABLE KEYS */;
INSERT INTO `hotels` VALUES (1,'King','Elder Arms','https://elder-aws-s3-2.s3.amazonaws.com/images/room+-+luxury+-+king.jpg',329.95,'Luxury Suite'),(3,'King','Syed Motel','https://elder-aws-s3-2.s3.amazonaws.com/images/room+-+luxury+-+king.jpg',259.99,'Luxury'),(4,'Queen','Elder Arms','https://elder-aws-s3-2.s3.amazonaws.com/images/room+-+comfort+-+queen.jpg',269.99,'Comfort'),(6,'Queen','Syed Motel','https://elder-aws-s3-2.s3.amazonaws.com/images/room+-+comfort+-+queen.jpg',189.99,'Comfort'),(7,'Queen + Double','Elder Arms','https://elder-aws-s3-2.s3.amazonaws.com/images/room+-+budget+-+two+queens.jpg',189.99,'Budget'),(8,'Double Queens','Pristinsky Suites','https://elder-aws-s3-2.s3.amazonaws.com/images/room+-+budget+-+two+queens.jpg',229.99,'Budget'),(9,'Two Doubles','Syed Motel','https://elder-aws-s3-2.s3.amazonaws.com/images/room+-+budget+-+two+queens.jpg',149.99,'Budget'),(10,'King','Pristinsky Suites','https://elder-aws-s3-2.s3.amazonaws.com/images/room+-+luxury+-+king.jpg',349.99,'Luxury');
/*!40000 ALTER TABLE `hotels` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'fsd03@gmail.com',_binary '','Group','Project','$2a$10$OFMgFNWAoanq1KF37JzFI.zuBcZ70dG6q7Lw5wjOrzYbp6Y1anO/6','ADMIN'),(2,'bog777@ukr.net',_binary '','Bogdan','Pristinskyi','$2a$10$Wzsy83N0Zi1iwC61LjTNYeVZNWRet8E14b1/ARhugfG7AKbDMuPau','ADMIN'),(3,'Mobin.Syed994@gmail.com',_binary '','Mobin','Syed','$2a$10$wJzw8V3FECGS71OjMShdrOaVgVMi6mFP2MaHV03Qe5VByR0JewiUS','ADMIN'),(4,'test@gmail.com',_binary '','Testy','Testerson','$2a$10$bkvovEDte.044cg5nJ8TOeft82moQsVQrXlA2WkpaRU0e.eazbhwS','USER'),(5,'jg@gmail.com',_binary '','Jay','Gatsby','$2a$10$mnC0JIeRt4692P13gONxHe/s6nQ1jLAp0wl7TeoRHWN92fDW1DOEO','USER'),(6,'db@gmail.com',_binary '','Daisy','Buchanan','$2a$10$jBFe5vB9IvcuwUvG0CdLj.bSmaB4AIoMEVMqr74L8Chn5m3PeMfea','USER'),(7,'nc@gmail.com',_binary '','Nick','Carraway','$2a$10$m1FW.oZnTnXBWDU3IeMg2.eqCyXdqZkb3zsrCshoxSOZGwnAhan2i','USER'),(8,'jb@gmail.com',_binary '','Jordan','Baker','$2a$10$W00lM8ERGZrNaEaFkEscy.bS660.8LvlnDosDsXa/TGjdF6003afG','USER');
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

-- Dump completed on 2022-05-20 10:40:38
