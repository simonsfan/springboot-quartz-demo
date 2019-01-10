package com.quartz.cn.springbootquartzdemo.vo;

/**
 * @ClassName QuartzTaskRecordsVo
 * @Description TODO
 * @Author simonsfan
 * @Date 2019/1/8
 * Version  1.0
 */
public class QuartzTaskRecordsVo
{
    private Long id;

    private String taskno;

    private String timekeyvalue;

    private Long executetime;

    private String taskstatus;

    private Integer failcount;

    private String failreason;

    private Long createtime;

    private Long lastmodifytime;

    private Long time;

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
        this.taskno = taskno;
    }

    public String getTimekeyvalue() {
        return timekeyvalue;
    }

    public void setTimekeyvalue(String timekeyvalue) {
        this.timekeyvalue = timekeyvalue;
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
        this.taskstatus = taskstatus;
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
        this.failreason = failreason;
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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
