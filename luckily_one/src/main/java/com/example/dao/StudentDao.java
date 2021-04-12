package com.example.dao;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:16
 */

import com.example.model.Class;
import com.example.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName ProFessionDao
 * @Author Mr.Gao
 * @Date 2021/3/23 下午10:16
 * @Description TODO | 
 */
@Repository
public interface StudentDao {
    List<Student> getStudentPageList();

    Student getStudentById(@Param("id") Integer id);

    void insertStudent(Student student);

    void updateStudentById(Student student);

    void deleteStudentById(@Param("id") Integer id);
}
