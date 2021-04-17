package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Auser;
@Repository("adminDao")
@Mapper
public interface AdminDao {
    //1.5.1后台管理子系统的实现(管理员登录)
    public List<Auser> login(Auser auser);
}