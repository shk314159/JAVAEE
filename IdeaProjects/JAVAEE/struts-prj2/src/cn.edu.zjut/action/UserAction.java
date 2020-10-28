package cn.edu.zjut.action;

import cn.edu.zjut.bean.UserBean;
import cn.edu.zjut.service.UserService;

public class UserAction {
    private UserBean loginUser;

    public UserBean getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(UserBean loginUser) {
        this.loginUser = loginUser;
    }

    public String login() {
        UserService userServ = new UserService();
        if(userServ.login(loginUser)) {
            return "success";
        }
        else {
            return "fail";
        }
    }
    public String register() {
        UserService userServ = new UserService();
        if (userServ.register(loginUser)) {
            return "register_success"; }
        return "register_fail";
    }

    public String execute() {
        UserService userServ = new UserService();
        if(userServ.login(loginUser)) {
//            System.out.println(1);
            return "success";
        }
        else {
//            System.out.println(2);
            return "fail";
        }
    }

}