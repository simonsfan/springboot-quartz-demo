package com.quartz.cn.springbootquartzdemo.bean;

public class QuartzTaskErrors {
    private Long id;

    private String taskexecuterecordid;

    private String errorkey;

    private Long createtime;

    private Long lastmodifytime;

    private String errorvalue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskexecuterecordid() {
        return taskexecuterecordid;
    }

    public void setTaskexecuterecordid(String taskexecuterecordid) {
        this.taskexecuterecordid = taskexecuterecordid == null ? null : taskexecuterecordid.trim();
    }

    public String getErrorkey() {
        return errorkey;
    }

    public void setErrorkey(String errorkey) {
        this.errorkey = errorkey == null ? null : errorkey.trim();
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Long lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    public String getErrorvalue() {
        return errorvalue;
    }

    public void setErrorvalue(String errorvalue) {
        this.errorvalue = errorvalue == null ? null : errorvalue.trim();
    }
}
