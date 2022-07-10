package com.zelin.factory;

import com.zelin.pojo.Student;

/**
 * ------------------------------
 * 功能：工厂方法创建对象
 * 作者：WF
 * 微信：hbxfwf13590332912
 * 创建时间：2021/11/9-10:16
 * ------------------------------
 */
public class StudentFactory2 {
    public Student getStudent(){
        return new Student();
    }
}
