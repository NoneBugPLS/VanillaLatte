package com.zelin.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zelin.mapper.ClassesMapper;
import com.zelin.mapper.StudentMapper;
import com.zelin.pojo.Student;
import com.zelin.pojo.StudentVo.StudentVo;
import com.zelin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


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

    //2. 分页条件查询
    @Override
    public PageInfo<Student> search(int page, int pageSize, StudentVo vo) {
        //1. 开始分页
        PageHelper.startPage(page,pageSize);
        //2. 开始条件查询
        Example example = new Example(Student.class);
        Example.Criteria criteria = example.createCriteria();
        //3. 添加查询条件
        if (vo != null){
            if (StrUtil.isNotBlank(vo.getSname())){
                criteria.andLike("sname","%" + vo.getSname() + "%");
            }
            if (StrUtil.isNotBlank(vo.getAddr())){
                criteria.andLike("addr","%" + vo.getAddr() + "%");
            }
            if (vo.getCid() != 0){
                criteria.andEqualTo("cid",vo.getCid());
            }
        }
        List<Student> students = studentMapper.selectByExample(example);
        //4. 给学生添加班级信息
        for (Student stud : students) {
            stud.setCname(classesMapper.selectByPrimaryKey(stud.getCid()).getCname());
        }
        //5. 返回pageinfo
        return new PageInfo<>(students);

    }

    //添加
    @Override
    public void add(Student student) {
        studentMapper.insert(student);
    }

    //修改
    @Override
    public void update(Student student) {
        studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            studentMapper.deleteByPrimaryKey(id);
        }
    }


}
