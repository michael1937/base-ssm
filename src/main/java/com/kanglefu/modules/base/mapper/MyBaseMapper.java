package com.kanglefu.modules.base.mapper;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by Michael on 2017/7/8.
 * 基础Mapper
 */
public interface MyBaseMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {
}
