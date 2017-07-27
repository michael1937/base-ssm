package com.kanglefu.modules.demo.model;

import com.kanglefu.modules.base.model.BaseIdStringModel;

import javax.persistence.Table;

/**
 *  演示实体
 * Created by Michael on 2017/7/8.
 */
@Table(name = "x_demo_user")
public class User extends BaseIdStringModel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {}

    public User(String name) {
        this.name = name;
    }
}
