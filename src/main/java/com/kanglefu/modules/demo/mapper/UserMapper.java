package com.kanglefu.modules.demo.mapper;

import com.kanglefu.modules.base.mapper.MyBaseMapper;
import com.kanglefu.modules.demo.model.User;
import com.kanglefu.modules.demo.model.vo.UserVo;

import java.util.List;

/**
 * Created by Michael on 2017/7/8.
 */
public interface UserMapper extends MyBaseMapper<User> {

    List<UserVo> getUserVoListI(User user);
}
