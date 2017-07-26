package com.kanglefu.modules.base.controller;

import com.kanglefu.modules.base.controller.result.Result;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Michael on 2017/7/8.
 *  RESTFUL 测试
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    Logger logger = Logger.getLogger(TestController.class);

    @RequestMapping(value = "/msg")
    public void testPushMsg(HttpServletRequest request,HttpServletResponse response) {
        OutputStream bos = null;
        try {
            String data1 =" www.imiansha.com爱面纱网站上线了\n\n";
            String data2 = " www.imiansha.com爱面纱网站正在招兵买马\n\n";
            //声明浏览器在连接断开之后进行再次连接之前的等待时间 10秒
            String retry = "retry:"+5000+"\n\n";
            //事件的标识符
            String id="id:100\n\n";
            //最后一次接收到的事件的标识符
            String last = request.getHeader("Last-Event-ID");
            logger.info(last);
            bos = new BufferedOutputStream(response.getOutputStream());

            response.setContentType("text/event-stream");//记得要设置哦
            response.setContentType("no-cache");

            bos.write(data1.getBytes());
            bos.write(data2.getBytes());
            bos.write(retry.getBytes());
            bos.write(id.getBytes());
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  get post put delete 测试
     *  好像都可以用
     */
    @RequestMapping(value = "/func/{id}", method = RequestMethod.GET)
    public Result testGet(@PathVariable("id") String id, HttpServletResponse response) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("GET_value",id);
        map.put("abc",id);
        response.setContentType("text/event-stream");
        return Result.success().setData(map);
    }

    @RequestMapping(value = "/func/{id}", method = RequestMethod.POST)
    public Result testPost(@PathVariable("id") String id) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("POST_value",id);
        return Result.success().setData(map);
    }

    @RequestMapping(value = "/func/{id}", method = RequestMethod.PUT)
    public Result testPut(@PathVariable("id") String id) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("PUT_value",id);
        return Result.success().setData(map);
    }

    @RequestMapping(value = "/func/{id}", method = RequestMethod.DELETE)
    public Result testDELETE(@PathVariable("id") String id) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("DELETE_value",id);
        return Result.success().setData(map);
    }
}
