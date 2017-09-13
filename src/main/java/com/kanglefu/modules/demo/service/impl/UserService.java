package com.kanglefu.modules.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.kanglefu.modules.base.service.impl.BaseService;
import com.kanglefu.modules.demo.mapper.UserMapper;
import com.kanglefu.modules.demo.model.User;
import com.kanglefu.modules.demo.model.vo.UserVo;
import com.kanglefu.modules.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * Created by Michael on 2017/7/8
 */
@Service
@Transactional(rollbackFor = Exception.class,readOnly = true)
public class UserService extends BaseService<User> implements IUserService {


    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserMapper userMapper;

    /**
     *  缓存示例
     */
    @Cacheable(value = {"test"},key = "'currentUser:user_' + #user.name",condition = "null != #user.name")
    public List<User> getByUser(User user, int pageNo, int pageSize) {

        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(user.getName())) {
            criteria.andLike("name", "%" + user.getName() + "%");
        }
        //分页查询
        PageHelper.startPage(pageNo, pageSize);

        return getListByExample(example);
    }

    public List<UserVo> getUserVoList(User user) {
        return userMapper.getUserVoList(user);
    }
}
