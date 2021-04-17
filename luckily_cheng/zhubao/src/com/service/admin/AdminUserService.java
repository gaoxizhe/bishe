package com.service.admin;

import org.springframework.ui.Model;

public interface AdminUserService {
    //1.5.8 用户管理=“用户管理”模块牵涉到删除用户时，要考虑到用户关联的购车、
    //关注的商品、订单，如果存在关联就不能直接删除用户。
    public String userInfo(Model model);
    public String deleteuserManager(Integer id, Model model);
}