package cn.edu.zjut.action;

import cn.edu.zjut.bean.ShoppingCart;
import cn.edu.zjut.bean.UserBean;
import cn.edu.zjut.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.deploy.net.HttpRequest;
import javafx.application.Application;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.*;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.util.Map;

public class UserAction extends ActionSupport {
    private UserBean loginUser;
    private Integer count = 0;

    public UserAction() {
        System.out.println("创建了一个 UserAction 类对象。");
    }

    //    private Map request,session,application;
//public Map getRequest() {
//    return request;
//}
//
//    public void setRequest(Map request) {
//        this.request = request;
//    }
//
//    public Map getSession() {
//        return session;
//    }
//
//    public void setSession(Map session) {
//        this.session = session;
//    }
//
//    public Map getApplication() {
//        return application;
//    }
//
//    public void setApplication(Map application) {
//        this.application = application;
//    }
    public Integer getCount() {
        return count;
    }

    public UserBean getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(UserBean loginUser) {
        this.loginUser = loginUser;
    }

//    public String login() {
//        count++;
//        UserService userServ = new UserService();
//        if(userServ.login(loginUser)) {
//            this.addActionMessage((this.getText("login.success")));
//            return "success";
//        }
//        else {
//            this.addActionError(this.getText("login.error"));
//            return "fail";
//        }
//    }
//    public String login() {
//        ActionContext ctx= ActionContext.getContext();
////通过 ActionContext 对象获取请求、会话和上下文对象相关联的 Map 对象
//        request=(Map) ctx.get("request");
//        session=(Map) ctx.getSession();
//        application=(Map) ctx.getApplication();
////访问 application 范围的属性值
//        Integer counter = (Integer)application.get("counter");
//        if(counter==null)
//            counter=1;
//        else
//            counter=counter+1;
////设置 application 范围的属性
//        application.put("counter", counter);
//        UserService userServ = new UserService();
//        if (userServ.login(loginUser)) {
////设置 session 范围的属性
//            session.put("user", loginUser.getAccount());
////设置 request 范围的属性
//            request.put("tip", "您已登录成功");
//            return "success";
//        } else {
//            return "fail";
//        }


    //2
//        Integer counter = (Integer)application.get("counter");
//        if(counter==null)
//            counter=1;
//        else
//            counter=counter+1;
//        application.put("counter", counter);
//        UserService userServ = new UserService();
//        if (userServ.login(loginUser)) {
//            session.put("user", loginUser.getAccount());
//            request.put("tip", "您已登录成功");
//            return "success";
//        } else {
//            return "fail";
//        }
//    }
    public String register() {
        UserService userServ = new UserService();
        if (userServ.register(loginUser)) {
            return "register_success";
        }
        return "register_fail";
    }

    public String execute() {
        UserService userServ = new UserService();
        if (userServ.login(loginUser)) {
//            System.out.println(1);
            return "success";
        } else {
//            System.out.println(2);
            return "fail";
        }
    }

    public void validateLogin() {
        String account = loginUser.getAccount();
        String pwd = loginUser.getPassword();
        if (account == null || account.equals("")) {
            this.addFieldError("loginUser.account",
                    this.getText("login.account.null"));
        }
        if (pwd == null || pwd.equals("")) {
            this.addFieldError("loginUser.password",
                    this.getText("login.password.null"));
        }
    }

    public void validateRegister() {
        String account = loginUser.getAccount();
        String pwd = loginUser.getPassword();
        String repwd = loginUser.getRepassword();
        if (account == null || account.equals("")) {
            this.addFieldError("loginUser.account",
                    this.getText("login.account.null"));
        }
        if (pwd == null || pwd.equals("")) {
            this.addFieldError("loginUser.password",
                    this.getText("login.password.null"));
        }
        if (!repwd.equals(pwd)) {
            this.addFieldError("loginUser.password",
                    this.getText("前后密码不一致"));
        }
    }

    //
//    private HttpServletRequest request;
//    @Override
//    public void setServletRequest(javax.servlet.http.HttpServletRequest httpServletRequest) {
//        this.request = httpServletRequest;
//    }
//    private HttpServletResponse response;
//    @Override
//    public void setServletResponse(javax.servlet.http.HttpServletResponse httpServletResponse) {
//        this.response = httpServletResponse;
//    }
//    private ServletContext application;
//    @Override
//    public void setServletContext(javax.servlet.ServletContext servletContext) {
//        this.application = servletContext;
//    }
//    public String login() {
//        HttpSession session = request.getSession();
//        Integer counter = (Integer)application.getAttribute("counter");
//        if(counter==null)
//            counter=1;
//        else
//            counter=counter+1;
//        application.setAttribute("counter", counter);
//        UserService userServ = new UserService();
//        if (userServ.login(loginUser)) {
//            session.setAttribute("user", loginUser.getAccount());
//            request.setAttribute("tip", "您已登录成功");
//            return "success";
//        } else {
//            return "fail";
//        }
//    }
    public String login() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        ServletContext application = ServletActionContext.getServletContext();
        Integer counter = (Integer) application.getAttribute("counter");
        if (counter == null)
            counter = 1;
        else
            counter = counter + 1;
        application.setAttribute("counter", counter);
        UserService userServ = new UserService();
        if (userServ.login(loginUser)) {
            session.setAttribute("user", loginUser.getAccount());
            ShoppingCart shoppingCart = new ShoppingCart();
            request.setAttribute("tip", "您已登录成功");
            session.setAttribute("shoppingcart", shoppingCart);
            return "success";
        } else {
            return "fail";
        }
    }
}