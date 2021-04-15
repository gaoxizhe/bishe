package com.example.model;/**
 * @author : Mr.Gao
 * @date :   2021/4/15 下午11:51
 */

import lombok.Data;

/**
 * @ClassName Welcome
 * @Author Mr.Gao
 * @Date 2021/4/15 下午11:51
 * @Description TODO | 
 */
@Data
public class GraduateDetail {
    private String year;
    private Integer bNumber;//报考人数
    private Integer lNumber;//录取人数
    private Integer percentage; //百分比

    public Integer getPercentage() {
        return (lNumber/bNumber)*100;
    }
}
