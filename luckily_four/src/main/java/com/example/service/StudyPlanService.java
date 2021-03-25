package com.example.service;

import com.alibaba.fastjson.JSON;
import com.example.dao.CourseDao;
import com.example.dao.StudyPlanDao;
import com.example.model.Course;
import com.example.model.StudyPlan;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class StudyPlanService {

    @Resource
    private StudyPlanDao studyPlanDao;


    public PageInfo<StudyPlan> getCourseList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<StudyPlan> studyPlanPageList = studyPlanDao.getStudyPlanPageList();

        return new PageInfo<>(studyPlanPageList);

    }

    public List<StudyPlan> getStudyPlanList() {
        List<StudyPlan> studyPlans = studyPlanDao.getStudyPlanPageList();
        return studyPlans;
    }

    public StudyPlan getStudyPlanById(Integer id) {
        return studyPlanDao.getStudyPlanById(id);
    }

    public void updateStudyPlan(StudyPlan studyPlan) {
        if (studyPlan.getId() == null || studyPlan.getId().equals(0)) {
            log.info("insertStudyPlan:{}", JSON.toJSONString(studyPlan));
            studyPlanDao.insertStudyPlan(studyPlan);
        } else {
            log.info("updateStudyPlanById:{}", JSON.toJSONString(studyPlan));
            studyPlanDao.updateStudyPlanById(studyPlan);
        }
    }

    public void deleteStudyPlanById(Integer id) {
        studyPlanDao.deleteStudyPlanById(id);
    }
}
