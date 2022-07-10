package com.zelin.service.impl;

import com.zelin.mapper.ClassesMapper;
import com.zelin.pojo.Classes;
import com.zelin.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public List<Classes> findAll() {
        //找到班级
        List<Classes> classes = classesMapper.selectByExample(null);
        //返回值
        return classes;
    }
}
