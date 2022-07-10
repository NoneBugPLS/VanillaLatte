package com.zelin.web.controller;

import com.zelin.pojo.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 类名：
 * 作者：Lun
 * 功能：
 * 时间：2021/11/14 17:31
 */
@Controller
@RequestMapping("/user")
public class UserController {
    //1. 用户登录
    @PostMapping("/login")
    @ResponseBody
    public R login(){
        return R.ok().data("token",1);
    }

    //2. 登录成功后得到用户信息
    @GetMapping("/info")
    @ResponseBody
    public R info(){
        return R.ok().data("name","admin")
                .data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

    //3. 注销功能
    @GetMapping("/logout")
    @ResponseBody
    public R logout(){
        return R.ok();
    }
}
