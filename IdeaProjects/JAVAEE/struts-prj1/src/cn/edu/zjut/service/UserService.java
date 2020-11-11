package cn.edu.zjut.service;

import cn.edu.zjut.bean.UserBean;

public class UserService {
    public boolean login(UserBean loginUser) {
        if (loginUser.getAccount().equals(loginUser.getPassword())) {
            return true;
        }
        return false;
    }
    public boolean register(UserBean registerUser) {
        if (registerUser.getAccount().equals(registerUser.getPassword()) &&
            registerUser.getAccount().equals(registerUser.getRepassword()) &&
            !"".equals(registerUser.getAccount())) {
            return true;
        }
        else return false;
    }
}