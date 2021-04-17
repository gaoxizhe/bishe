package com.controller.before;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.service.before.CartService;
@Controller
@RequestMapping("/cart")
public class CartController extends BaseBeforeController{
    //1.6.9  关注商品
    //登录成功的用户可以在商品详情页面中单击”关注”按钮关注该商品，
    // 此时请求路径为cart/focus?id=
    @Autowired
    private CartService cartService;
    /**
     * 关注商品
     */
    @RequestMapping("/focus")
    public String focus(Model model,Integer id, HttpSession session) {
        return cartService.focus(model, id, session);
    }
    //1.6.10  购物车
    /**
     * 添加购物车
     */
    @RequestMapping("/putCart")
    public String putCart(Model model,Integer shoppingnum, Integer id, HttpSession session) {
        return cartService.putCart(model, shoppingnum, id, session);
    }
    /**
     * 查询购物车
     */
    @RequestMapping("/selectCart")
    public String selectCart(Model model, HttpSession session) {
        return cartService.selectCart(model, session);
    }
    /**
     * 删除购物车
     */
    @RequestMapping("/deleteAgoods")
    public String deleteAgoods(Integer id,HttpSession session) {
        return cartService.deleteAgoods(id, session);
    }
    /**
     * 清空购物车
     */
    @RequestMapping("/clear")
    public String clear(HttpSession session) {
        return cartService.clear(session);
    }
    /**
     * 去结算
     */
    @RequestMapping("/orderConfirm")
    public String orderConfirm(Model model, HttpSession session) {
        return cartService.orderConfirm(model, session);
    }
}