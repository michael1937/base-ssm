package com.kanglefu.modules.demo.controller;

import com.kanglefu.test.base.BaseControllerTest;
import org.junit.Test;

/**
 * Created by Michael on 2017/7/11.
 */
public class TestControllerTest extends BaseControllerTest {

    @Test
    public void testRestfulGet() throws Exception {
        String json = "{\"GET_value\":\"123\"}";
        String url = "/test/123";
        testGetJson(json,url);
    }

    @Test
    public void testRestfulPost() throws Exception {
        String json = "{\"POST_value\":\"123\"}";
        String url = "/test/123";
        testPostJson(json,url);
    }

    @Test
    public void testRestfulPut() throws Exception {
        String json = "{\"PUT_value\":\"123\"}";
        String url = "/test/123";
        testPutJson(json,url);
    }

    @Test
    public void testRestfulDelete() throws Exception {
        String json = "{\"DELETE_value\":\"123\"}";
        String url = "/test/123";
        testDeleteJson(json,url);
    }
}
