package com.example.dao;

import com.example.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gao
 */
@Repository
public interface UserDao {

    public Users getUserInfoByUserName(@Param("username") String username);



    void updateUserInfoByUsername(Users users);

    int insertUser(Users users);

    int findEmailCount(@Param("email") String email);

    List<Users> getUserPageByRole(@Param("roleId") int i);

    Users getUserById(@Param("id") Integer id);

    void updateUserInfoById(Users users);

    void updateUserPassword(Users users);

    void deleteUserById(@Param("id") Integer id);

    Users selectUserListByRole(@Param("roleId") Integer role);
}
