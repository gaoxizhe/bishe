package com.example.constant;
/*
 *  @author : Mr.Gao
 *  @date :   2020/3/30 下午9:00
 */

import lombok.Data;

/**
 * @ClassName UserInfo
 * @Author Mr.Gao
 * @Date 2020/3/30 下午9:00
 * @Description
 */

@Data
public class UserInfo {
    private Integer id;
    public String username;
    public String roleName;
    public String roleDescribe;
}
