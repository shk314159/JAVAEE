package cn.edu.zjut.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.LogRecord;

public class AccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filterChain)
        throws IOException, ServletException {
        System.out.println("Access Filter executed!");
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null &&
        request.getRequestURI().indexOf("login.jsp") == -1 &&
        request.getRequestURI().indexOf("register.jsp") == -1){
            response.sendRedirect("login.jsp");
            return;
        }
        filterChain.doFilter(arg0,arg1);
    }

    @Override
    public void destroy() {

    }

}
