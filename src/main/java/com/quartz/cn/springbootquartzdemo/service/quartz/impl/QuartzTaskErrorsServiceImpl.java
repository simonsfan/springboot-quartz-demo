package com.quartz.cn.springbootquartzdemo.service.quartz.impl;

import com.quartz.cn.springbootquartzdemo.bean.QuartzTaskErrors;
import com.quartz.cn.springbootquartzdemo.dao.QuartzTaskErrorsMapper;
import com.quartz.cn.springbootquartzdemo.service.quartz.QuartzTaskErrorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName QuartzTaskErrorsServiceImpl
 * @Description TODO
 * @Author simonsfan
 * @Date 2019/1/3
 * Version  1.0
 */
@Service
public class QuartzTaskErrorsServiceImpl implements QuartzTaskErrorsService {

    @Autowired
    private QuartzTaskErrorsMapper quartzTaskErrorsMapper;

    @Override
    public Integer addTaskErrorRecord(QuartzTaskErrors quartzTaskErrors) {
        return quartzTaskErrorsMapper.insert(quartzTaskErrors);
    }

    @Override
    public QuartzTaskErrors detailTaskErrors(String recordId) {
        return quartzTaskErrorsMapper.detailTaskErrors(recordId);
    }

}
