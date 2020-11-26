package com.mybatis.test;

import com.dao.PersonDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class testOne {
    public static void main(String[] args) {
        try {
            InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf =
                    new SqlSessionFactoryBuilder().build(config);
            SqlSession ss = ssf.openSession();
            PersonDao personDao = ss.getMapper(PersonDao.class);
            TestOneToOne one = new TestOneToOne();
            one.setPersonDao(personDao);
            one.test();
            ss.commit();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}