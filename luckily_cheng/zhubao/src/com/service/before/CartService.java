package com.service.before;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
public interface CartService {
    //1.6.9  关注商品
    //登录成功的用户可以在商品详情页面中单击”关注”按钮关注该商品，
    // 此时请求路径为cart/focus?id=
    public String focus(Model model,Integer id, HttpSession session);
    //1.6.10  购物车
    public String putCart(Model model,Integer shoppingnum, Integer id, HttpSession session);
    public String selectCart(Model model, HttpSession session);
    public String deleteAgoods(Integer id,HttpSession session);
    public String clear(HttpSession session);
    //1.6.11  下单
    public String orderConfirm(Model model, HttpSession session);
}