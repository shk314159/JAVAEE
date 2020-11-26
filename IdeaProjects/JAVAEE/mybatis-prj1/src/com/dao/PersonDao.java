package com.dao;

import com.mybatis.po.Person;
import org.apache.ibatis.annotations.Mapper;
import com.pojo.SelectPersonById;
@Mapper
public interface PersonDao {
    public Person selectPersonById1(Integer id);
    public Person selectPersonById2(Integer id);
    public SelectPersonById selectPersonById3(Integer id);
}