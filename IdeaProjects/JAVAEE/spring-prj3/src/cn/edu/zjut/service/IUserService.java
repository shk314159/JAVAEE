package cn.edu.zjut.service;

import cn.edu.zjut.dao.ICustomerDAO;
import cn.edu.zjut.po.Customer;

public interface IUserService {
    public void setCustomerDAO(ICustomerDAO customerDAO);
    public void addUser(Customer cust);
    public void delUser(Customer cust);
    public void updateUser(Customer cust);
    public void findUser(Customer cust);
}