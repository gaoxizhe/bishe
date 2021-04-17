package com.service.admin;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.po.Auser;
public interface AdminService {
    //1.5.1后台管理子系统的实现(管理员登录)
    public String login(Auser auser, Model model, HttpSession session);
}