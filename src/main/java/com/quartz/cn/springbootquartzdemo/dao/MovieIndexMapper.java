package com.quartz.cn.springbootquartzdemo.dao;


import com.quartz.cn.springbootquartzdemo.bean.MovieIndex;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MovieIndexMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MovieIndex record);

    int insertSelective(MovieIndex record);

    MovieIndex selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MovieIndex record);

    int updateByPrimaryKey(MovieIndex record);

    List<MovieIndex> selectDefault();
}
