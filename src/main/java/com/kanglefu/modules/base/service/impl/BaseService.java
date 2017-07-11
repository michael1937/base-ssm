package com.kanglefu.modules.base.service.impl;

import com.kanglefu.modules.base.mapper.MyBaseMapper;
import com.kanglefu.modules.base.service.IBaseService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Michael on 2017/7/8.
 */
public abstract class BaseService<T> implements IBaseService<T> {

    @Autowired
    private MyBaseMapper<T> mapper;

    public MyBaseMapper<T> getMapper() {
        return mapper;
    }

    public T getByPK(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public T getOne(T entity) {
        return mapper.selectOne(entity);
    }

    public int getCount(T entity) {
        return mapper.selectCount(entity);
    }

    public int getCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }

    public int save(T entity) {
        return mapper.insert(entity);
    }

    public int saveNotNull(T entity) {
        return mapper.insertSelective(entity);
    }

    public int delete(T entity) {
        return mapper.delete(entity);
    }

    public int deleteByPK(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    public int deleteByExample(Object example) {
        return mapper.deleteByExample(example);
    }

    public int updateByPK(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateByPKNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public int updateByExample(T entity, Object example) {
        return mapper.updateByExample(entity,example);
    }

    public int updateByExampleNotNull(T entity, Object example) {
        return mapper.updateByExampleSelective(entity,example);
    }

    public List<T> getList(T entity) {
        return mapper.select(entity);
    }

    public List<T> getListAll() {
        return mapper.selectAll();
    }

    public List<T> getListByExample(Object example) {
        return mapper.selectByExample(example);
    }

    public List<T> getListByRowBounds(T entity, RowBounds rowBounds) {
        return mapper.selectByRowBounds(entity,rowBounds);
    }

    public List<T> getListByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return mapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public List<T> getByPKS(String keys){
        return mapper.selectByIds(keys);
    }

    public int deleteByPKS(String keys) {
        return mapper.deleteByIds(keys);
    }

    public boolean isExisis(Object key) {
        return mapper.existsWithPrimaryKey(key);
    }
}
