package com.dao;

import com.mybatis.po.Idcard;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface IdCardDao {
    public Idcard selectCodeById(Integer i);
}