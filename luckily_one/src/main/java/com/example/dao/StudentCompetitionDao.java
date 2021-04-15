package com.example.dao;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:16
 */

import com.example.model.StudentCompetition;
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
public interface StudentCompetitionDao {
    List<StudentCompetition> getStudentCompetitionPageList();

    StudentCompetition getStudentCompetitionById(@Param("id") Integer id);

    void insertStudentCompetition(StudentCompetition studentCompetition);

    void updateStudentCompetitionById(StudentCompetition studentCompetition);

    void deleteStudentCompetitionById(@Param("id") Integer id);
}
