/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 8.0.18 : Database - crm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crm` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `crm`;

/*Table structure for table `aftersale` */

DROP TABLE IF EXISTS `aftersale`;

CREATE TABLE `aftersale` (
  `aid` int(200) NOT NULL AUTO_INCREMENT,
  `theme` varchar(200) NOT NULL,
  `clientid` int(200) NOT NULL,
  `contractid` int(200) DEFAULT NULL,
  `maincontent` varchar(500) DEFAULT NULL,
  `Contactperson` varchar(200) DEFAULT NULL,
  `fixedtelephones` varchar(200) DEFAULT NULL,
  `mobiletelephones` varchar(200) DEFAULT NULL,
  `post` varchar(200) DEFAULT NULL,
  `typeservice` int(200) DEFAULT NULL,
  `modelservice` int(200) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `feedback` varchar(500) DEFAULT NULL,
  `personnel` varchar(500) DEFAULT NULL,
  `Servicescore` varchar(30) DEFAULT NULL,
  `attachment` varchar(500) DEFAULT NULL,
  `status` int(200) DEFAULT '0',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `aftersale` */

insert  into `aftersale`(`aid`,`theme`,`clientid`,`contractid`,`maincontent`,`Contactperson`,`fixedtelephones`,`mobiletelephones`,`post`,`typeservice`,`modelservice`,`starttime`,`endtime`,`content`,`feedback`,`personnel`,`Servicescore`,`attachment`,`status`) values 
(9,'汽车维修_0102',2,3,'【合同全称】江苏移动总公司-系统对接融合方案   【合同所属部门】编辑部    【关联人员】刘洋,\n【签约日期】2018-04-18    【生效日期】2018-04-29    【合同状态】执行中    【服务期至】2019-03-06','任经理','15612231224','15612231224','15612231224',4,21,'2019-12-02 00:00:00','2019-12-28 00:00:00','【合同全称】江苏移动总公司-系统对接融合方案   【合同所属部门】编辑部    【关联人员】刘洋,\n【签约日期】2018-04-18    【生效日期】2018-','【合同全称】江苏移动总公司-系统对接融合方案   【合同所属部门】编辑部    【关联人员】刘洋,\n【签约日期】2018-04-18    【生效日期】2018-','张三','3','215809-15764182898a9c.jpg',0),
(10,'aaaaaavvv',2,4,'【合同全称】2222   【合同所属部门】1    【关联人员】,\n【签约日期】2019-12-20    【生效日期】2019-12-28    【合同状态】执行中    【服务期至】2019-12-25','2019-12-20 ','2019-12-20 ','2019-12-20 ','2019-12-20 ',4,21,'2019-12-02 00:00:00','2019-12-19 00:00:00','2019-12-20 ','2019-12-20 ','啊啊啊','2','QQ图片20191219095046.png',0),
(11,'阿萨大大飒飒的飒飒',2,3,'【合同全称】江苏移动总公司-系统对接融合方案   【合同所属部门】编辑部    【关联人员】刘洋,\n【签约日期】2018-04-18    【生效日期】2018-04-29    【合同状态】执行中    【服务期至】2019-03-06','阿萨大大飒飒的飒飒','阿萨大大飒飒的飒飒','阿萨大大飒飒的飒飒','阿萨大大飒飒的飒飒',16,21,'2019-12-02 00:00:00','2019-12-02 00:00:00','阿萨大大飒飒的飒飒','阿萨大大飒飒的飒飒','阿萨大大飒飒的飒飒','3','QQ图片20191219095046.png',0);

/*Table structure for table `client` */

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `cid` int(200) NOT NULL AUTO_INCREMENT,
  `customername` varchar(200) DEFAULT NULL,
  `spell` varchar(200) DEFAULT NULL,
  `type` int(200) DEFAULT NULL,
  `source` varchar(200) DEFAULT NULL,
  `industry` varchar(200) DEFAULT NULL,
  `Customersite` varchar(200) DEFAULT NULL,
  `state` varchar(200) DEFAULT NULL,
  `city` varchar(200) DEFAULT NULL,
  `detailedaddress` varchar(200) DEFAULT NULL,
  `PostCode` varchar(200) DEFAULT NULL,
  `fax` varchar(200) DEFAULT NULL,
  `contact` int(200) DEFAULT NULL,
  `department` varchar(200) DEFAULT NULL,
  `duty` varchar(200) DEFAULT NULL,
  `officephones` int(200) DEFAULT NULL,
  `mobiletelephones` int(200) DEFAULT NULL,
  `post` varchar(50) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  `registeredcapital` varchar(200) DEFAULT NULL,
  `stated` varchar(500) DEFAULT NULL,
  `bankaccount` int(20) DEFAULT NULL,
  `Account` varchar(200) DEFAULT NULL,
  `depositbank` varchar(200) DEFAULT NULL,
  `bankaddress` varchar(200) DEFAULT NULL,
  `taxnumber` varchar(200) DEFAULT NULL,
  `bankiphone` varchar(200) DEFAULT NULL,
  `nid` int(11) DEFAULT NULL,
  `classif` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `client` */

insert  into `client`(`cid`,`customername`,`spell`,`type`,`source`,`industry`,`Customersite`,`state`,`city`,`detailedaddress`,`PostCode`,`fax`,`contact`,`department`,`duty`,`officephones`,`mobiletelephones`,`post`,`company`,`registeredcapital`,`stated`,`bankaccount`,`Account`,`depositbank`,`bankaddress`,`taxnumber`,`bankiphone`,`nid`,`classif`) values 
(2,'四川银行','KKK',2,'j','6','j','j','j','j','j','j',678,'j','j',67,123,'jj','j','j','j',888,'j','j','j','j','j',NULL,NULL),
(5,'天天银行','hhh',2,'k','8','k','k','k','k','k','k',678,'k','k',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(6,'广州银行','bbb',4,NULL,'5',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `contract_management` */

DROP TABLE IF EXISTS `contract_management`;

CREATE TABLE `contract_management` (
  `contId` int(11) NOT NULL AUTO_INCREMENT,
  `contName` varchar(200) DEFAULT NULL,
  `contNum` varchar(1000) DEFAULT NULL,
  `contMany` double(10,2) DEFAULT '0.00',
  `contDate` date DEFAULT NULL,
  `commenDate` date DEFAULT NULL,
  `viability` date DEFAULT NULL,
  `contact` varchar(1000) DEFAULT NULL,
  `landline` bigint(20) DEFAULT NULL,
  `cellphone` bigint(20) DEFAULT NULL,
  `emaile_qq` varchar(1000) DEFAULT NULL,
  `tech_term` varchar(1000) DEFAULT NULL,
  `com_clause` varchar(1000) DEFAULT NULL,
  `accessory` varchar(1000) DEFAULT NULL,
  `coll_term` varchar(1000) DEFAULT NULL,
  `relat_per` varchar(1000) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`contId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `contract_management` */

