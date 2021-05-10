package com.example.dao;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:16
 */

import com.example.model.GraduateStudent;
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
public interface GraduateStudentDao {
    List<GraduateStudent> getGraduateStudentPageList();

    List<GraduateStudent> getGraduateStudentPageListBySearch(@Param("year") Integer year,@Param("type") String type);

    GraduateStudent getGraduateStudentById(@Param("id") Integer id);

    void insertGraduateStudent(GraduateStudent GraduateStudent);

    void updateGraduateStudentById(GraduateStudent GraduateStudent);

    void deleteGraduateStudentById(@Param("id") Integer id);
}
