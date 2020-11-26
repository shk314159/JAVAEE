package com.mybatis.test;
import com.mybatis.po.MyUser;
import com.pojo.MapUser;
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
            InputStream config= Resources.
                    getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory ssf=
                    new SqlSessionFactoryBuilder().build(config);
            SqlSession ss=ssf.openSession();
            List<MapUser> l = ss.selectList("com.mybatis.mapper.UserMapper.selectResultMap");
            for(MapUser x : l) {
                System.out.println(x);
            }
            int num;
            MapUser insertmu = new MapUser(9, "YYDS", "未知");

            num = ss.insert("com.mybatis.mapper.UserMapper.insertResultMap", insertmu);
            System.out.println("插入影响了" + num + "行");

            MapUser updatemu = new MapUser(4, "一路向北", "不明");
            num = ss.update("com.mybatis.mapper.UserMapper.updateResultMap", updatemu);
            System.out.println("修改影响了" + num + "行");
            MapUser deletemu = new MapUser();
            deletemu.setM_uid(7);
            num = ss.delete("com.mybatis.mapper.UserMapper.deleteResultMap", deletemu);
            System.out.println("删除影响了" + num + "行");
            ss.commit();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}