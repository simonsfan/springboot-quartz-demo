package com.quartz.cn.springbootquartzdemo.bean;

public class QuartzTaskInformations {
    private Long id;

    private Integer version;

    private String taskno;

    private String taskname;

    private String schedulerrule;

    private String frozenstatus;

    private String executorno;

    private Long frozentime;

    private Long unfrozentime;

    private Long createtime;

    private Long lastmodifytime;

    private String sendtype;

    private String url;

    private String executeparamter;

    private String timekey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getTaskno() {
        return taskno;
    }

    public void setTaskno(String taskno) {
        this.taskno = taskno == null ? null : taskno.trim();
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname == null ? null : taskname.trim();
    }

    public String getSchedulerrule() {
        return schedulerrule;
    }

    public void setSchedulerrule(String schedulerrule) {
        this.schedulerrule = schedulerrule == null ? null : schedulerrule.trim();
    }

    public String getFrozenstatus() {
        return frozenstatus;
    }

    public void setFrozenstatus(String frozenstatus) {
        this.frozenstatus = frozenstatus == null ? null : frozenstatus.trim();
    }

    public String getExecutorno() {
        return executorno;
    }

    public void setExecutorno(String executorno) {
        this.executorno = executorno == null ? null : executorno.trim();
    }

    public Long getFrozentime() {
        return frozentime;
    }

    public void setFrozentime(Long frozentime) {
        this.frozentime = frozentime;
    }

    public Long getUnfrozentime() {
        return unfrozentime;
    }

    public void setUnfrozentime(Long unfrozentime) {
        this.unfrozentime = unfrozentime;
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

    public String getSendtype() {
        return sendtype;
    }

    public void setSendtype(String sendtype) {
        this.sendtype = sendtype == null ? null : sendtype.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getExecuteparamter() {
        return executeparamter;
    }

    public void setExecuteparamter(String executeparamter) {
        this.executeparamter = executeparamter == null ? null : executeparamter.trim();
    }

    public String getTimekey() {
        return timekey;
    }

    public void setTimekey(String timekey) {
        this.timekey = timekey == null ? null : timekey.trim();
    }
}
