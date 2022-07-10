package com.zelin.test;

import com.zelin.dao.UserDao;
import com.zelin.dao.dynamicproxy.CGLIBProxyUserImpl;
import com.zelin.dao.dynamicproxy.JDKProxyUserImpl;
import com.zelin.dao.impl.UserDaoImpl;
import com.zelin.dao.staticproxy.UserDaoStaticProxyImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * 类名：
 * 作者：Lun
 * 功能：
 * 时间：2021/11/14 17:31
 */
public class TestUserDao {
    private UserDao userDao;

    private JDKProxyUserImpl jdkProxyUser;

    private CGLIBProxyUserImpl cglibProxyUser;
    @Before

    public void init(){
        //静态代理对象
        userDao = new UserDaoStaticProxyImpl();
        //得到JDKProxyUser对象
        jdkProxyUser = new JDKProxyUserImpl();
        //得到CGLIBUserImpl对象
        cglibProxyUser = new CGLIBProxyUserImpl();
    }



    @Test
    //静态代理方法
    public void test01(){
//        userDao.add();
        userDao.query();
    }

    @Test
    //动态代理
    public void test02(){
        //利用JDK得到动态代理对象
        UserDao proxy = jdkProxyUser.createProxy();
        //进行方法调用：
        proxy.add();
        System.out.println("==========");
        proxy.query();
    }

    @Test
    public void test03(){
        //1. 得到代理对象
        UserDaoImpl proxy = cglibProxyUser.createProxy();
        //2. 调用方法
        proxy.add();
        System.out.println("----------------");
        proxy.query();
    }
}
