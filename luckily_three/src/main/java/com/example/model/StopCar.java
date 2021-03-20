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
public class StopCar {
    private Integer id;
    private Integer psId;
    private String psCode;
    private Integer userId;
    private String userName;
    private Integer carId;
    private String carNumber;
    private Timestamp time;
}
