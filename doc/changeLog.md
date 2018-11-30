## 变更记录


> 2018-11-18  

1.  新增测试模块ruoyi-test，用于补充使用文档

2.  新增模块：内容管理模块hylu-content

3.  补充环境使用手动---系统功能的代码生成文档

> 2018/-11-30

抓取网易云用户信息（关注链）
CREATE TABLE `music_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) DEFAULT NULL COMMENT '用户编码',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `remark_name` varchar(255) DEFAULT NULL COMMENT '备注名称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `py` varchar(50) DEFAULT NULL COMMENT '名称拼音',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别 0未知 1男 2女',
  `event_count` int(11) DEFAULT NULL COMMENT '动态数',
  `follow_count` int(11) DEFAULT NULL COMMENT '关注数',
  `fan_count` int(11) DEFAULT NULL COMMENT '粉丝数',
  `signature` longtext CHARACTER SET utf8mb4 COMMENT '个人签名',
  `auth_status` int(11) DEFAULT NULL COMMENT '歌手类型',
  `user_type` int(11) DEFAULT NULL COMMENT '用户类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `has_used` int(11) DEFAULT '0' COMMENT '状态：1已使用 0未使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12300 DEFAULT CHARSET=utf8 COMMENT='用户信息表';



