/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.26-log : Database - oa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`oa` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `oa`;

/*Table structure for table `claim_voucher` */

DROP TABLE IF EXISTS `claim_voucher`;

CREATE TABLE `claim_voucher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cause` varchar(100) DEFAULT NULL,
  `create_sn` char(5) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `next_deal_sn` char(5) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_2` (`next_deal_sn`),
  KEY `FK_Reference_3` (`create_sn`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`next_deal_sn`) REFERENCES `employee` (`sn`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`create_sn`) REFERENCES `employee` (`sn`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `claim_voucher` */

insert  into `claim_voucher`(`id`,`cause`,`create_sn`,`create_time`,`next_deal_sn`,`total_amount`,`status`) values (1,'应酬','10001','2020-02-24 15:20:50','10004',1000,'已提交'),(3,'公司聚会','10001','2020-02-25 13:31:58','10003',6099.99,'新创建'),(4,'外地出差','10008','2020-02-25 17:16:31',NULL,3600,'已打款'),(5,'请客户吃饭','10008','2020-02-25 21:08:24','10008',5550,'已打回'),(6,'公费旅游','10008','2020-02-25 23:38:41',NULL,4533,'已终止'),(7,'外国出差','10001','2020-02-25 23:43:24',NULL,68550,'已打款');

/*Table structure for table `claim_voucher_item` */

DROP TABLE IF EXISTS `claim_voucher_item`;

CREATE TABLE `claim_voucher_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `claim_voucher_id` int(11) DEFAULT NULL,
  `item` varchar(20) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `comment` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_4` (`claim_voucher_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`claim_voucher_id`) REFERENCES `claim_voucher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `claim_voucher_item` */

insert  into `claim_voucher_item`(`id`,`claim_voucher_id`,`item`,`amount`,`comment`) values (1,4,'住宿',3000,'五星级大酒店'),(2,4,'交通',600,'坐出租车'),(3,5,'餐饮',6000,'吃大餐'),(4,6,'住宿',4533,'跟团'),(5,7,'交通',4000,'坐船'),(6,7,'餐饮',4544,'国际大酒店'),(7,7,'住宿',60006,'总统套房');

/*Table structure for table `deal_record` */

DROP TABLE IF EXISTS `deal_record`;

CREATE TABLE `deal_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `claim_voucher_id` int(11) DEFAULT NULL,
  `deal_sn` char(5) DEFAULT NULL,
  `deal_time` datetime DEFAULT NULL,
  `deal_way` varchar(20) DEFAULT NULL,
  `deal_result` varchar(20) DEFAULT NULL,
  `comment` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_5` (`claim_voucher_id`),
  KEY `FK_Reference_6` (`deal_sn`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`claim_voucher_id`) REFERENCES `claim_voucher` (`id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`deal_sn`) REFERENCES `employee` (`sn`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `deal_record` */

insert  into `deal_record`(`id`,`claim_voucher_id`,`deal_sn`,`deal_time`,`deal_way`,`deal_result`,`comment`) values (1,5,'10008','2020-02-25 23:05:19','提交','已提交','无'),(2,4,'10008','2020-02-25 23:05:37','提交','已提交','无'),(3,4,'10003','2020-02-25 23:36:45','通过','已审核',''),(4,5,'10003','2020-02-25 23:37:16','打回','已打回',''),(5,6,'10008','2020-02-25 23:39:21','提交','已提交','无'),(6,6,'10003','2020-02-25 23:39:48','拒绝','已终止',''),(7,7,'10001','2020-02-25 23:45:33','提交','已提交','无'),(8,7,'10004','2020-02-25 23:45:56','通过','待复审',''),(9,7,'10004','2020-02-25 23:45:56','通过','待复审',''),(10,7,'10001','2020-02-25 23:46:18','通过','已审核',''),(11,1,'10001','2020-02-25 23:49:46','提交','已提交','无'),(12,7,'10002','2020-02-25 23:50:16','打款','已打款',''),(13,4,'10002','2020-02-25 23:50:24','打款','已打款','');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `sn` char(5) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`sn`,`name`,`address`) values ('10001','行政部','星星大厦E座1201'),('10002','财务部','星星大厦E座1202'),('10003','事业部','星星大厦E座1203'),('10004','人事部','广东广州'),('10005','开发部','广东深圳');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `sn` char(5) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `department_sn` char(5) DEFAULT NULL,
  `post` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sn`),
  KEY `FK_Reference_1` (`department_sn`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`department_sn`) REFERENCES `department` (`sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`sn`,`password`,`name`,`department_sn`,`post`) values ('10001','111111','刘备','10001','总经理'),('10002','000000','孙尚香','10002','财务'),('10003','000000','关羽','10003','部门经理'),('10004','000000','周仓','10001','部门经理'),('10007','000000','不三不四','10005','员工'),('10008','000000','夫子','10003','财务');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
