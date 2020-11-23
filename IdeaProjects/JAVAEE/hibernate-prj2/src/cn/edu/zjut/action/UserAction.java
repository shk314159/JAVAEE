package cn.edu.zjut.action;

import cn.edu.zjut.po.Customer;
import cn.edu.zjut.service.UserService;

public class UserAction {
    private Customer loginUser;

    public String login() {
        UserService userServ = new UserService();
        if (userServ.login(loginUser))
            return "loginsuccess";
        else
            return "loginfail";
    }

    public String register() {
        UserService userServ = new UserService();
        if(userServ.register(loginUser)) {
            return "registersuccess";
        }
        else {
            return "registerfail";
        }
    }

    public String update() {
        UserService userServ = new UserService();
        if(userServ.update(loginUser)) {
            return "updatesuccess";
        }
        else {
            return "updatefail";
        }
    }

    public String delete() {
        UserService userServ = new UserService();
        if(userServ.delete(loginUser)) {
            return "deletesuccess";
        }
        else {
            return "deletefail";
        }
    }

    public Customer getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(Customer loginUser) {
        this.loginUser = loginUser;
    }
}