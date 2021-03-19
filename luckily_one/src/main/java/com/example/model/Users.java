package com.example.model;
/*
 *  @author : Mr.Gao
 *  @date :   2020/3/20 上午10:52
 */

import lombok.Data;

import java.sql.Timestamp;

/**
 * @ClassName User
 * @Author Mr.Gao
 * @Date 2020/3/20 上午10:52
 * @Description
 */

@Data
public class Users {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private Integer role;
    private String roleName;
    private String roleDescribe;
}
