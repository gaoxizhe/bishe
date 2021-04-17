package com.service.before;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.po.Goods;
public interface IndexService {
    //1.6 前台电子商务子系统的实现
    public String before(Model model,HttpSession session, Goods goods);
    public String toRegister(Model model);
    public String toLogin(Model model);
    //1.6.8  商品详情
    public String goodsDetail(Model model,Integer id);
    public String selectANotice(Model model,Integer id);
    public String search(Model model,String mykey);
}