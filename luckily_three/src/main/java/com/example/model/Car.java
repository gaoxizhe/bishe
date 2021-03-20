package com.example.model;
/*
 *  @author : Mr.Gao
 *  @date :   2020/3/20 上午10:52
 */

import lombok.Data;

/**
 * @ClassName User
 * @Author Mr.Gao
 * @Date 2020/3/20 上午10:52
 * @Description
 */

@Data
public class Car {
    private Integer id;
    private String code;
    //0 新建状态，1.预定状态，--管理员审核状态 （支付）  2.在租状态 开始时间和结束时间 3.删除
    private Integer status;
    private Integer price;
    private String remarks;
}
