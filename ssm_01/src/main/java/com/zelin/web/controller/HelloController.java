package com.zelin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类名：
 * 作者：Lun
 * 功能：
 * 时间：2021/11/14 17:31
 */
@Controller
@RequestMapping
public class HelloController {
    @RequestMapping("/hello")
    public ModelAndView hello(){
        return new ModelAndView("hello","username","大傻逼");
    }
}
