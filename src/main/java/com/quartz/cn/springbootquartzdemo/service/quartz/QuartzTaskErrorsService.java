package com.quartz.cn.springbootquartzdemo.service.quartz;

import com.quartz.cn.springbootquartzdemo.bean.QuartzTaskErrors;

public interface QuartzTaskErrorsService {
    Integer addTaskErrorRecord(QuartzTaskErrors quartzTaskErrors);

    QuartzTaskErrors detailTaskErrors(String recordId);
}
