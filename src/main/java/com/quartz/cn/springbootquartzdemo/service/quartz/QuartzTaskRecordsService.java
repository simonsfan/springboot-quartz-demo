package com.quartz.cn.springbootquartzdemo.service.quartz;

import com.quartz.cn.springbootquartzdemo.bean.QuartzTaskRecords;

import java.util.List;

public interface QuartzTaskRecordsService {

    long addTaskRecords(QuartzTaskRecords quartzTaskRecords);

    Integer updateTaskRecords(QuartzTaskRecords quartzTaskRecords);

    List<QuartzTaskRecords> listTaskRecordsByTaskNo(String taskNo);

}
