-- Mysql
-- Host: 192.9.99.150

-- create database : ctsida
create database ctsida;

use ctsida;

-- data_collection
-- Table structure for table `collection_records`

DROP TABLE IF EXISTS `collection_records`;

CREATE TABLE `collection_records` (
  `coll_task_id` varchar(100) NOT NULL,
  `data_id` int(11) NOT NULL,
  `data_name` varchar(100) NOT NULL,
  `HDFS_path` varchar(255) NOT NULL,
  `upload_time` varchar(100) NOT NULL,
  PRIMARY KEY (`coll_task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

