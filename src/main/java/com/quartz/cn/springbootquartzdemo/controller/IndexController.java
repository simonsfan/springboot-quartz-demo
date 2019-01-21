package com.quartz.cn.springbootquartzdemo.controller;

import com.quartz.cn.springbootquartzdemo.bean.MovieSearch;
import com.quartz.cn.springbootquartzdemo.bean.MovieIndex;
import com.quartz.cn.springbootquartzdemo.bean.QuartzTaskInformations;
import com.quartz.cn.springbootquartzdemo.service.quartz.MovieSearchService;
import com.quartz.cn.springbootquartzdemo.service.quartz.QuartzService;
import com.quartz.cn.springbootquartzdemo.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName IndexController
 * @Description 首页跳转controller
 * @Author simonsfan
 * @Date 2019/1/4
 * Version  1.0
 */
@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private QuartzService quartzService;
    @Autowired
    private MovieSearchService movieSearchService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listTasks(Model model, @RequestParam(value = "currentPage", required = false, defaultValue = "1") String currentPage,
                            @RequestParam(value = "taskNo", required = false) String taskNo) {
        try {
            List<QuartzTaskInformations> taskList = quartzService.getTaskList(taskNo, currentPage);
            int current = Integer.parseInt(currentPage);
            Page<QuartzTaskInformations> page = new Page(taskList, taskList.size(), current);
            model.addAttribute("taskList", taskList);
            model.addAttribute("size", taskList.size());
            model.addAttribute("currentPage", page.getCurrentPage());
            model.addAttribute("totalPage", page.getTotalPage());
            model.addAttribute("taskNo", taskNo);
        } catch (Exception e) {
            logger.error("首页跳转发生异常exceptions-->" + e.toString());
        }
        return "/index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchEs(Model model,
                           @RequestParam(value = "keyword", required = false) String keyword,
                           @RequestParam(value = "label", required = false) String label,
                           @RequestParam(value = "area", required = false) String area,
                           @RequestParam(value = "release", required = false) String release) {
        logger.info("");
        MovieSearch movieSearch = new MovieSearch();
        try {
            movieSearch.setKeyword(keyword);
            movieSearch.setArea(area);
            movieSearch.setRelease(release);
            movieSearch.setLabel(label);
            List<MovieIndex> movieIndices = movieSearchService.searchMovie(movieSearch);
            model.addAttribute("movieIndices", movieIndices);
        } catch (Exception e) {
            logger.error("es查询发生异常exceptions={}", e.toString());
            return "/error";
        }
        return "/movie";
    }


}
