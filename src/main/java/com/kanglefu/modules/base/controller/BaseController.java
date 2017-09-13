package com.kanglefu.modules.base.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Michael on 2017/7/18.
 * 基础类
 */
public abstract class BaseController {

    protected Logger logger = Logger.getLogger(getClass());

}
