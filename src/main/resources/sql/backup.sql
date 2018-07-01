/*
MySQL Backup
Source Server Version: 5.7.17
Source Database: house
Date: 2018/6/24 08:52:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `community`
-- ----------------------------
DROP TABLE IF EXISTS `community`;
CREATE TABLE `community` (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `source_id` int(11) NOT NULL,
  `community_code` varchar(20) NOT NULL,
  `community_name` varchar(50) NOT NULL,
  `latitude` decimal(10,6) DEFAULT NULL,
  `longitude` decimal(10,6) DEFAULT NULL,
  `city` varchar(10) NOT NULL,
  `district` varchar(20) NOT NULL,
  `block` varchar(20) NOT NULL,
  `md5` varchar(32) NOT NULL,
  `from_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `to_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(4) NOT NULL DEFAULT '2',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `renting_house`
-- ----------------------------
DROP TABLE IF EXISTS `renting_house`;
CREATE TABLE `renting_house` (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `source_id` int(11) NOT NULL,
  `house_code` varchar(20) NOT NULL,
  `title` varchar(50) NOT NULL,
  `bedroom_num` tinyint(4) DEFAULT NULL,
  `hall_num` tinyint(4) DEFAULT NULL,
  `orientation` varchar(10) DEFAULT NULL,
  `price_total` int(11) DEFAULT NULL,
  `rent_area` decimal(10,2) DEFAULT NULL,
  `community_info_id` bigint(20) NOT NULL,
  `md5` varchar(32) NOT NULL,
  `from_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `to_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(4) NOT NULL DEFAULT '2',
  PRIMARY KEY (`info_id`),
  KEY `FK_renting_house_community` (`community_info_id`),
  CONSTRAINT `FK_renting_house_community` FOREIGN KEY (`community_info_id`) REFERENCES `community` (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
