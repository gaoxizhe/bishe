package com.service.admin;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import com.po.Goods;
public interface AdminGoodsService {
    //1.5.3 商品管理
    public String selectAGoods(Model model, Integer id, String act);
    public String deleteGoods(Integer ids[], Model model);
    public String deleteAGoods(Integer id, Model model);
    public String addOrUpdateGoods(Goods goods, HttpServletRequest request, String updateAct);
    public String selectGoods(Model model, Integer pageCur, String act);
}