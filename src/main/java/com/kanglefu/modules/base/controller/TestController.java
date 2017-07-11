package com.kanglefu.modules.base.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Michael on 2017/7/8.
 *  RESTFUL 测试
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String testGet(@PathVariable("id") String id) {
        return "{\"GET_value\":\" " + id + "\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String testPost(@PathVariable("id") String id) {
        return "{\"POST_value\":\" " + id + "\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String testPut(@PathVariable("id") String id) {
        return "{\"PUT_value\":\" " + id + "\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String testDELETE(@PathVariable("id") String id) {
        return "{\"DELETE_value\":\" " + id + "\"}";
    }
}
