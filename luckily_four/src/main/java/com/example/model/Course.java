package com.example.model;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午11:30
 */

import lombok.Data;

/**
 * @ClassName Class
 * @Author Mr.Gao
 * @Date 2021/3/23 下午11:30
 * @Description TODO |
 */
@Data
public class Course {
    private Integer id;
    private Integer professionId;
    private String professionName;
    private Integer classId;
    private String className;
    private Integer userId;
    private String userName;
    private String courseName;
    private String content;
}
