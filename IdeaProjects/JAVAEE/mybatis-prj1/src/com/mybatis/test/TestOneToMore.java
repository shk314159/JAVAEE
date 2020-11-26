package com.mybatis.test;

import com.dao.UserDao;
import com.mybatis.po.MyUser;
import com.pojo.SelectUserOrdersById;

import java.util.List;

public class TestOneToMore {
    private UserDao userDao;
    public void test() {
        MyUser user1 = userDao.selectUserOrdersById1(1);
        System.out.println(user1);
        System.out.println("==========================");
        MyUser user2 = userDao.selectUserOrdersById2(1);
        System.out.println(user2);
        System.out.println("==========================");
        List<SelectUserOrdersById> user3 = userDao.selectUserOrdersById3(1);
        for(SelectUserOrdersById x : user3) {
            System.out.println(x);
        }
        System.out.println("==========================");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}