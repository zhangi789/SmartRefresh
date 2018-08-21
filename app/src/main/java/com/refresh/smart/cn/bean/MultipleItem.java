package com.refresh.smart.cn.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author 张海洋
 * @Date on 2018/08/13.
 * @org 上海相舆科技有限公司
 * @describe
 */


public class MultipleItem implements MultiItemEntity {
    public static final int START = 1;
    public static final int MIDDLE = 2;
    public static final int END = 3;

    private int itemType;
    private int id;
    private String content;
    private String time;

    public MultipleItem(int itemType, int id, String content, String time) {
        this.itemType = itemType;
        this.id = id;
        this.content = content;
        this.time = time;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
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
