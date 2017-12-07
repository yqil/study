表结构：
CREATE TABLE `t_msg` (
`id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '主键' ,
`msg_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息名称' ,
`msg_content`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '消息内容,json格式' ,
`send_num`  tinyint(2) NOT NULL DEFAULT 1 COMMENT '可以发送的总次数' ,
`reset_num`  tinyint(2) NOT NULL DEFAULT 0 COMMENT '已重试的次数' ,
`reset_rate`  int(11) NOT NULL DEFAULT 3 COMMENT '重发频率，分钟为单位' ,
`last_send_time`  datetime NOT NULL COMMENT '上一次发送的时间' ,
`status`  tinyint(2) NOT NULL COMMENT '状态\r\n。1：待确认，\r\n2：待发送\r\n，3：发送成功，4：发送失败，\r\n5：处理成功，6：处理失败' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
ROW_FORMAT=COMPACT
;