insert  into `contract_management`(`contId`,`contName`,`contNum`,`contMany`,`contDate`,`commenDate`,`viability`,`contact`,`landline`,`cellphone`,`emaile_qq`,`tech_term`,`com_clause`,`accessory`,`coll_term`,`relat_per`,`status`,`cid`,`did`,`uid`) values 
(1,'西安','C1001471',2800000.00,'2019-12-19','2016-08-01','2019-12-05','张三',18795362321,18795362321,'126@126.com','【产品或交付物】系统集成方案和系统升级服务器','【付款方式】支票转账','12','销售部','王娜','执行中的合同',2,NULL,4),
(2,'昆明东山风景区-风景区开发项目管理平台','C1001388',450000.00,'2016-09-22','2016-10-04','2019-11-26','李四',18762345765,18762345765,'marrry@qq.com','【产品或交付物】系统集成方案和系统升级服务器','【付款方式】支票转账','C:\\fakepath\\新建文本文档 (2).txt','市场部','张娜','执行中的合同',2,NULL,4),
(3,'江苏移动总公司-系统对接融合方案','C1001339',450000.00,'2018-04-18','2018-04-29','2019-03-06','王五',13425436345,13425436345,'leng@qq.com','【产品或交付物】系统集成方案和系统升级服务器','【付款方式】现金','12','编辑部','刘洋','执行中的合同',2,NULL,4),
(4,'2222','22222',222222.00,'2019-12-20','2019-12-28','2019-12-25','国航',1111,1111,'1','1','1','12','1','','已关闭的合同',2,NULL,3),
(5,'1','1',1.00,'2019-11-26','2019-12-27','2019-12-19','1',1,1,'1','1','1','1','1','1','已关闭的合同',2,NULL,2),
(6,'1111','222',0.00,'2019-12-03','2019-11-29','2019-11-26','1',1,1,'1','1','1','1','1','','已撤出的合同',2,NULL,1),
(7,'111111112','11111111',1.00,'2019-12-10','2019-12-29','2020-01-05','1',1,1,'1','1','1','1','1','1','已搁置的合同',2,NULL,4),
(8,'安徽 ','a1009293',444444.00,'2019-12-03','2019-12-29','2020-01-05','张娜',13728378321,13728378321,'126@126.com','1','1','1','1','1','执行中的合同',2,NULL,2),
(9,'sasd','s1099832',111.00,'2019-12-21','2019-12-21','2019-12-22','1111',1,1,'1','1','1','1','1','1','被搁置的合同',2,NULL,3);

