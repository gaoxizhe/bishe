package com.example.service;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:15
 */

import com.example.dao.CommonDao;
import com.example.dao.GraduateStudentDao;
import com.example.dao.WorkDao;
import com.example.model.GraduateDetail;
import com.example.model.GraduateStudent;
import com.example.model.Welcome;
import com.example.model.Work;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommonService {

    @Resource
    private CommonDao commonDao;

    @Resource
    private GraduateStudentDao graduateStudentDao;

    public Welcome getCount() {
        Welcome welcome = commonDao.getWelcomeCount();
        List<GraduateStudent> list = graduateStudentDao.getGraduateStudentPageList();

        List<GraduateDetail> graduateDetails = new ArrayList<>();

        Map<String, List<GraduateStudent>> collect = list.stream().collect(Collectors.groupingBy(GraduateStudent::getYear));
        collect.forEach((s, graduateStudents) -> {
            GraduateDetail graduateDetail = new GraduateDetail();
            graduateDetail.setYear(s);
            graduateDetail.setBNumber(Integer.parseInt(String.valueOf(graduateStudents.stream().count())));
            graduateDetail.setLNumber((int) graduateStudents.stream().filter(graduateStudent -> {
                boolean b = !"无".equals(graduateStudent.getAdmissionCategory());
                return b;
            }).count());
            graduateDetails.add(graduateDetail);
        });
        welcome.setGraduateDetails(graduateDetails);

        return welcome;
    }
}
