package com.example.service;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:15
 */

import com.example.dao.ClassDao;
import com.example.dao.StudentDao;
import com.example.model.Class;
import com.example.model.Student;
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
public class StudentService {

    @Resource
    private StudentDao studentDao;



    public PageInfo<Student> getStudentList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Student> pageList = studentDao.getStudentPageList();

        return new PageInfo<>(pageList);

    }

    public List<Student> getStudentList() {
        List<Student> students = studentDao.getStudentPageList();
        return students ;
    }

    public Student getStudentById(Integer id) {
        return studentDao.getStudentById(id);
    }

    public void updateStudent(Student student) {
        if (student.getId() == null || student.getId().equals(0)) {
            studentDao.insertStudent(student);
        } else {
            studentDao.updateStudentById(student);
        }
    }

    public void deleteStudentById(Integer id) {
        studentDao.deleteStudentById(id);
    }
}
