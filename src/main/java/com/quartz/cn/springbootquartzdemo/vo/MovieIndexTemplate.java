package com.quartz.cn.springbootquartzdemo.vo;

/**
 * @ClassName MovieIndexTemplate
 * @Description movie_index索引对应实体类封装
 * @Author simonsfan
 * @Date 2019/1/17
 * Version  1.0
 */
public class MovieIndexTemplate {

    private String name;

    private String alias;

    private String actors;

    private String directors;

    private String introduction;

    private String area;

    private float score;

    private String label;

    private  String release;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }
}
