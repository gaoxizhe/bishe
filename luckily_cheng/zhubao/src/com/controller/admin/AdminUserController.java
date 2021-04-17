package com.controller.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.service.admin.AdminUserService;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController extends BaseController{
    //1.5.8 用户管理=“用户管理”模块牵涉到删除用户时，要考虑到用户关联的购车、
    //关注的商品、订单，如果存在关联就不能直接删除用户。
    @Autowired
    private AdminUserService adminUserService;
    @RequestMapping("/userInfo")
    public String userInfo(Model model) {
        return adminUserService.userInfo(model);
    }
    @RequestMapping("/deleteuserManager")
    public String deleteuserManager(Integer id, Model model) {
        return adminUserService.deleteuserManager(id, model);
    }
}