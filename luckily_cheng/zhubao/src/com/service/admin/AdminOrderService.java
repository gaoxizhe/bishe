package com.service.admin;

import org.springframework.ui.Model;

public interface AdminOrderService {
    //1.5.7 订单管理
    public String orderInfo(Model model);
    public String deleteorderManager(Integer id);
}