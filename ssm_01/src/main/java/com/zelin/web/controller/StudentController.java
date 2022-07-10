package com.zelin.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zelin.pojo.R;
import com.zelin.pojo.Student;
import com.zelin.pojo.StudentVo.StudentVo;
import com.zelin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类名：
 * 作者：Lun
 * 功能：
 * 时间：2021/11/14 17:31
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //1. 列表学生
    @RequestMapping("/list")
    @ResponseBody
    public R list(){
        //1. 查询所有学生
        List<Student> studentList = studentService.findAll();
        //2. 放到R对象中并返回
        return R.ok().data("list",studentList);
    }

    //2. 分页带条件查询
    @RequestMapping("/search")
    @ResponseBody
    public R search(int page, int pageSize, @RequestBody(required = false) StudentVo vo){
        //1. 得到学生列表
        PageInfo<Student> students = studentService.search(page,pageSize,vo);
        //2. 返回
        return R.ok().data("total",students.getTotal()).data("row",students.getList());
    }

    //3. 添加学生
    @PostMapping("/add")
    @ResponseBody
    public R add(@RequestBody Student student){
        studentService.add(student);
        return R.ok();
    }

    //3. 修改学生
    @PostMapping("/update")
    @ResponseBody
    public R update(@RequestBody Student student){
        studentService.update(student);
        return R.ok();
    }

    //4。 删除
    @GetMapping("delete")
    @ResponseBody
    public R delete(Integer[] ids){
        studentService.delete(ids);
        return R.ok();
    }
}

