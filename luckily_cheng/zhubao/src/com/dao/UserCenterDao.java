package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("userCenterDao")
@Mapper
public interface UserCenterDao {
    //1.5.8 用户管理
    //“用户管理”模块牵涉到删除用户时，要考虑到用户关联的购车、关注的商品、订单，
    // 如果存在关联就不能直接删除用户。
    public List<Map<String, Object>> myOrder(Integer bid);
    public List<Map<String, Object>> myFocus(Integer bid);
    //1.6.12  用户中心
    //成功登录的用户在导航栏的上方单击”用户中心”超链接，进入用户中心页面
    public List<Map<String, Object>> orderDetail(Integer ordersn);
}