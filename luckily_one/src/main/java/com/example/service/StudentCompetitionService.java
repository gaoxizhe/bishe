package com.example.service;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:15
 */

import com.example.dao.StudentCompetitionDao;
import com.example.model.StudentCompetition;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ProfessionService
 * @Author Mr.Gao
 * @Date 2021/3/23 下午10:15
 * @Description TODO |
 */

@Service
public class StudentCompetitionService {

    @Resource
    private StudentCompetitionDao StudentCompetitionDao;



    public PageInfo<StudentCompetition> getStudentCompetitionList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<StudentCompetition> pageList = StudentCompetitionDao.getStudentCompetitionPageList();

        return new PageInfo<>(pageList);

    }

    public List<StudentCompetition> getStudentCompetitionList() {
        List<StudentCompetition> StudentCompetitions = StudentCompetitionDao.getStudentCompetitionPageList();
        return StudentCompetitions ;
    }

    public StudentCompetition getStudentCompetitionById(Integer id) {
        return StudentCompetitionDao.getStudentCompetitionById(id);
    }

    public void updateStudentCompetition(StudentCompetition StudentCompetition) {
        if (StudentCompetition.getId() == null || StudentCompetition.getId().equals(0)) {
            StudentCompetitionDao.insertStudentCompetition(StudentCompetition);
        } else {
            StudentCompetitionDao.updateStudentCompetitionById(StudentCompetition);
        }
    }

    public void deleteStudentCompetitionById(Integer id) {
        StudentCompetitionDao.deleteStudentCompetitionById(id);
    }
}
