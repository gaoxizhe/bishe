package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Buser;

@Repository("adminUserDao")
@Mapper
public interface AdminUserDao {
    //1.5.8 用户管理
    //“用户管理”模块牵涉到删除用户时，要考虑到用户关联的购车、关注的商品、订单，
    // 如果存在关联就不能直接删除用户。
    public List<Buser> userInfo();
    public int deleteuserManager(Integer id);
}