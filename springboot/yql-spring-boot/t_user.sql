CREATE TABLE `t_user` (
`id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '����id' ,
`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '����' ,
`sex`  int(2) NULL DEFAULT NULL COMMENT '�Ա�1���У�2��Ů��3��δ֪' ,
`age`  int(3) NULL DEFAULT NULL COMMENT '����' ,
`creater`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '������id' ,
`create_date`  datetime NULL DEFAULT NULL COMMENT '����ʱ��' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
ROW_FORMAT=COMPACT
;