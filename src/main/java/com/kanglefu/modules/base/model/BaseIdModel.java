package com.kanglefu.modules.base.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Michael on 2017/7/8.
 *  主键名为ID
 */
public abstract class BaseIdModel<PK extends Serializable> implements Serializable {

    private static final long serialVersionUID = 2024722515392807245L;

    @Transient
    protected Logger logger = Logger.getLogger(getClass());

    /**
     * 表主键
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

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (Exception e) {
            logger.error("Entity 解析为 JSON 串出错..." + this, e);
            return null;
        }
    }
}
