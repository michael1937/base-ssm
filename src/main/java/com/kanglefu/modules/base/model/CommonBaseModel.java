package com.kanglefu.modules.base.model;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Michael on 2017/7/8.
 * String 做主键 主键名为id
 * 另外包含有创建信息 删除信息 删除状态信息
 */
public abstract class CommonBaseModel extends BaseIdStringModel implements Serializable {

    /**
     * 创建人
     */
    @Column(name = "creator")
    private String creator;

    /**
     * 创建人ID
     */
    @Column(name = "creator_id")
    private String creatorId;

    /**
     * 创建时间 yyyy-MM-dd HH:mm:ss
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 删除人
     */
    @Column(name = "deletor")
    private String deletor;

    /**
     * 删除人ID
     */
    @Column(name = "deletor_id")
    private String deletorId;

    /**
     * 删除时间 yyyy-MM-dd HH:mm:ss
     */
    @Column(name = "delete_time")
    private Date deleteTime;

    /**
     * 当前数据是否已删除 1. 是 0. 否
     */
    @Column(name = "is_deleted")
    private int isDeleted;


    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDeletor() {
        return deletor;
    }

    public void setDeletor(String deletor) {
        this.deletor = deletor;
    }

    public String getDeletorId() {
        return deletorId;
    }

    public void setDeletorId(String deletorId) {
        this.deletorId = deletorId;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
