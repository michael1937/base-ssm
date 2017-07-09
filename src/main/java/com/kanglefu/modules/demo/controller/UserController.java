package com.kanglefu.modules.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kanglefu.modules.demo.model.User;
import com.kanglefu.modules.demo.model.vo.UserVo;
import com.kanglefu.modules.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Michael on 2017/7/8.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("test")
    public User test(){
        User user = new User("abcd");
        userService.save(user);

        return user;
    }

    /**
     *  分页测试1
     */
    @RequestMapping("getUserPage")
    public PageInfo getUserPage(User user,int pageNo,int pageSize) {
        List<User> userList = userService.getByUser(user,pageNo,pageSize);
        PageInfo pageInfo = new PageInfo<User>(userList,5);

        return pageInfo;
    }

    /**
     *  分页测试2
     */
    @RequestMapping("getUserVoPage")
    public PageInfo getUserVoPage(User user,int pageNo,int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<UserVo> voList = userService.getUserVoList(user);
        return new PageInfo<UserVo>(voList,5);
    }

    @RequestMapping("testKeys")
    public List<User> testKeys(){
        String keys = "'14a0a74663c211e7baac4c34882558f4','1594984463b811e7baac4c34882558f4','1db37a6863c911e7baac4c34882558f4'";
        userService.deleteByPKS(keys);
        return userService.getByPKS(keys);
    }
}
