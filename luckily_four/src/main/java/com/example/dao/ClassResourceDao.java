package com.example.dao;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:16
 */

import com.example.model.ClassResource;
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
public interface ClassResourceDao {
    List<ClassResource> getClassResourcePageList();

    ClassResource getClassResourceById(@Param("id") Integer id);

    void insertClassResource(ClassResource classResource);

    void updateClassResourceById(ClassResource classResource);

    void deleteClassResourceById(@Param("id") Integer id);
}
