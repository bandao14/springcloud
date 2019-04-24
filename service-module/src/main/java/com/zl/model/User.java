package com.zl.model;


import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class User implements Serializable {
    //private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String sex;
    private JSONObject info;
    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public JSONObject getInfo() {
        return info;
    }

    public void setInfo(JSONObject info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", info=" + info +
                '}';
    }
}
