package com.controller.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.po.Auser;
import com.service.admin.AdminService;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    //1.5.1后台管理子系统的实现(管理员登录)
    @Autowired
    private AdminService adminService;
    @RequestMapping("/admin")
    public String toLogin(@ModelAttribute Auser auser) {
        return "admin/login";
    }
    @RequestMapping("/admin/login")
    public String login(@ModelAttribute Auser auser, Model model, HttpSession session) {
        return adminService.login(auser, model, session);
    }
    @RequestMapping("/exit")
    public String exit(@ModelAttribute Auser auser,HttpSession session) {
        session.invalidate();
        return "admin/login";
    }
}
