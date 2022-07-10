package com.zelin.test;

import com.zelin.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 类名：
 * 作者：Lun
 * 功能：
 * 时间：2021/11/14 17:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-02.xml")
public class TestAOP2 {
    @Autowired
    private UserDao userDao;

    //使用xml方式进行动态代理
    @Test
    public void test01(){
        userDao.add();
        System.out.println("-------------------------");
    }
}