/*Table structure for table `datetype` */

DROP TABLE IF EXISTS `datetype`;

CREATE TABLE `datetype` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `type` int(200) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

/*Data for the table `datetype` */

insert  into `datetype`(`id`,`type`,`title`) values 
(4,1,'故障申报'),
(5,4,'老客户'),
(6,8,'IT|互联网|通信|电子'),
(7,8,'房产|建筑建设|物业'),
(8,8,'管理咨询|教育科研|中介服务'),
(9,8,'酒店旅游'),
(10,8,'其他'),
(11,9,'电话访问'),
(12,9,'独立开发'),
(13,9,'二次销售'),
(14,9,'合作伙伴'),
(15,9,'互联网'),
(16,1,'业务咨询'),
(17,1,'实施或培训'),
(18,1,'主动关怀'),
(19,1,'其他'),
(20,2,'故障申报'),
(21,2,'业务咨询'),
(22,2,'实施或培训'),
(23,2,'主动关怀'),
(24,2,'其他'),
(25,10001,'客户分类一'),
(26,10001,'客户分类二'),
(27,10001,'客户分类三'),
(28,10002,'我负责的商机'),
(29,10002,'我参与的商机'),
(30,10002,'我关注的商机'),
(31,10002,'7天未跟单'),
(32,10002,'30天未跟单'),
(33,10002,'90天未跟单'),
(34,10002,'本周新增'),
(35,10002,'上周新增'),
(36,10002,'本月新增'),
(37,10002,'上月新增'),
(38,10002,'本季度新增'),
(39,10002,'上季度新增'),
(40,10002,'已成交的商机'),
(41,10002,'已丢单的商机'),
(42,10002,'已搁置的商机'),
(43,10003,'已执行的合同'),
(44,10003,'已关闭的合同'),
(45,10003,'已撤出的合同'),
(46,10003,'已搁置的合同'),
(47,10003,'本周新增'),
(48,10003,'上周新增'),
(49,10003,'本月新增'),
(50,10003,'上月新增'),
(51,10003,'本季度新增'),
(52,10003,'上季度新增'),
(53,10004,'处理中的服务'),
(54,10004,'已结束的服务'),
(55,10004,'已撤除的服务'),
(56,10004,'本周新增'),
(57,10004,'上周新增'),
(58,10004,'本月新增'),
(59,10004,'上月新增'),
(60,10004,'本季度新增'),
(61,10004,'上季度新增'),
(62,10005,'我的统计'),
(63,10005,'本周统计'),
(64,10005,'本月统计'),
(65,10005,'本季度统计'),
(66,10005,'本年度统计'),
(67,10005,'商机销售漏斗'),
(68,10005,'按行业分布'),
(69,10005,'按商机来源');

/*Table structure for table `documentary` */

DROP TABLE IF EXISTS `documentary`;

