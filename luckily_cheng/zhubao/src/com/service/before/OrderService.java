package com.service.before;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
public interface OrderService {
    //1.6.11  下单
    public String orderSubmit(Model model, HttpSession session,Double amount);
    public String pay(Integer ordersn);
}