package com.fgy.oa.controller;

import com.fgy.oa.domain.Employee;
import com.fgy.oa.service.GlobalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局控制层
 */
@Controller("globalController")
@SessionAttributes(names = "employee", types = Employee.class)
public class GlobalController {

    @Resource(name = "globalService")
    private GlobalService globalService;

    /**
     * 跳转登陆页面
     * @return
     */
    @RequestMapping("/to_login")
    public String toLogin(){
        return "forward:/login.jsp";
    }

    /**
     * 用户登录
     * @param sn
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", params = {"sn", "password"})
    public String login(HttpServletResponse response, Model model, String sn, String password, String remember){
        Employee employee = globalService.login(sn, password);
        if (employee == null) {
            return "redirect:/login.jsp";
        }
        model.addAttribute("employee",employee);
        if (remember != null) {
            Cookie cookie_sn = new Cookie("sn", sn);
            cookie_sn.setMaxAge(60 * 60 * 24);
            Cookie cookie_password = new Cookie("password", password);
            cookie_password.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie_sn);
            response.addCookie(cookie_password);
        }
        return "redirect:/self";
    }

    /**
     * 跳转到个人信息页面
     * @return
     */
    @RequestMapping("/self")
    public String self(){
        return "self";
    }

    /**
     * 用户退出
     * @return
     */
    @RequestMapping("/quit")
    public String quit(SessionStatus status){
        status.setComplete();
        return "redirect:/to_login";
    }

    /**
     * 跳转到修改密码页面
     * @return
     */
    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password";
    }

    /**
     * 修改密码
     * @param map
     * @param old
     * @param new1
     * @param new2
     * @return
     */
    @RequestMapping("/change_password")
    public String changePassword(ModelMap map, String old, String new1, String new2){
        Employee employee = (Employee) map.get("employee");
        if(employee.getPassword().equals(old)){
            if(!new1.isEmpty() && new1.equals(new2)){
                employee.setPassword(new1);
                globalService.changePassword(employee);
                return "redirect:/self";
            }
        }
        return "redirect:/to_change_password";
    }

}