CREATE TABLE `documentary` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `docudate` varchar(200) DEFAULT NULL,
  `docutheme` varchar(200) DEFAULT NULL,
  `dname` varchar(10) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `accessory` varchar(255) DEFAULT NULL,
  `nid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `documentary` */

insert  into `documentary`(`did`,`docudate`,`docutheme`,`dname`,`content`,`accessory`,`nid`,`cid`,`uid`) values 
(21,'2019-12-05','1','k','k','k',1,NULL,NULL),
(22,'2019-12-12','2','p','p','p',2,NULL,NULL),
(23,'2019-12-12','2','o','o','o',3,NULL,NULL),
(24,'2019-12-12','2','o','o','o',2,NULL,NULL),
(25,'2019-12-12','1','o','o','o',4,NULL,NULL),
(26,'2019-12-12','2','o','o','o',3,NULL,NULL),
(27,'2019-12-03','3','','','',NULL,NULL,NULL);

/*Table structure for table `forum_management` */

DROP TABLE IF EXISTS `forum_management`;

CREATE TABLE `forum_management` (
  `forumId` int(11) NOT NULL AUTO_INCREMENT,
  `motif` varchar(1000) DEFAULT NULL,
  `author` varchar(1000) DEFAULT NULL,
  `business` varchar(1000) DEFAULT NULL,
  `post_type` varchar(1000) DEFAULT NULL,
  `accessory` varchar(1000) DEFAULT NULL,
  `click` int(11) DEFAULT '0',
  `replytime` date DEFAULT NULL,
  `label` varchar(1000) DEFAULT NULL,
  `post_content` longtext,
  `c` int(11) DEFAULT '0',
  `status` varchar(200) DEFAULT '1',
  PRIMARY KEY (`forumId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `forum_management` */

insert  into `forum_management`(`forumId`,`motif`,`author`,`business`,`post_type`,`accessory`,`click`,`replytime`,`label`,`post_content`,`c`,`status`) values 
(1,'12','1','1','合理化建议','1',23,'2019-12-29','a','1111111',11,'2'),
(2,'1111','1','1','技术交流','1',4,'2020-01-05','111','11111111',0,'3'),
(3,'1','1','1','技术交流','1',19,'2019-12-20','1','111111111111',8,'1'),
(10,'香港暴乱','张三','33','生活娱乐','2',1,'2019-12-29',NULL,'33二的烦烦烦',0,'2'),
(11,'香港暴乱1','李四','3','合理化建议','2',0,'2019-12-20',NULL,'给法官认定',0,'1'),
(12,'香港暴乱2','王五','333','生活娱乐','4',0,'2019-12-28',NULL,'广泛广泛的的方法',0,'1'),
(14,'香港暴乱4','3333','444','生活娱乐','4',33,'2019-12-29',NULL,'烦烦烦烦烦烦',0,'3'),
(17,'asdx',NULL,'efc','企业文化',NULL,0,'2019-12-20','11','',0,'1');

/*Table structure for table `invoice_application` */

DROP TABLE IF EXISTS `invoice_application`;

