package com.quartz.cn.springbootquartzdemo.util;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Page
 * @Description 分页实体类
 * @Author simonsfan
 * @Date 2019/1/8
 * Version  1.0
 */
public class Page<T> implements Serializable {
    private static final long serialVersionUID = 130050641959720183L;
    private List<T> list;      //数据集合
    private int totalRecord;   //总记录数
    private int currentPage;   //当前页
    private int pageSize;      //每页大小
    private int startIndex;
    private int totalPage;     //总页数
    private int previousPage;  //前一页
    private int nextPage;      //下一页

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = list.size();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = 10;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = pageSize * (currentPage-1);
    }

    public void setTotalPage(int totalPage) {
        if(this.totalRecord % this.pageSize == 0) {
            this.totalPage = this.totalRecord / this.pageSize;
        }else {
            this.totalPage = this.totalRecord / this.pageSize + 1;
        }
    }

    public void setPreviousPage(int previousPage) {
        if(this.totalRecord % this.pageSize == 0) {
            this.totalPage = this.totalRecord / this.pageSize;
        }else {
            this.totalPage = this.totalRecord / this.pageSize + 1;
        }
    }

    public void setNextPage(int nextPage) {
        if(this.currentPage + 1 > this.totalPage) {
            this.nextPage = this.totalPage;
        }else {
            this.nextPage = this.currentPage + 1;
        }
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    @Override
    public String toString() {
        return "Page{" +
                "list=" + list +
                ", totalRecord=" + totalRecord +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", startIndex=" + startIndex +
                ", totalPage=" + totalPage +
                ", previousPage=" + previousPage +
                ", nextPage=" + nextPage +
                '}';
    }

    public Page(List<T> list, int totalRecord, int currentPage) {
        this.list = list;
        this.totalRecord = totalRecord;
        this.currentPage = currentPage;
    }
}
