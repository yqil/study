��ṹ��
CREATE TABLE `t_msg` (
`id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '����' ,
`msg_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '��Ϣ����' ,
`msg_content`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '��Ϣ����,json��ʽ' ,
`send_num`  tinyint(2) NOT NULL DEFAULT 1 COMMENT '���Է��͵��ܴ���' ,
`reset_num`  tinyint(2) NOT NULL DEFAULT 0 COMMENT '�����ԵĴ���' ,
`reset_rate`  int(11) NOT NULL DEFAULT 3 COMMENT '�ط�Ƶ�ʣ�����Ϊ��λ' ,
`last_send_time`  datetime NOT NULL COMMENT '��һ�η��͵�ʱ��' ,
`status`  tinyint(2) NOT NULL COMMENT '״̬\r\n��1����ȷ�ϣ�\r\n2��������\r\n��3�����ͳɹ���4������ʧ�ܣ�\r\n5������ɹ���6������ʧ��' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '����ʱ��' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
ROW_FORMAT=COMPACT
;