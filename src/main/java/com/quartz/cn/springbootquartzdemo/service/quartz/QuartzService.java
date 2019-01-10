package com.quartz.cn.springbootquartzdemo.service.quartz;


import com.quartz.cn.springbootquartzdemo.bean.QuartzTaskErrors;
import com.quartz.cn.springbootquartzdemo.bean.QuartzTaskInformations;
import com.quartz.cn.springbootquartzdemo.bean.QuartzTaskRecords;
import com.quartz.cn.springbootquartzdemo.vo.QuartzTaskRecordsVo;
import org.quartz.SchedulerException;

import java.util.List;

public interface QuartzService {
    String addTask(QuartzTaskInformations quartzTaskInformations);

    List<QuartzTaskInformations> getTaskList(String taskNo, String currentPage);

    QuartzTaskInformations getTaskById(String id);

    String updateTask(QuartzTaskInformations quartzTaskInformations);

    String startJob(String taskNo) throws SchedulerException;

    void initLoadOnlineTasks();

    void sendMessage(String message);

    QuartzTaskRecords addTaskRecords(String taskNo);

    Integer updateRecordById(Integer count, Long id);

    Integer updateModifyTimeById(QuartzTaskInformations quartzTaskInformations);

    Integer addTaskErrorRecord(String id, String errorKey, String errorValue);

    List<QuartzTaskRecordsVo> taskRecords(String taskNo);

    String runTaskRightNow(String taskNo);

    QuartzTaskErrors detailTaskErrors(String recordId);
}
