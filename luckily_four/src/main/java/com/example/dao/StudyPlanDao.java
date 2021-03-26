package com.example.dao;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:16
 */

import com.example.model.Course;
import com.example.model.StudyPlan;
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
public interface StudyPlanDao {
    List<StudyPlan> getStudyPlanPageList();

    StudyPlan getStudyPlanById(@Param("id") Integer id);

    void insertStudyPlan(StudyPlan studyPlan);

    void updateStudyPlanById(StudyPlan studyPlan);

    void deleteStudyPlanById(@Param("id") Integer id);
}
