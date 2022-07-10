package com.zelin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zelin.mapper.ClassesMapper;
import com.zelin.mapper.StudentMapper;
import com.zelin.pojo.Student;
import com.zelin.pojo.StudentExample;
import com.zelin.pojo.StudentVo.StudentVo;
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

    @Override
    public PageInfo<Student> search(int page, int pageSize, StudentVo studentVo) {
        //2.1 开始分页
        PageHelper.startPage(page,pageSize);
        //2.2 开始查询
        //2.2.1 定义查询实例
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        //2.2.2 为criteria对象添加查询条件
        if(studentVo != null){
            if(StrUtil.isNotBlank(studentVo.getSname())){
                criteria.andSnameLike("%" + studentVo.getSname() + "%");
            }
            if(StrUtil.isNotBlank(studentVo.getAddr())){
                criteria.andAddrLike("%" + studentVo.getAddr()+ "%");
            }
            if(studentVo.getCid() != 0){
                criteria.andCidEqualTo(studentVo.getCid());
            }
        }
        //2.2.3 开始条件查询
        List<Student> students = studentMapper.selectByExample(example);
        //2.2.4 将得到的学生绑定班级名称
        for (Student stud : students) {
            stud.setCname(classesMapper.selectByPrimaryKey(stud.getCid()).getCname());
        }
        //2.3 转换为PageInfo对象并返回
        return new PageInfo<>(students);
    }

    //修改学生
    @Override
    public void update(Student student) {
        studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void delete(String id) {
        studentMapper.deleteByPrimaryKey(new Integer(id));
    }

}
