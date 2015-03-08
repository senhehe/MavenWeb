CREATE DATABASE shop;
use shop;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `sex` varchar(20) NOT NULL COMMENT '性别',
  `birthday` datetime NOT NULL COMMENT '生日',
  `email` varchar(20) NOT NULL COMMENT '邮箱',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '用户类型',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `name` varchar(40) NOT NULL COMMENT '商品名称',
  `info` varchar(50) DEFAULT NULL COMMENT '商品信息',
  `price` double(15,2) NOT NULL COMMENT '价格',
  `picture` varchar(50) NOT NULL COMMENT '商品图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `product` VALUES (1,'apple','apple book good',10000.00,'image/applebook.jpg'),(2,'book','java web framewoek',100.00,'image/javaee.jpg'),(3,'officemac','the office mac',1000.00,'image/officemac.jpg');

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `userid` varchar(20) NOT NULL COMMENT '用户ID',
  `totalprice` double(15,2) NOT NULL COMMENT '总金额',
  `orderdate` datetime NOT NULL COMMENT '订单时间',
  `linkman` varchar(20) NOT NULL COMMENT '联系人',
  `address` varchar(50) NOT NULL COMMENT '收货地址',
  `phone` varchar(20) NOT NULL COMMENT '联系电话',
  `status` int(11) NOT NULL COMMENT '订单状态',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `order_fk` FOREIGN KEY (`userid`) REFERENCES `user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单项ID',
  `orderid` int(11) NOT NULL COMMENT '订单ID',
  `productid` int(11) NOT NULL COMMENT '商品ID',
  `number` int(11) NOT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`),
  KEY `orderid` (`orderid`),
  KEY `productid` (`productid`),
  CONSTRAINT `orderitem_fk` FOREIGN KEY (`orderid`) REFERENCES `order` (`id`),
  CONSTRAINT `orderitem_fk1` FOREIGN KEY (`productid`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