CREATE TABLE `invoice_application` (
  `inId` int(11) NOT NULL AUTO_INCREMENT,
  `motif` varchar(1000) DEFAULT NULL,
  `endTime` date DEFAULT NULL,
  `detailedaddress` varchar(1000) DEFAULT NULL,
  `alName` varchar(1000) DEFAULT NULL,
  `affDept` varchar(1000) DEFAULT NULL,
  `alDate` date DEFAULT NULL,
  `tech_term` varchar(1000) DEFAULT NULL,
  `unit` varchar(1000) DEFAULT NULL,
  `inKind` varchar(1000) DEFAULT NULL,
  `reg_number` varchar(1000) DEFAULT NULL,
  `bankName_Id` varchar(1000) DEFAULT NULL,
  `add_phone` varchar(1000) DEFAULT NULL,
  `inAmount` double(10,2) DEFAULT '0.00',
  `ca_amount` varchar(1000) DEFAULT NULL,
  `inDate` date DEFAULT NULL,
  `inNumber` varchar(1000) DEFAULT NULL,
  `accessory` varchar(1000) DEFAULT NULL,
  `contId` int(11) DEFAULT NULL,
  PRIMARY KEY (`inId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `invoice_application` */

insert  into `invoice_application`(`inId`,`motif`,`endTime`,`detailedaddress`,`alName`,`affDept`,`alDate`,`tech_term`,`unit`,`inKind`,`reg_number`,`bankName_Id`,`add_phone`,`inAmount`,`ca_amount`,`inDate`,`inNumber`,`accessory`,`contId`) values 
(1,NULL,NULL,NULL,NULL,'市场部','2019-09-17','哇哇哇哇哇哇哇','q',NULL,NULL,NULL,NULL,50000.00,NULL,NULL,NULL,NULL,1),
(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,22222.00,NULL,NULL,NULL,NULL,2),
(3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0.00,NULL,NULL,NULL,NULL,3),
(4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0.00,NULL,NULL,NULL,NULL,4),
(5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0.00,NULL,NULL,NULL,NULL,5),
(6,'李萌','2019-12-12','1','1','销售部','2019-12-28','1','1','1','1','1111','11',10000.00,'壹万','2019-12-29','100983',NULL,6),
(7,'李萌','2019-12-12','1','1','销售部','2019-12-28','1','1','1','1','1111','11',10000.00,'壹万','2019-12-29','100983',NULL,4),
(8,'1','2019-12-12','1','1','销售部','2019-12-26','1','1','1','编辑部','111111111','111111',1000.00,'1000','2019-12-21','1009831',NULL,3),
(9,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL),
(10,'1','2019-12-18','1','1','1','2019-12-11','1','1','1','1','1','1',1000.00,'1','2019-12-20','100983',NULL,5),
(11,'1','2019-12-26','1','1','1','2019-12-05','1','1','1','1','1','1',1.00,'0','2019-12-11','100983',NULL,5);

/*Table structure for table `newbusiness` */

DROP TABLE IF EXISTS `newbusiness`;

CREATE TABLE `newbusiness` (
  `nid` int(11) NOT NULL AUTO_INCREMENT,
  `nname` varchar(255) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `cid` int(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `perdictmoney` int(11) DEFAULT NULL,
  `preddate` date DEFAULT NULL,
  `iname` varchar(255) DEFAULT NULL,
  `section` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `mophone` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `demane` varchar(255) DEFAULT NULL,
  `accessory` varchar(255) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `principal` varchar(255) DEFAULT NULL,
  `participant` varchar(255) DEFAULT NULL,
  `concerned` varchar(255) DEFAULT NULL,
  `ntime` datetime DEFAULT NULL,
  `status` int(200) DEFAULT '0',
  `stage` varchar(200) DEFAULT NULL,
  `uid` int(20) DEFAULT NULL,
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `newbusiness` */

insert  into `newbusiness`(`nid`,`nname`,`priority`,`cid`,`source`,`perdictmoney`,`preddate`,`iname`,`section`,`post`,`telephone`,`mophone`,`qq`,`demane`,`accessory`,`branch`,`principal`,`participant`,`concerned`,`ntime`,`status`,`stage`,`uid`) values 
(1,'鸿运',NULL,2,'11',4000,NULL,NULL,NULL,'d',NULL,NULL,NULL,NULL,NULL,NULL,'z',NULL,NULL,'2019-12-02 08:43:01',0,'成功',4),
(2,'天猫',NULL,5,'12',6000,NULL,NULL,NULL,'f',NULL,NULL,NULL,NULL,NULL,NULL,'w',NULL,NULL,'2019-12-05 08:43:09',4,'成功',4),
(3,'阿里',NULL,5,'13',3000,NULL,NULL,NULL,'t',NULL,NULL,NULL,NULL,NULL,NULL,'d',NULL,NULL,'2019-12-04 08:43:14',3,'成功',3),
(4,'天涯',NULL,2,'14',200,NULL,NULL,NULL,'h',NULL,NULL,NULL,NULL,NULL,NULL,'c',NULL,NULL,'2019-12-04 08:43:17',1,'成功',4),
(6,'天涯',NULL,2,'14',200,NULL,NULL,NULL,'h',NULL,NULL,NULL,NULL,NULL,NULL,'c',NULL,NULL,'2019-12-18 08:43:21',2,'成功',4);

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `perId` int(11) NOT NULL AUTO_INCREMENT,
  `perName` varchar(1000) DEFAULT NULL,
  `perUrl` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`perId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `permission` */

insert  into `permission`(`perId`,`perName`,`perUrl`) values 
(1,'合同查询',NULL),
(2,'合同添加',NULL),
(3,'合同编辑',NULL),
(4,'帖子查看',NULL),
(5,'发帖',NULL),
(6,'回复帖子',NULL),
(7,'基础数据查询',NULL);

/*Table structure for table `register_income` */

DROP TABLE IF EXISTS `register_income`;

CREATE TABLE `register_income` (
  `regId` int(11) NOT NULL AUTO_INCREMENT,
  `regDate` date DEFAULT NULL,
  `regClassify` varchar(1000) DEFAULT NULL,
  `regMany` double(10,2) DEFAULT '0.00',
  `capital` varchar(1000) DEFAULT NULL,
  `payment_term` varchar(1000) DEFAULT NULL,
  `registrant` varchar(1000) DEFAULT NULL,
  `relat_per` varchar(1000) DEFAULT NULL,
  `relat_dept` varchar(1000) DEFAULT NULL,
  `unit` varchar(1000) DEFAULT NULL,
  `relat_cont` varchar(1000) DEFAULT NULL,
  `income_sta` varchar(1000) DEFAULT NULL,
  `contId` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`regId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `register_income` */

insert  into `register_income`(`regId`,`regDate`,`regClassify`,`regMany`,`capital`,`payment_term`,`registrant`,`relat_per`,`relat_dept`,`unit`,`relat_cont`,`income_sta`,`contId`,`cid`) values 
(14,'2019-12-12','1',1000.00,'1','1','1','1','1','1','1','1',1,1),
(15,'2019-12-10','2',1000.00,'2','2','2','2','2','2','2','2',3,1),
(21,'2020-01-04','主营业务收入',1000.00,'1','2','张娜','1','市场部','岳云鹏','C1001388','1',1,3),
(22,'2019-12-28','主营业务收入',2000.00,'贰仟','1','张娜','王五','市场部','岳云鹏','C1001388','合同定金',4,2),
(23,'2019-12-28','主营业务收入',1000.00,'壹仟','1','张娜','王五','市场部','岳云鹏','C1001388','合同部分钱',2,2),
(26,'2019-12-14','主营业务收入',1000.00,'1','2','1','1','1','leng','1','1',5,NULL),
(29,'2019-12-06','投资收益',1.00,'0','2','1','1','1','leng','1','1',5,NULL);

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `replyId` int(11) NOT NULL AUTO_INCREMENT,
  `replyName` varchar(100) DEFAULT NULL,
  `replytime` varchar(200) DEFAULT NULL,
  `content` longtext,
  `forumId` int(11) DEFAULT NULL,
  PRIMARY KEY (`replyId`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

/*Data for the table `reply` */

insert  into `reply`(`replyId`,`replyName`,`replytime`,`content`,`forumId`) values 
(1,'张三','2019-12-14 08:50:40','hahahaha',1),
(3,'zhangs','2019-12-12 08:50:44','GIF89a???',2),
(8,'222','2019-12-19 09:13:11','啊啊啊啊啊啊',6),
(16,'222','2019-12-21 11:22:47',NULL,3),
(17,'222','2019-12-19 11:26:36',NULL,2),
(18,'222','2019-01-01 11:28:08',NULL,10),
(19,'222','2019-01-01 11:28:08',NULL,2),
(20,'222','2019-12-19 11:32:27','',1),
(29,'222','2019-12-19 11:55:44','q',3),
(31,'222','2019-12-19 11:58:03','a',3),
(33,'222','2019-12-20 12:01:28','kj',11),
(34,'222','2019-12-19 12:03:43','ku',12),
(35,'222','2019-12-19 12:04:41','li',3),
(36,'222','2019-12-19 12:05:36','aaa',1),
(37,'222','2019-12-19 12:07:43','wedr',5),
(44,'222','2019-12-19 12:42:30','李四哈哈哈哈哈',3),
(45,'222','2019-12-19 12:46:17','阿斯顿',1),
(46,'222','2019-12-19 13:46:16','钱钱钱去',3),
(53,'222','2019-12-20 18:47:21','<strike>有有有由于</strike>',14),
(54,'222','2019-12-19 18:47:51','<b>该货币环境改变</b>',1);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`roleId`,`roleName`) values 
(1,'管理员'),
(2,'项目经理'),
(3,'组长'),
(4,'员工');

/*Table structure for table `role_per` */

DROP TABLE IF EXISTS `role_per`;

CREATE TABLE `role_per` (
  `roleId` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_per` */

insert  into `role_per`(`roleId`,`pid`) values 
(2,2),
(3,3),
(4,4),
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,6),
(1,7);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int(200) NOT NULL AUTO_INCREMENT,
  `number` varchar(11) NOT NULL,
  `password` varchar(18) NOT NULL,
  `img` varchar(200) DEFAULT NULL,
  `title` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uid`,`number`,`password`,`img`,`title`) values 
(1,'张三','123','pig','s'),
(2,'李四','345','pig','t'),
(3,'dsd','wwq',NULL,'dfd'),
(4,'admin','admin',NULL,'');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `uid` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`uid`,`roleId`) values 
(1,1),
(4,4),
(3,1),
(3,2),
(3,3),
(2,2),
(2,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
