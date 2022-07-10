package com.zelin.controller;

import com.zelin.service.ClassesSercice;
import com.zelin.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名：
 * 作者：Lun
 * 功能：
 * 时间：2021/11/14 17:31
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassesService classesSercice
}
