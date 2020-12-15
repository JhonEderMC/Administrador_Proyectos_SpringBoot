-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: proyectos
-- ------------------------------------------------------
-- Server version	5.5.5-10.5.8-MariaDB

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
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `area` varchar(250) DEFAULT NULL,
  `budget` int(11) NOT NULL,
  `manager` varchar(100) NOT NULL,
  `time` int(11) NOT NULL,
  `create` date NOT NULL DEFAULT curtime(),
  `start` date NOT NULL,
  `end` date NOT NULL,
  `state` varchar(100) NOT NULL,
  `user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `project_FK` (`user`),
  CONSTRAINT `project_FK` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'Desarrolladores front end','Recursos humanos',10000,'Tatania Mejia',1,'2020-05-13','2020-01-22','2020-01-29','Finalizado',1),
(2,'Diseño Interfaz','Diseño',25000,'David',200,'2020-05-13','2020-01-15','2020-01-03','En proceso',2),
(3,'Busqueda desarrollador Java','Talento humano',1000,'Luisa',1000,'2020-12-13','2020-01-15','2021-03-17','En proceso',2),
(4,'relleno1','relleno3',100,'relleno1',1000,'2020-12-13','2020-01-10','2020-01-08','Creado',1),
(5,'Programador web','desarrollo',2000,'Luisa',300,'2020-10-13','2020-01-06','2021-01-18','En proceso',1),
(6,'programador fron end web','front desarollo',200,'David',30,'2020-12-13','2020-01-14','2021-01-10','En proceso',3),
(7,'Director de marquetin','Ventas',1000,'Daniela',1000,'2020-02-13','2020-11-02','2021-02-17','Cancelado',2),
(8,'Comunicador Social','Recursos humanos',1001,'Sergio ',10,'2020-10-14','2020-11-18','2020-12-09','Finalizado',2),
(9,'prueba1','prueba',100,'deadad',100,'2020-12-14','2020-12-03','2020-12-09','Suspendido',5),
(10,'prueba','dadaad',100,'adaddadda',20,'2020-12-14','2020-12-02','2020-12-29','Cancelado',6),
(11,'Relleno','dadaad',100,'adaddadda',20,'2020-12-14','2020-12-02','2020-12-29','Cancelado',4);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectdelete`
--

DROP TABLE IF EXISTS `projectdelete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectdelete` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `userdelete` int(11) DEFAULT NULL,
  `dateDelete` date DEFAULT curtime(),
  PRIMARY KEY (`id`),
  KEY `ProjectDelete_FK` (`project`),
  KEY `ProjectDelete_FK_1` (`user`),
  CONSTRAINT `ProjectDelete_FK` FOREIGN KEY (`project`) REFERENCES `project` (`id`),
  CONSTRAINT `ProjectDelete_FK_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectdelete`
--

LOCK TABLES `projectdelete` WRITE;
/*!40000 ALTER TABLE `projectdelete` DISABLE KEYS */;
INSERT INTO `projectdelete` VALUES (1,14,1,1,'2020-12-14');
/*!40000 ALTER TABLE `projectdelete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectupdate`
--

DROP TABLE IF EXISTS `projectupdate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectupdate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project` int(11) NOT NULL,
  `user` int(11) NOT NULL,
  `usermodifico` int(11) DEFAULT NULL,
  `dateUpdate` date DEFAULT curtime(),
  PRIMARY KEY (`id`),
  KEY `ProjectUpdate_FK` (`project`),
  KEY `ProjectUpdate_FK_1` (`user`),
  CONSTRAINT `ProjectUpdate_FK` FOREIGN KEY (`project`) REFERENCES `project` (`id`),
  CONSTRAINT `ProjectUpdate_FK_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectupdate`
--

LOCK TABLES `projectupdate` WRITE;
/*!40000 ALTER TABLE `projectupdate` DISABLE KEYS */;
INSERT INTO `projectupdate` VALUES (1,14,1,1,'2020-12-14');
/*!40000 ALTER TABLE `projectupdate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usenarme_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user','user123','Activo'),
(2,'admin','admin','Activo'),(3,'test','test123','Inactivo'),
(4,'prueba','prueba123','Inactivo'), (5,'pepe','pepe','Inactivo'),
(6,'Julia','julia123','Activo');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'proyectos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-14 21:06:27
