DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `sex` bit(1) DEFAULT NULL COMMENT '性别: 1 - 男, 2 - 女',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态: 1 - 启用, 2 - 冻结, 3 - 禁用',
  `version` int(11) DEFAULT NULL COMMENT '版本锁',
  `deleted` int(11) DEFAULT NULL COMMENT '逻辑删除: 1 - 已删除, 0 - 未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;