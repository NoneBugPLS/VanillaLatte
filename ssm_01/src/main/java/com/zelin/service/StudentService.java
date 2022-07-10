package com.zelin.service;

import com.github.pagehelper.PageInfo;
import com.zelin.pojo.Student;
import com.zelin.pojo.StudentVo.StudentVo;
import org.springframework.stereotype.Service;

import java.util.List;



public interface StudentService {
    List<Student> findAll();

    PageInfo<Student> search(int page, int pageSize, StudentVo vo);

    void add(Student student);

    void update(Student student);

    void delete(Integer[] ids);
}
