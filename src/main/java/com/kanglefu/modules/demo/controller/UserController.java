package com.kanglefu.modules.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kanglefu.modules.base.controller.result.Result;
import com.kanglefu.modules.demo.model.User;
import com.kanglefu.modules.demo.model.vo.UserVo;
import com.kanglefu.modules.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/test/{name}")
    public Result test(@PathVariable("name") String name){
        User user = new User(name);
        userService.save(user);

        return Result.success().setData(user);
    }

    /**
     *  分页测试1
     */
    @RequestMapping("getUserPage")
    public Result getUserPage(User user, @RequestParam int pageNo, @RequestParam int pageSize) {
        List<User> userList = userService.getByUser(user,pageNo,pageSize);
        PageInfo pageInfo = new PageInfo<User>(userList,5);

        return Result.success().setData(pageInfo);
    }

    /**
     *  分页测试2
     */
    @RequestMapping("getUserVoPage")
    public Result getUserVoPage(User user,@RequestParam int pageNo, @RequestParam int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<UserVo> voList = userService.getUserVoList(user);

        return Result.success().setData(new PageInfo<UserVo>(voList,5));
    }

    public Result testKeys(){
        String keys = "'14a0a74663c211e7baac4c34882558f4','1594984463b811e7baac4c34882558f4','1db37a6863c911e7baac4c34882558f4'";
        userService.deleteByPKS(keys);
        return Result.success().setData(userService.getByPKS(keys));
    }
}
