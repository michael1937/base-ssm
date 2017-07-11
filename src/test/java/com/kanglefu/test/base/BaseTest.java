package com.kanglefu.test.base;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Michael on 2017/7/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring/*.xml"
})
@WebAppConfiguration
public class BaseTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void demoget() throws Exception {
        mvc.perform(get("/test"))
                .andExpect(status().isOk())
                .andDo(print());
//                .andExpect(model().attribute("message", "Hello Reader!"))
//                .andExpect(view().name("helloReader"));
    }

    private ResultHandler print() {
        return null;
    }

    private RequestBuilder get(String s) {
        return null;

    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
