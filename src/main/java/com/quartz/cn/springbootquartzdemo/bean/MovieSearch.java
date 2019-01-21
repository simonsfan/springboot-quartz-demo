package com.quartz.cn.springbootquartzdemo.bean;

/**
 * @ClassName MovieSearch
 * @Description TODO
 * @Author simonsfan
 * @Date 2019/1/16
 * Version  1.0
 */
public class MovieSearch {

    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String ALIAS = "alias";
    public static final String ACTORS = "actors";
    public static final String DIRECTORS = "directors";
    public static final String INTRODUCTION = "introduction";
    public static final String LABEL = "label";
    public static final String SCORE = "score";
    public static final String RELEASE = "release";
    public static final String AREA = "area";
    public static final String PICURL = "picurl";

    private String actors;
    private String alias;
    private String directors;
    private String introduction;
    private String label;
    private String name;
    private float score;
    private String release;
    private String area;
    private String picUrl;

    private String keyword;

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
