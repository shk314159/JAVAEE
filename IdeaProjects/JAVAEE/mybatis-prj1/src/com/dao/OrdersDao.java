package com.dao;

import com.mybatis.po.Orders;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface OrdersDao {
    public List<Orders> selectOrdersById(int id);
}