package com.kanglefu.modules.demo.service;

import com.kanglefu.modules.base.service.IBaseService;
import com.kanglefu.modules.demo.model.User;
import com.kanglefu.modules.demo.model.vo.UserVo;

import java.util.List;

/**
 * Created by Michael on 2017/7/8.
 */
public interface IUserService extends IBaseService<User> {

    /**
     *  根据查询条件分页查询(单表查询分页)
     * @param user  条件
     * @param pageNo    页码
     * @param pageSize  每页大小
     * @return 符合条件的UserList
     */
    List<User> getByUser(User user, int pageNo, int pageSize);

    List<UserVo> getUserVoList(User user);
}
