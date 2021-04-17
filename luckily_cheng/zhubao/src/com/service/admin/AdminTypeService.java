package com.service.admin;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
public interface AdminTypeService {
    //1.5.2 类型管理
    //类型管理分为添加类型和删除类型。
    public String toAddType(Model model);
    public String addType(String typename,Model model,HttpSession session);
    public String toDeleteType(Model model);
    public String deleteType(Integer id,Model model);}