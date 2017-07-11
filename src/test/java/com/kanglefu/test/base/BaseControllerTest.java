package com.kanglefu.test.base;

import org.junit.Before;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 *  Created by Michael on 2017/7/11.
 */
public class BaseControllerTest extends BaseTest{

    private MockMvc mvc;

    @Before
    public void initMockMvc() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    public void testGetJson(String jsonResult,String url,Object... uriVars) throws  Exception {
        mvc.perform(MockMvcRequestBuilders.get(url,uriVars))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResult));
    }
    
    public void testPostJson(String jsonResult,String url,Object... uriVars) throws  Exception {
        mvc.perform(MockMvcRequestBuilders.post(url,uriVars))
                .andExpect(status().isOk())
//                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResult));
    }
    
    public void testPutJson(String jsonResult,String url,Object... uriVars) throws  Exception {
        mvc.perform(MockMvcRequestBuilders.put(url,uriVars))
                .andExpect(status().isOk())
//                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResult));
    }
    
    public void testDeleteJson(String jsonResult,String url,Object... uriVars) throws  Exception {
        mvc.perform(MockMvcRequestBuilders.delete(url,uriVars))
                .andExpect(status().isOk())
//                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResult));
    }
}
