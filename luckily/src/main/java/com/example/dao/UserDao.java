package com.example.dao;

import com.example.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

/**
 * @author gao
 */
@Repository
public interface UserDao {

    public Users getUserInfoByUserName(@Param("username") String username);



    void updateUserInfoByUsername(Users users);

    int insertUser(Users users);

    int findEmailCount(@Param("email") String email);
}
