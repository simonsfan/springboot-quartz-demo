package com.quartz.cn.springbootquartzdemo.es;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.quartz.cn.springbootquartzdemo.SpringbootQuartzDemoApplicationTests;
import com.quartz.cn.springbootquartzdemo.service.quartz.MovieSearchService;
import com.quartz.cn.springbootquartzdemo.vo.MovieIndexTemplate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName EsTest
 * @Description TODO
 * @Author simonsfan
 * @Date 2019/1/17
 * Version  1.0
 */
public class EsTest extends SpringbootQuartzDemoApplicationTests {

    @Autowired
    private MovieSearchService movieSearchService;

    @Test
    public void testAddDocument() {
        MovieIndexTemplate indexTemplate = new MovieIndexTemplate();
        indexTemplate.setName("喜剧之王");
        indexTemplate.setAlias("喜剧之王");
        indexTemplate.setActors("周星驰，莫文蔚，张柏芝，吴孟达，林子善，田启文");
        indexTemplate.setDirectors("周星驰  李力持");
        indexTemplate.setIntroduction("《喜剧之王》是星辉海外有限公司出品的一部喜剧电影，由李力持、周星驰执导，周星驰、 莫文蔚、张柏芝等主演。该片于1999年2月13日在香港上映。影片讲述对喜剧情有独钟的尹天仇与舞女柳飘飘逐渐产生感情，之后在杜娟儿的帮助下，尹天仇终于获得机会演主角，但又陷入与柳飘飘、杜娟儿的三角恋漩涡之中");
        indexTemplate.setArea("内地");
        indexTemplate.setScore(9.4f);
        indexTemplate.setLabel("喜剧 爱情");
        indexTemplate.setRelease("1999");
        movieSearchService.addIndex(indexTemplate);
    }

    @Test
    public void getIndex(){
        String id = "9jCqWmgBBHn7Efnc5vWO";
        movieSearchService.getIndex(id);
    }

    @Test
    public void deleteIndex(){
        String id = "hTCYWmgBBHn7EfncQOq6";
        movieSearchService.deleteIndex(id);
    }

    @Test
    public void deleteByQueryAction(){
        String name = "喜剧之王";
        movieSearchService.deleteByQueryAction(name);
    }

    @Test
    public void bulkOption() throws JsonProcessingException {
        MovieIndexTemplate indexTemplate = new MovieIndexTemplate();
        indexTemplate.setName("喜剧之王");
        indexTemplate.setAlias("喜剧之王");
        indexTemplate.setActors("周星驰，莫文蔚，张柏芝，吴孟达，林子善，田启文");
        indexTemplate.setDirectors("周星驰  李力持");
        indexTemplate.setIntroduction("《喜剧之王》是星辉海外有限公司出品的一部喜剧电影，由李力持、周星驰执导，周星驰、 莫文蔚、张柏芝等主演。该片于1999年2月13日在香港上映。影片讲述对喜剧情有独钟的尹天仇与舞女柳飘飘逐渐产生感情，之后在杜娟儿的帮助下，尹天仇终于获得机会演主角，但又陷入与柳飘飘、杜娟儿的三角恋漩涡之中");
        indexTemplate.setArea("内地");
        indexTemplate.setScore(9.4f);
        indexTemplate.setLabel("喜剧 爱情");
        indexTemplate.setRelease("1999");

        String id = "UDHaWmgBBHn7EfncqRNC";
        movieSearchService.buldOption(indexTemplate,id);

    }


}
