-- MySQL dump 10.13  Distrib 5.7.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: prizy
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `BarCode` int(11) NOT NULL,
  `Discription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `BarCode` (`BarCode`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` (`id`, `BarCode`, `Discription`) VALUES (1,1111,'Coffee'),(2,2222,'Oil'),(3,3333,'Pastas'),(4,4444,'Tea'),(5,5555,'Chocolates'),(6,6666,'Milk');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productsloader`
--

DROP TABLE IF EXISTS `productsloader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productsloader` (
  `reqid` int(11) NOT NULL AUTO_INCREMENT,
  `Store` varchar(10) DEFAULT NULL,
  `BarCode` int(11) NOT NULL,
  `price` double NOT NULL,
  `Notes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`reqid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productsloader`
--

LOCK TABLES `productsloader` WRITE;
/*!40000 ALTER TABLE `productsloader` DISABLE KEYS */;
INSERT INTO `productsloader` (`reqid`, `Store`, `BarCode`, `price`, `Notes`) VALUES (1,'Store1',2222,20,'Tea'),(2,'Store1',3333,20,'Tea'),(3,'Store1',1111,20,'Tea'),(4,'Store1',4444,20,'Tea'),(5,'Store1',5555,20,'Tea'),(6,'Store1',6666,20,'Tea'),(7,'Store2',6666,20,'Tea'),(8,'Store2',5555,22,'Tea'),(9,'Store3',4444,23,'Tea'),(10,'Store2',4444,25,'Tea'),(11,'Store2',3333,25.5,'Tea'),(12,'Store3',6666,25,'Tea'),(13,'Store4',6666,30,'Tea'),(14,'Store5',6666,28,'Tea'),(15,'Store6',6666,35,'Tea');
/*!40000 ALTER TABLE `productsloader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `store` (
  `Store` varchar(10) NOT NULL,
  `BarCode` int(11) NOT NULL,
  `Discription` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` (`Store`, `BarCode`, `Discription`) VALUES ('Store1',1111,'Coffee'),('Store1',2222,'Oil'),('Store1',3333,'Pastas'),('Store1',4444,'Tea'),('Store1',5555,'Chocolates'),('Store1',6666,'Milk'),('Store2',1111,'Coffee'),('Store2',2222,'Oil'),('Store2',3333,'Pastas'),('Store2',4444,'Tea'),('Store2',5555,'Chocolates'),('Store2',6666,'Milk'),('Store4',1111,'Coffee'),('Store4',2222,'Oil'),('Store4',3333,'Pastas'),('Store4',4444,'Tea'),('Store4',5555,'Chocolates'),('Store4',6666,'Milk'),('Store5',1111,'Coffee'),('Store5',2222,'Oil'),('Store5',3333,'Pastas'),('Store5',4444,'Tea'),('Store5',5555,'Chocolates'),('Store5',6666,'Milk'),('Store6',1111,'Coffee'),('Store6',2222,'Oil'),('Store6',3333,'Pastas'),('Store6',4444,'Tea'),('Store6',5555,'Chocolates'),('Store6',6666,'Milk');
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-17 19:03:18
