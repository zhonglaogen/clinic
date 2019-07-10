-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: clinic
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.16.04.1

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `a_password` varchar(150) DEFAULT NULL,
  `a_name` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `a_gender` char(2) CHARACTER SET utf8 DEFAULT NULL,
  `a_brithdate` date DEFAULT NULL,
  `a_phone` char(11) DEFAULT NULL,
  `a_work_name` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `a_img` varchar(150) DEFAULT NULL,
  `a_grade` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='系统管理员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'zlx','张导诊','男',NULL,'15047627020','前台导诊',NULL,1),(2,'lzx','李药房','女',NULL,'13207544303','药房管理员',NULL,2),(3,'lxz','孙科室','男',NULL,'15047627021','科室管理员',NULL,3),(4,'xlz','admin','男',NULL,'15047627022','诊所管理员',NULL,4);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT,
  `d_password` varchar(150) DEFAULT NULL,
  `d_name` varchar(10) CHARACTER SET utf8 NOT NULL,
  `d_gender` char(2) CHARACTER SET utf8 DEFAULT NULL,
  `d_birthdate` date DEFAULT NULL,
  `d_phone` char(11) NOT NULL,
  `d_work_name` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `d_range` tinyint(4) DEFAULT '0',
  `d_img` varchar(150) DEFAULT NULL,
  `r_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`d_id`),
  UNIQUE KEY `doctor_d_phone_uindex` (`d_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='医生表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'lidoc','李医生','男','1990-07-09','13207544303','员工',0,NULL,1),(2,'zhangdoc','张医生','女','1995-07-06','15047627022','员工',0,NULL,1),(3,'huangdoc','黄医生','女','1986-03-15','13207544956','员工',0,NULL,2);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_out_treate`
--

