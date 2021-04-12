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
public class Student {
    private Integer id;
    private String name;
    private String phone;
    private Integer professionId;
    private String professionName;

    private Integer classId;
    private String className;


    private Integer teacherId;
    private String teacherName;
    private String teacherPhone;

    private Integer instructorId;
    private String instructorName;
    private String instructorPhone;
}
