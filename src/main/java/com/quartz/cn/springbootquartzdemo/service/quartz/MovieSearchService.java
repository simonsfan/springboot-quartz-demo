package com.quartz.cn.springbootquartzdemo.service.quartz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.quartz.cn.springbootquartzdemo.bean.MovieSearch;
import com.quartz.cn.springbootquartzdemo.vo.MovieIndexTemplate;
import com.quartz.cn.springbootquartzdemo.vo.MovieVo;

import java.util.List;

/**
 * @ClassName MovieSearchService
 * @Description TODO
 * @Author simonsfan
 * @Date 2019/1/16
 * Version  1.0
 */
public interface MovieSearchService {

    List<MovieVo> searchMovie(MovieSearch search);
    String addIndex(MovieIndexTemplate indexTemplate);
    String getIndex(String id);
    String deleteIndex(String id);
    String deleteByQueryAction(String keyword);
    void buldOption(MovieIndexTemplate indexTemplate, String id) throws JsonProcessingException;
}
