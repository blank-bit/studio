package com.wang.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-12-16 15:34:58
 */
public class User implements Serializable {
    private static final long serialVersionUID = 823226418780621345L;

    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 爱好
     */
    private String hobby;
    /**
     * 年龄
     */
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}