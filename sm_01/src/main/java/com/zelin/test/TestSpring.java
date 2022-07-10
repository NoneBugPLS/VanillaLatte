package com.zelin.test;

import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ------------------------------
 * 功能：
 * 作者：WF
 * 微信：hbxfwf13590332912
 * 创建时间：2021/11/9-10:01
 * ------------------------------
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-01.xml")
public class TestSpring {
    private ApplicationContext ac;
    @Before
    public void init(){
        ac = new ClassPathXmlApplicationContext("spring/spring-01.xml");
    }

    //1. 构造对象的方式一：通过无参构造方法获取
    @Test
    public void test01(){
        //1.1 直接通过配置文件的
        Object stud01 = ac.getBean("stud01");
        System.out.println("stud01 = " + stud01);
    }
    //2. 构造对象的方法二：通过静态工厂方法获聂
    @Test
    public void test02(){
        Object stud02 = ac.getBean("stud02");
        System.out.println("stud02 = " + stud02);
    }
    //3. 构造对象的方法三：通过工厂方法获取
    @Test
    public void test03(){
        Object stud03 = ac.getBean("stud03");
        System.out.println("stud03 = " + stud03);
    }

    //4. 为对象赋值：方法一：使用setter方法赋值
    @Test
    public void test04(){
        Object stud11 = ac.getBean("stud11");
        System.out.println("stud11 = " + stud11);
    }

    //5. 为对象赋值：方法二：使用构造方法赋值
    @Test
    public void test05(){
        Object stud12 = ac.getBean("stud12");
        System.out.println("stud12 = " + stud12);
    }

    //6. 为对象赋值：方法三：使用p名称空间赋值
    @Test
    public void test06(){
        Object stud13 = ac.getBean("stud13");
        System.out.println("stud13 = " + stud13);
    }

    //7. 复杂属性的贬值
    @Test

    public void test07(){
        Object cb = ac.getBean("cb");
        System.out.println("cb = " + cb);
    }
}
