DROP DATABASE  IF EXISTS `challenge_test`;
CREATE DATABASE  IF NOT EXISTS `challenge_test`
DROP DATABASE  IF EXISTS `challenge`;
CREATE DATABASE  IF NOT EXISTS `challenge` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `challenge`;

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

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
                           `balance` double DEFAULT NULL,
                           `id_account` int NOT NULL,
                           `number` int DEFAULT NULL,
                           `client_id` varchar(255) DEFAULT NULL,
                           `state` varchar(255) DEFAULT NULL,
                           `type` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id_account`),
                           KEY `FKkm8yb63h4ownvnlrbwnadntyn` (`client_id`),
                           CONSTRAINT `FKkm8yb63h4ownvnlrbwnadntyn` FOREIGN KEY (`client_id`) REFERENCES `client` (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_seq`
--

DROP TABLE IF EXISTS `account_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_seq` (
                               `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_seq`
--

LOCK TABLES `account_seq` WRITE;
/*!40000 ALTER TABLE `account_seq` DISABLE KEYS */;
INSERT INTO `account_seq` VALUES (1);
/*!40000 ALTER TABLE `account_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
                          `age` int NOT NULL,
                          `address` varchar(255) DEFAULT NULL,
                          `gender` varchar(255) DEFAULT NULL,
                          `id_client` varchar(255) NOT NULL,
                          `identification` varchar(255) DEFAULT NULL,
                          `name` varchar(255) DEFAULT NULL,
                          `password` varchar(255) DEFAULT NULL,
                          `phone` varchar(255) DEFAULT NULL,
                          `state` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
                               `account_id` int DEFAULT NULL,
                               `balance` double DEFAULT NULL,
                               `id_account` int NOT NULL,
                               `worth` double DEFAULT NULL,
                               `moven_date` datetime(6) DEFAULT NULL,
                               `type` varchar(255) DEFAULT NULL,
                               PRIMARY KEY (`id_account`),
                               KEY `FK6g20fcr3bhr6bihgy24rq1r1b` (`account_id`),
                               CONSTRAINT `FK6g20fcr3bhr6bihgy24rq1r1b` FOREIGN KEY (`account_id`) REFERENCES `account` (`id_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_seq`
--

DROP TABLE IF EXISTS `transaction_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_seq` (
                                   `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_seq`
--

LOCK TABLES `transaction_seq` WRITE;
/*!40000 ALTER TABLE `transaction_seq` DISABLE KEYS */;
INSERT INTO `transaction_seq` VALUES (1);
/*!40000 ALTER TABLE `transaction_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-15  8:59:00
