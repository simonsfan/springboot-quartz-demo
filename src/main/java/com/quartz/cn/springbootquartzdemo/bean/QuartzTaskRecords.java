package com.quartz.cn.springbootquartzdemo.bean;

public class QuartzTaskRecords {
    private Long id;

    private String taskno;

    private String timekeyvalue;

    private Long executetime;

    private String taskstatus;

    private Integer failcount;

    private String failreason;

    private Long createtime;

    private Long lastmodifytime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskno() {
        return taskno;
    }

    public void setTaskno(String taskno) {
        this.taskno = taskno == null ? null : taskno.trim();
    }

    public String getTimekeyvalue() {
        return timekeyvalue;
    }

    public void setTimekeyvalue(String timekeyvalue) {
        this.timekeyvalue = timekeyvalue == null ? null : timekeyvalue.trim();
    }

    public Long getExecutetime() {
        return executetime;
    }

    public void setExecutetime(Long executetime) {
        this.executetime = executetime;
    }

    public String getTaskstatus() {
        return taskstatus;
    }

    public void setTaskstatus(String taskstatus) {
        this.taskstatus = taskstatus == null ? null : taskstatus.trim();
    }

    public Integer getFailcount() {
        return failcount;
    }

    public void setFailcount(Integer failcount) {
        this.failcount = failcount;
    }

    public String getFailreason() {
        return failreason;
    }

    public void setFailreason(String failreason) {
        this.failreason = failreason == null ? null : failreason.trim();
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
}
