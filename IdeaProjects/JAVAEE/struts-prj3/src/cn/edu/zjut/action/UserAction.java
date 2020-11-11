package cn.edu.zjut.action;

import cn.edu.zjut.bean.UserBean;
import cn.edu.zjut.service.UserService;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class UserAction {
    private UserBean loginUser;
    private Integer count = 0;
    private Map session;
    public UserAction() {
        System.out.println("创建了一个 UserAction 类对象。");
    }

    public UserBean getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(UserBean loginUser) {
        this.loginUser = loginUser;
    }

    public Integer getCount() {
        return count;
    }
    public String login() throws Exception {
        ActionContext ctx= ActionContext.getContext();
        session = (Map) ctx.getSession();
        UserService userServ = new UserService();
        try{
            if(userServ.login(loginUser)) {
                session.put("user", loginUser.getAccount());
                return "success";
            }
            else return "fail";
        }catch (Exception e) {
            throw e;
        }
    }
//    public String register() {
//        UserService userServ = new UserService();
//        if(userServ.register(loginUser)) {
//            return "register_success";
//        }
//        else return "register_fail";
//    }
}
