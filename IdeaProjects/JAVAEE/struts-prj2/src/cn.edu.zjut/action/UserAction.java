package cn.edu.zjut.action;

import cn.edu.zjut.bean.UserBean;
import cn.edu.zjut.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
    private UserBean loginUser;
    private Integer count=0;
    public UserAction() {
        System.out.println("创建了一个 UserAction 类对象。");
    }

    public Integer getCount() {
        return count;
    }
    public UserBean getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(UserBean loginUser) {
        this.loginUser = loginUser;
    }

    public String login() {
        count++;
        UserService userServ = new UserService();
        if(userServ.login(loginUser)) {
            this.addActionMessage("登录成功！");
            return "success";
        }
        else {
            this.addActionError("用户名或密码错误，请重新输入！");
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

    public void validate() {
        String account = loginUser.getAccount();
        String pwd = loginUser.getPassword();
        if (account == null || account.equals("")) {
            this.addFieldError("loginUser.account", "请输入您的用户名！");
        }
        if (pwd == null || pwd.equals("")) {
            this.addFieldError("loginUser.password", "请输入您的密码！");
        }
    }
}