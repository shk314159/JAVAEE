package com.mybatis.test;

import com.mybatis.po.MyUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args){
        try {
            InputStream config= Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf=
                    new SqlSessionFactoryBuilder().build(config);
            SqlSession ss=ssf.openSession();
//查询一个用户
            MyUser mu = ss.selectOne("com.mybatis.mapper.UserMapper.selectUserById", 1);
            System.out.println(mu);
//添加一个用户
            MyUser addmu = new MyUser();
            addmu.setUname("张三");
            addmu.setUsex("男");
            addmu.setUid(7);
            ss.insert("com.mybatis.mapper.UserMapper.addUser",addmu);
//修改一个用户
            MyUser updatemu = new MyUser(6, "HJYtql", "男");
            ss.update("com.mybatis.mapper.UserMapper.updateUser", updatemu);
//删除一个用户
            MyUser deletemu = new MyUser();
            deletemu.setUid(5);
            ss.delete("com.mybatis.mapper.UserMapper.deleteUser", deletemu);
//查询所有用户
            List<MyUser> list = ss.selectList("com.mybatis.mapper.UserMapper.selectAllUser");

            for(int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
            ss.commit();
            ss.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}