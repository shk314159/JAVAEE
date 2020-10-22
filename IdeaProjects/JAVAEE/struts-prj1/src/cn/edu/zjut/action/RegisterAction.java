package cn.edu.zjut.action;

import cn.edu.zjut.bean.UserBean;
import cn.edu.zjut.service.UserService;

public class RegisterAction {
    private UserBean registerUser;

    public UserBean getRegisterUser() {
        return registerUser;
    }

    public void setRegisterUser(UserBean registerUser) {
        this.registerUser = registerUser;
    }
    public String execute() {
        UserService userServ = new UserService();
        if(userServ.register(registerUser)) {
            System.out.println(1);
            return "success";
        }
        else {
            System.out.println(2);
            return "fail";
        }
    }
}
