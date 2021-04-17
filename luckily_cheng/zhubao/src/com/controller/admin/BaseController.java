package com.controller.admin;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.exception.AdminLoginNoException;
@Controller
public class BaseController {
    /**
     * 登录权限控制，处理方法执行前执行该方法
     * @throws AdminLoginNoException
     */
    @ModelAttribute//说明方法是用于添加一个或多个属性到model上
    public void isLogin(HttpSession session, HttpServletRequest request) throws AdminLoginNoException {
        if(session.getAttribute("auser") == null){
            throw new AdminLoginNoException("没有登录");
        }
    }
}
