package com.zelin.service;

import com.github.pagehelper.PageInfo;
import com.zelin.pojo.Student;
import com.zelin.pojo.StudentVo.StudentVo;

import java.util.List;

/**
 * Created by WF on 2021/11/9 10:58
 */
public interface StudentService {
    List<Student> findAll();

    PageInfo<Student> search(int page, int pageSize, StudentVo studentVo);

    void update(Student student);

    void insert(Student student);

    void delete(String id);
}
