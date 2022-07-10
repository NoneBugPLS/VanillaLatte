package com.zelin.factory;

import com.zelin.pojo.Student;

/**
 * ------------------------------
 * 功能：通过静态工厂方法获取对象
 * 作者：WF
 * 微信：hbxfwf13590332912
 * 创建时间：2021/11/9-10:13
 * ------------------------------
 */
public class StudentFactory {

    //1. 静态工厂方法获取对象
    public static Student getInstance(){
        return new Student();
    }
}
