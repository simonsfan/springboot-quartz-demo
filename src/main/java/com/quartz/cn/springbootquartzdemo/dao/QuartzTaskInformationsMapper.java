package com.quartz.cn.springbootquartzdemo.dao;


import com.quartz.cn.springbootquartzdemo.bean.QuartzTaskInformations;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuartzTaskInformationsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QuartzTaskInformations record);

    int insertSelective(QuartzTaskInformations record);

    QuartzTaskInformations selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuartzTaskInformations record);

    int updateByPrimaryKey(QuartzTaskInformations record);

    List<QuartzTaskInformations> selectList(Map<String, Object> map);

    Integer selectByTaskNo(String taskNo);

    QuartzTaskInformations getTaskByTaskNo(String taskNo);

    List<QuartzTaskInformations> getUnfrozenTasks(String status);
}