DROP TABLE IF EXISTS `item_out_treate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_out_treate` (
  `i_id` int(11) NOT NULL AUTO_INCREMENT,
  `d_id` int(11) DEFAULT NULL,
  `d_count` int(11) DEFAULT NULL,
  `d_all_count` int(11) DEFAULT NULL,
  `o_id` int(11) DEFAULT NULL,
  `i_date` date DEFAULT NULL,
  `i_up_down` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`i_id`),
  UNIQUE KEY `item_out_treate_i_id_uindex` (`i_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 COMMENT='出诊信息项';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_out_treate`
--

LOCK TABLES `item_out_treate` WRITE;
/*!40000 ALTER TABLE `item_out_treate` DISABLE KEYS */;
INSERT INTO `item_out_treate` VALUES (1,1,1,20,NULL,'2019-07-18','上午'),(2,3,0,20,NULL,'2019-06-30','下午'),(3,1,15,20,NULL,'2019-07-04','上午'),(4,2,7,20,NULL,'2019-07-05','下午'),(5,3,11,20,NULL,'2019-07-16','上午'),(6,1,21,11,NULL,'2019-07-12','下午'),(7,1,1,20,NULL,'2019-07-09','下午');
/*!40000 ALTER TABLE `item_out_treate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medic_apply`
--

DROP TABLE IF EXISTS `medic_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medic_apply` (
  `ma_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_id` int(11) DEFAULT NULL,
  `ma_count` int(11) DEFAULT NULL,
  `a_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ma_id`),
  UNIQUE KEY `medic_apply_ma_id_uindex` (`ma_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='药物申请表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medic_apply`
--

LOCK TABLES `medic_apply` WRITE;
/*!40000 ALTER TABLE `medic_apply` DISABLE KEYS */;
INSERT INTO `medic_apply` VALUES (1,1,50,5);
/*!40000 ALTER TABLE `medic_apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medic_order`
--

DROP TABLE IF EXISTS `medic_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medic_order` (
  `mo_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_id` int(11) DEFAULT NULL,
  `m_count` int(11) DEFAULT NULL,
  `t_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`mo_id`),
  UNIQUE KEY `medic_order_mo_id_uindex` (`mo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='药品订单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medic_order`
--

LOCK TABLES `medic_order` WRITE;
/*!40000 ALTER TABLE `medic_order` DISABLE KEYS */;
INSERT INTO `medic_order` VALUES (1,1,1,1);
/*!40000 ALTER TABLE `medic_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicine` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `m_count` int(11) NOT NULL DEFAULT '0',
  `m_price` int(11) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COMMENT='药物表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (1,'黄连上清丸',74,15),(4,'止泻宁',15,12),(5,'碘酒',55,23),(6,'花露水',48,40);
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `out_treate`
--

DROP TABLE IF EXISTS `out_treate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `out_treate` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_id` int(11) DEFAULT NULL,
  `o_date` date DEFAULT NULL,
  `o_time` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`o_id`),
  UNIQUE KEY `out_treate_o_id_uindex` (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='出诊信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `out_treate`
--

LOCK TABLES `out_treate` WRITE;
/*!40000 ALTER TABLE `out_treate` DISABLE KEYS */;
/*!40000 ALTER TABLE `out_treate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_password` varchar(150) DEFAULT NULL,
  `p_name` varchar(10) CHARACTER SET utf8 NOT NULL,
  `p_gender` varchar(2) CHARACTER SET utf8 DEFAULT NULL,
  `p_birthdate` date DEFAULT NULL,
  `p_phone` char(11) NOT NULL,
  `p_email` varchar(30) DEFAULT NULL,
  `p_idcard` char(18) DEFAULT NULL,
  PRIMARY KEY (`p_id`),
  UNIQUE KEY `patient_phone_uindex` (`p_phone`),
  UNIQUE KEY `patient_p_id_uindex` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'zlx','钟连喜','男',NULL,'15047627020','479230207@qq.com','150403199810220510'),(2,'ym','杨沐','男',NULL,'12345678911',NULL,'150403199810220512'),(3,'zzj','朱智杰','男',NULL,'12345678922',NULL,'150403199810220513');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_order`
--

DROP TABLE IF EXISTS `patient_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_order` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_id` int(11) DEFAULT NULL,
  `i_id` int(11) DEFAULT NULL,
  `o_date` date DEFAULT NULL,
  `o_go` tinyint(1) NOT NULL DEFAULT '1',
  `t_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`o_id`),
  UNIQUE KEY `order_o_id_uindex` (`o_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1 COMMENT='预约成功表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_order`
--

LOCK TABLES `patient_order` WRITE;
/*!40000 ALTER TABLE `patient_order` DISABLE KEYS */;
INSERT INTO `patient_order` VALUES (28,1,3,'2019-07-03',1,NULL),(33,1,1,'2019-07-05',1,38),(37,2,5,'2019-07-08',0,NULL),(38,2,7,'2019-07-08',1,43),(41,1,6,'2019-07-09',0,NULL),(42,1,7,'2019-07-09',1,44);
/*!40000 ALTER TABLE `patient_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_name` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `a_id` int(11) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`r_id`),
  UNIQUE KEY `room_r_id_uindex` (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='科室表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'外科',1,3),(2,'内科',NULL,NULL),(3,'儿科',NULL,NULL),(4,'口腔科',NULL,NULL);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treat`
--

DROP TABLE IF EXISTS `treat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `treat` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_id` int(11) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  `t_result` varchar(50) DEFAULT NULL,
  `t_type` tinyint(4) DEFAULT NULL,
  `t_bed` tinyint(1) DEFAULT NULL,
  `t_date` date DEFAULT NULL,
  `t_total_price` int(11) DEFAULT NULL,
  `t_pay` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1 COMMENT='挂号单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treat`
--

LOCK TABLES `treat` WRITE;
/*!40000 ALTER TABLE `treat` DISABLE KEYS */;
INSERT INTO `treat` VALUES (41,2,1,NULL,NULL,NULL,NULL,NULL,0),(42,2,1,'4444545',1,NULL,'2019-07-08',NULL,0),(43,2,1,NULL,NULL,NULL,NULL,NULL,0),(44,1,1,NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `treat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-10 15:51:00
