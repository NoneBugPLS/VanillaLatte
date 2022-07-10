package com.zelin.dao.dynamicproxy;

import com.zelin.dao.UserDao;
import com.zelin.dao.impl.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 类名：
 * 作者：Lun
 * 功能：
 * 时间：2021/11/14 17:31
 */
public class JDKProxyUserImpl implements InvocationHandler {
    //1. 得到目标对象
    private UserDao userDao;
    public JDKProxyUserImpl(){
        userDao = new UserDaoImpl();
    }
    //2. 使用proxy生成代理对象
    public UserDao createProxy(){
        // 参数1：代表目标对象的类加载器    getclasserholder
        // 参数2：代表目标对象实现的接口的类型   getinterfcae
        // 参数3：代表实现了InvocationHandler接口的对象    这已经实现了  就是this
        return (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),userDao.getClass().getInterfaces(),this);
    }
    //3. 通过反射调用目标方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //3.1 如果调用的是query()方法，就进行安全性检查
        if (method.getName().equals("query")){
            //method.getName(): 代表得到目标对象的方法名
            checkSecurity();
        }
        return method.invoke(userDao,args);
        //参数1：代表调用方法的哪个目标对象 参数2：代表为方法传递的参数
    }

    //4. 检查安全性
    private void checkSecurity(){
        System.out.println("JDKProxyUserImpl-->安全性检查.");
    }
}
