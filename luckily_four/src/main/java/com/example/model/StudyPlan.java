package com.example.model;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午11:30
 */

import lombok.Data;

import java.sql.Timestamp;

/**
 * @ClassName Class
 * @Author Mr.Gao
 * @Date 2021/3/23 下午11:30
 * @Description TODO |
 */
@Data
public class StudyPlan {
    private Integer id;
    private String name;
    private Integer courseId;
    private String courseName;
    private Timestamp time;
    private String content;
}
