package com.service.before;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
public interface UserCenterService {
    //1.6.12  用户中心
    //成功登录的用户在导航栏的上方单击”用户中心”超链接，进入用户中心页面
    public String userCenter(HttpSession session, Model model);
    public String orderDetail(Model model, Integer ordersn);
}