package com.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Repository("cartDao")
@Mapper
public interface CartDao {
    //1.5.8 用户管理
    //“用户管理”模块牵涉到删除用户时，要考虑到用户关联的购车、关注的商品、订单，如果存在关联就不能直接删除用户。
    public List<Map<String, Object>> selectCart(Integer id);
    //1.6.9  关注商品
    //登录成功的用户可以在商品详情页面中单击”关注”按钮关注该商品，
    // 此时请求路径为cart/focus?id=
    public int focus(Map<String, Object> map);
    public List<Map<String, Object>> isFocus(Map<String, Object> map);
    //1.6.10  购物车
    public List<Map<String, Object>> isPutCart(Map<String, Object> map);
    public int putCart (Map<String, Object> map);
    public int updateCart (Map<String, Object> map);
    public int deleteAgoods (Map<String, Object> map);
    public int clear(Integer id);
}