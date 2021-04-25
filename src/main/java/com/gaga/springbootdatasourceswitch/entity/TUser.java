package com.gaga.springbootdatasourceswitch.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2021-04-22 15:35:50
 */
public class TUser implements Serializable {
    private static final long serialVersionUID = -89216463942594343L;

    private Integer id;

    private String name;

    private Integer age;

    private Date createDate;


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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}