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