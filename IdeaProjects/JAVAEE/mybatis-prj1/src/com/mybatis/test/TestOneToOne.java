package com.mybatis.test;

import com.dao.PersonDao;
import com.mybatis.po.Person;
import com.pojo.SelectPersonById;

public class TestOneToOne {
    private  PersonDao personDao;

    public void test() {
        Person p1 = personDao.selectPersonById1(1);
        System.out.println(p1);
        System.out.println("==========================");
        Person p2 = personDao.selectPersonById2(1);
        System.out.println(p2);
        System.out.println("==========================");
        SelectPersonById p3 = personDao.selectPersonById3(1);
        System.out.println(p3);
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}