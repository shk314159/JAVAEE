package cn.edu.zjut.dao;
import cn.edu.zjut.po.Customer;

import java.util.List;

public interface ICustomerDAO{
    public void save(Customer transientInstance);
    public void delete(Customer transientInstance);
    public void update(Customer transientInstance);
    public List findByHql(String hql);
}