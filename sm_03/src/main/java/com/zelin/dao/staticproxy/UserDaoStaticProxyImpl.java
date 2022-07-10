package com.zelin.dao.staticproxy;

import com.zelin.dao.UserDao;
import com.zelin.dao.impl.UserDaoImpl;

/**
 * 类名：
 * 作者：Lun
 * 功能：
 * 时间：2021/11/14 17:31
 */
public class UserDaoStaticProxyImpl implements UserDao {
    //1. 引入userdao
    private UserDao userDao;

    public UserDaoStaticProxyImpl(){
        userDao = new UserDaoImpl();
    }
    @Override
    public void add() {
        userDao.add();
    }

    @Override
    public void query() {
        checkSecurity();
        userDao.query();
    }

    @Override
    public void update() {
        userDao.update();
    }

    @Override
    public void delete() {
        userDao.delete();
    }

    //安全性检查
    private void checkSecurity(){
        System.out.println("进行安全性检查");
    }
}
