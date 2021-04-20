package com.fgy.oa.interceptor;

import com.fgy.oa.domain.Employee;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //放行 静态资源以及login
        String uri = request.getRequestURI();
        System.out.println(uri);
        String reg = "(/assets/|/vendor/)([\\s\\S]*?)(.js|.css|v=4.3.0)";
        if (Pattern.matches(reg,uri)) {
            System.err.println(uri);
            return true;
        }
        if (uri.indexOf("login") > 0) {
            return true;
        }
        HttpSession session = request.getSession();
        Employee employee = (Employee) session.getAttribute("employee");
        if (employee != null) {
            return true;
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
        return false;
    }
}
