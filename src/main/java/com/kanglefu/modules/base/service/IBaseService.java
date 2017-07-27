package com.kanglefu.modules.base.service;

import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by Michael on 2017/7/8.
 *  基础Service 接口 基于 MyBaseMapper
 */
public interface IBaseService<T> {

    /**
     * 根据主键值查询对象
     *
     * @param key 主键值
     * @return 对应实体
     */
    T getByPK(Object key);

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果会抛出异常，查询条件使用等号
     */
    T getOne(T entity);

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     */
    int getCount(T entity);

    /**
     * 根据Example条件进行查询总数
     *
     * @param example 查询条件
     * @see tk.mybatis.mapper.entity.Example
     */
    int getCountByExample(Object example);

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     */
    int save(T entity);

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     */
    int saveNotNull(T entity);

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     */
    int delete(T entity);

    /**
     * 根据主键值删除表中的实体数据
     *
     * @param key 主键值
     */
    int deleteByPK(Object key);

    /**
     * 根据Example条件删除数据
     *
     * @see tk.mybatis.mapper.entity.Example
     */
    int deleteByExample(Object example);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     */
    int updateByPK(T entity);

    /**
     * 根据主键更新属性不为null的值
     */
    int updateByPKNotNull(T entity);

    /**
     * 根据Example条件更新实体包含的全部属性，null值会被更新
     *
     * @see tk.mybatis.mapper.entity.Example
     */
    int updateByExample(T entity, Object example);

    /**
     * 根据Example条件更新实体包含的非NULL属性值
     *
     * @see tk.mybatis.mapper.entity.Example
     */
    int updateByExampleNotNull(T entity, Object example);

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     */
    List<T> getList(T entity);

    /**
     * 查询全部结果
     */
    List<T> getListAll();

    /**
     * 根据Example条件进行查询
     *
     * @see tk.mybatis.mapper.entity.Example
     */
    List<T> getListByExample(Object example);

    /**
     * 根据实体属性和RowBounds进行分页查询
     */
    List<T> getListByRowBounds(T entity, RowBounds rowBounds);

    /**
     * 根据example条件和RowBounds进行分页查询
     *
     * @see tk.mybatis.mapper.entity.Example
     */
    List<T> getListByExampleAndRowBounds(Object example, RowBounds rowBounds);

    /**
     * 根据主键字符串进行查询，类中只有存在一个带有@Id注解的字段
     *
     * @param keys "1,2,3,4"
     *             如果主键为varchar 参数大致如下:
     *             "'key1','key2','key3'..." 里面的值会生成 id IN ($keys)
     */
    List<T> getByPKS(String keys);

    /**
     * 根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段
     *
     * @param keys "1,2,3,4"
     *             如果主键为varchar 参数大致如下:
     *             "'key1','key2','key3'..." 里面的值会生成 id IN ($keys)
     */
    int deleteByPKS(String keys);

    /**
     * 根据主键字段查询总数，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @return 查询总数是否 > 0
     */
    boolean isExisis(Object key);
}
