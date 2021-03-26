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
public class Task {
    private Integer id;
    private Integer courseId;
    private String courseName;
    private Integer userId;
    private String userName;
    private String name;
    private String content;
}
