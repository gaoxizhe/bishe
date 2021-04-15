package com.example.service;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:15
 */

import com.example.dao.GraduateStudentDao;
import com.example.model.GraduateStudent;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

/**
 * @ClassName ProfessionService
 * @Author Mr.Gao
 * @Date 2021/3/23 下午10:15
 * @Description TODO |
 */

@Service
public class GraduateStudentService {

    @Resource
    private GraduateStudentDao GraduateStudentDao;



    public PageInfo<GraduateStudent> getGraduateStudentList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<GraduateStudent> pageList = GraduateStudentDao.getGraduateStudentPageList();

        return new PageInfo<>(pageList);

    }

    public List<GraduateStudent> getGraduateStudentList() {
        List<GraduateStudent> GraduateStudents = GraduateStudentDao.getGraduateStudentPageList();
        return GraduateStudents ;
    }

    public GraduateStudent getGraduateStudentById(Integer id) {
        return GraduateStudentDao.getGraduateStudentById(id);
    }

    public void updateGraduateStudent(GraduateStudent GraduateStudent) {
        Calendar cale = null;
        cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;
        if (month < 9) {
            year--;
        }

        GraduateStudent.setYear(String.valueOf(year));

        if (GraduateStudent.getId() == null || GraduateStudent.getId().equals(0)) {
            GraduateStudentDao.insertGraduateStudent(GraduateStudent);
        } else {
            GraduateStudentDao.updateGraduateStudentById(GraduateStudent);
        }
    }

    public void deleteGraduateStudentById(Integer id) {
        GraduateStudentDao.deleteGraduateStudentById(id);
    }
}
