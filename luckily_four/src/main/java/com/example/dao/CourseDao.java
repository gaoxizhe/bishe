package com.example.dao;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:16
 */

import com.example.model.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @CourseName ProFessionDao
 * @Author Mr.Gao
 * @Date 2021/3/23 下午10:16
 * @Description TODO | 
 */
@Repository
public interface CourseDao {
    List<Course> getCoursePageList();

    Course getCourseById(@Param("id") Integer id);

    void insertCourse(Course course);

    void updateCourseById(Course course);

    void deleteCourseById(@Param("id") Integer id);
}
