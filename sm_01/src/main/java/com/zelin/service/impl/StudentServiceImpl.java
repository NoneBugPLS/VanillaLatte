package com.zelin.service.impl;

import com.zelin.mapper.ClassesMapper;
import com.zelin.mapper.StudentMapper;
import com.zelin.pojo.Student;
import com.zelin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ------------------------------
 * 功能：
 * 作者：WF
 * 微信：hbxfwf13590332912
 * 创建时间：2021/11/9-11:00
 * ------------------------------
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassesMapper classesMapper;
    //1. 列表查询学生
    @Override
    public List<Student> findAll() {
        //1.1 查询所有学生
        List<Student> students = studentMapper.selectByExample(null);
        //1.2 为每个学生添加班级名称
        for (Student student : students) {
         student.setCname(classesMapper.selectByPrimaryKey(student.getCid()).getCname());
        }
        //1.3 返回
        return students;
    }
}
