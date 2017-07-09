package com.kanglefu.modules.base.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Michael on 2017/7/8.
 */
public abstract class BaseIdModel<T,PK extends Serializable> {

    /**
     *  表主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected PK id;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }
}
