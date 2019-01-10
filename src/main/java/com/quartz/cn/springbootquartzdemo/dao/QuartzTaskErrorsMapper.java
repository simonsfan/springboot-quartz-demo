package com.quartz.cn.springbootquartzdemo.dao;


import com.quartz.cn.springbootquartzdemo.bean.QuartzTaskErrors;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuartzTaskErrorsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QuartzTaskErrors record);

    int insertSelective(QuartzTaskErrors record);

    QuartzTaskErrors selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuartzTaskErrors record);

    int updateByPrimaryKeyWithBLOBs(QuartzTaskErrors record);

    int updateByPrimaryKey(QuartzTaskErrors record);

    QuartzTaskErrors detailTaskErrors(String recordId);
}
