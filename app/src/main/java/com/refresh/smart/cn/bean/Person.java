package com.refresh.smart.cn.bean;

/**
 * @author 张海洋
 * @Date on 2018/08/13.
 * @org 上海相舆科技有限公司
 * @describe
 */


public class Person {
    private String name;
    private String describe;

    public Person(String name, String describe) {
        this.name = name;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
