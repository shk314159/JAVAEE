package com.dao;
import java.util.List;
import java.util.Map;

import com.pojo.SelectUserOrdersById;
import org.apache.ibatis.annotations.Mapper;
import com.mybatis.po.MyUser;
@Mapper
public interface UserDao {
    public MyUser SelectUserById(Integer id);
    public List<MyUser> selectAllUser(Map<String, Object> map);
    public int addUser(MyUser user);
    public int updateUser(MyUser user);
    public int deleteUser(MyUser user);
    public MyUser selectUserOrdersById1(int uid);
    public MyUser selectUserOrdersById2(int uid);
    public List<SelectUserOrdersById> selectUserOrdersById3(int uid);
}