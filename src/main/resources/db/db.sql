
DROP TABLE IF EXISTS `quartz_task_informations`;
CREATE TABLE `quartz_task_informations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL COMMENT '版本号：需要乐观锁控制',
  `taskNo` varchar(64) NOT NULL COMMENT '任务编号',
  `taskName` varchar(64) NOT NULL COMMENT '任务名称',
  `schedulerRule` varchar(64) NOT NULL COMMENT '定时规则表达式',
  `frozenStatus` varchar(16) NOT NULL COMMENT '冻结状态',
  `executorNo` varchar(128) NOT NULL COMMENT '执行方',
  `frozenTime` bigint(13) DEFAULT NULL COMMENT '冻结时间',
  `unfrozenTime` bigint(13) DEFAULT NULL COMMENT '解冻时间',
  `createTime` bigint(13) NOT NULL COMMENT '创建时间',
  `lastModifyTime` bigint(13) DEFAULT NULL COMMENT '最近修改时间',
  `sendType` varchar(64) DEFAULT NULL COMMENT '发送方式',
  `url` varchar(64) DEFAULT NULL COMMENT '请求地址',
  `executeParamter` varchar(2000) DEFAULT NULL COMMENT '执行参数',
  `timeKey` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='定时任务信息表';

DROP TABLE IF EXISTS `quartz_task_records`;
CREATE TABLE `quartz_task_records` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taskNo` varchar(64) NOT NULL COMMENT '任务编号',
  `timeKeyValue` varchar(32) DEFAULT NULL COMMENT '执行时间格式值',
  `executeTime` bigint(13) NOT NULL COMMENT '执行时间',
  `taskStatus` varchar(16) NOT NULL COMMENT '任务状态',
  `failcount` int(10) DEFAULT NULL COMMENT '失败统计数',
  `failReason` varchar(64) DEFAULT NULL COMMENT '失败错误描述',
  `createTime` bigint(13) NOT NULL COMMENT '创建时间',
  `lastModifyTime` bigint(13) DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_task_records_taskno` (`taskNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='定时任务执行情况记录表';

DROP TABLE IF EXISTS `quartz_task_errors`;
CREATE TABLE `quartz_task_errors` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taskExecuteRecordId` varchar(64) NOT NULL COMMENT '任务执行记录Id',
  `errorKey` varchar(1024) NOT NULL COMMENT '信息关键字',
  `errorValue` text COMMENT '信息内容',
  `createTime` bigint(13) NOT NULL COMMENT '创建时间',
  `lastModifyTime` bigint(13) DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='定时任务出错现场信息表';
