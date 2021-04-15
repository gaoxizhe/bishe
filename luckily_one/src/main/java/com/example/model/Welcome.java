package com.example.model;/**
 * @author : Mr.Gao
 * @date :   2021/4/15 下午11:51
 */

import lombok.Data;

import java.util.List;

/**
 * @ClassName Welcome
 * @Author Mr.Gao
 * @Date 2021/4/15 下午11:51
 * @Description TODO | 
 */
@Data
public class Welcome {
    private Integer student;
    private Integer teacher;
    private Integer project;
    private Integer graduate;
    private List<GraduateDetail> graduateDetails;
}
