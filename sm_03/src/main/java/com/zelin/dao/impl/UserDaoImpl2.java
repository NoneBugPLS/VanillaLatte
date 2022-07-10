package com.zelin.dao.impl;

import com.zelin.dao.UserDao;
import org.springframework.stereotype.Component;

/**
 * 类名：
 * 作者：Lun
 * 功能： 目标对象
 * 时间：2021/11/14 17:31
 */

@Component
public class UserDaoImpl2 implements UserDao {
    @Override
    public void add() {

        System.out.println("UserDaoImpl2-------->add");
    }

    @Override
    public void query() {
        System.out.println("query");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }
}
