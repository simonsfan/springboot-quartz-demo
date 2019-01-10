package com.quartz.cn.springbootquartzdemo.service.quartz.impl;


import com.quartz.cn.springbootquartzdemo.bean.QuartzTaskRecords;
import com.quartz.cn.springbootquartzdemo.dao.QuartzTaskRecordsMapper;
import com.quartz.cn.springbootquartzdemo.service.quartz.QuartzTaskRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName QuartzTaskRecordsServiceImpl
 * @Description TODO
 * @Author simonsfan
 * @Date 2019/1/3
 * Version  1.0
 */
@Service
public class QuartzTaskRecordsServiceImpl implements QuartzTaskRecordsService {

    @Autowired
    private QuartzTaskRecordsMapper quartzTaskRecordsMapper;

    @Override
    public long addTaskRecords(QuartzTaskRecords quartzTaskRecords) {
        return quartzTaskRecordsMapper.insert(quartzTaskRecords);
    }

    @Override
    public Integer updateTaskRecords(QuartzTaskRecords quartzTaskRecords) {
        return quartzTaskRecordsMapper.updateByPrimaryKeySelective(quartzTaskRecords);
    }

    public List<QuartzTaskRecords> listTaskRecordsByTaskNo(String taskNo) {
        return quartzTaskRecordsMapper.getTaskRecordsByTaskNo(taskNo);
    }

    ;

}
