package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Buser;
@Repository("userDao")
@Mapper
public interface UserDao {
    //1.6.6 用户注册
    public int register(Buser buser);
    //1.6.7  用户登录
    public List<Buser> login(Buser buser);
}