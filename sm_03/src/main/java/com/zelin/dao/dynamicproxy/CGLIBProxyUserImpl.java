package com.zelin.dao.dynamicproxy;


import com.zelin.dao.impl.UserDaoImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 类名：CGLIB动态代理
 * 作者：Lun
 * 功能：
 * 时间：2021/11/14 17:31
 */
public class CGLIBProxyUserImpl implements MethodInterceptor {
    //1. 创建代理对象
    public UserDaoImpl createProxy(){
        //1.1 构建一个enhancer对象
        Enhancer enhancer = new Enhancer();
        //1.2 指定enhancer的父类
        enhancer.setSuperclass(UserDaoImpl.class);
        //1.3 指定回调
        enhancer.setCallback(this);
        //1.4 创建代理对象
        Object o = enhancer.create();
        //1.5 返回
        return (UserDaoImpl) o;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("query")){
            checkSecurity();
        }
        return methodProxy.invokeSuper(o,objects);   //代理类对应的方法调用父类方法
    }

    //安全性检查
    private void checkSecurity(){
        System.out.println("CGLIB----》安全检查");
    }
}
