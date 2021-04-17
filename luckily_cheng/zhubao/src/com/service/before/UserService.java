package com.service.before;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.po.Buser;
public interface UserService {
    //1.6.6  用户注册
    public String register(Buser buser,Model model, HttpSession session, String code);
    //1.6.7  用户登录
    public String login(Buser buser,Model model, HttpSession session, String code);
}