package com.zelin.web.controller;

import com.zelin.pojo.R;
import com.zelin.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 类名：
 * 作者：Lun
 * 功能：
 * 时间：2021/11/14 17:31
 */
@Controller
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    //1. 查询所有班级
    @GetMapping("/list")
    @ResponseBody
    public R list(){
        return R.ok().data("list",classesService.findAll());
    }
}
