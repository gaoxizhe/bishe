package com.example.service;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:15
 */

import com.alibaba.fastjson.JSON;
import com.example.dao.ClassDao;
import com.example.dao.CourseDao;
import com.example.model.Class;
import com.example.model.Course;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ProfessionService
 * @Author Mr.Gao
 * @Date 2021/3/23 下午10:15
 * @Description TODO |
 */

@Service
@Slf4j
public class CourseService {

    @Resource
    private CourseDao courseDao;


    public PageInfo<Course> getCourseList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Course> coursePageList = courseDao.getCoursePageList();

        return new PageInfo<>(coursePageList);

    }

    public List<Course> getCourseList() {
        List<Course> classList = courseDao.getCoursePageList();
        return classList ;
    }

    public Course getCourseById(Integer id) {
        return courseDao.getCourseById(id);
    }

    public void updateCourse(Course course) {
        if (course.getId() == null || course.getId().equals(0)) {
            log.info("insertCourse:{}", JSON.toJSONString(course));
            courseDao.insertCourse(course);
        } else {
            log.info("updateCourseById:{}", JSON.toJSONString(course));
            courseDao.updateCourseById(course);
        }
    }

    public void deleteCourseById(Integer id) {
        courseDao.deleteCourseById(id);
    }
}
