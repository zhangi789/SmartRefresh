package com.refresh.smart.cn.bean;

/**
 * @author 张海洋
 * @Date on 2018/08/13.
 * @org 上海相舆科技有限公司
 * @describe
 */


public class TimeShaftBean {
    private String type;
    private int id;
    private String content;
    private String time;

    public TimeShaftBean(String type, int id, String content, String time) {
        this.type = type;
        this.id = id;
        this.content = content;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
