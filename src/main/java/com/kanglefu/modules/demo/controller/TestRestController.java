package com.kanglefu.modules.demo.controller;

import com.kanglefu.modules.base.controller.BaseController;
import com.kanglefu.modules.base.controller.result.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michael on 2017/7/8.
 *  RESTFUL 测试
 */
@RestController
@RequestMapping(value = "/test")
public class TestRestController extends BaseController {

    /**
     *  get post put delete 测试
     *  好像都可以用
     */
    
    @RequestMapping(value = "/method/{id}", method = RequestMethod.GET)
    public Result testGet(@PathVariable("id") String id, HttpServletResponse response) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("GET_value",id);
        map.put("abc",id);
        response.setContentType("text/event-stream");
        return Result.success().setData(map);
    }

    
    @RequestMapping(value = "/method/{id}", method = RequestMethod.POST)
    public Result testPost(@PathVariable("id") String id) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("POST_value",id);
        return Result.success().setData(map);
    }

    
    @RequestMapping(value = "/method/{id}", method = RequestMethod.PUT)
    public Result testPut(@PathVariable("id") String id) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("PUT_value",id);
        return Result.success().setData(map);
    }

    
    @RequestMapping(value = "/method/{id}", method = RequestMethod.DELETE)
    public Result testDELETE(@PathVariable("id") String id) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("DELETE_value",id);
        return Result.success().setData(map);
    }
}
