package com.kanglefu.modules.demo.model;

import com.kanglefu.modules.base.model.BaseIdModel;

import javax.persistence.Table;

/**
 * Created by Michael on 2017/7/8.
 */
@Table(name = "m_user")
public class User extends BaseIdModel<User, String> {

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
