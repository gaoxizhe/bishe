package com.example.service;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:15
 */

import com.example.dao.ClassDao;
import com.example.dao.ProFessionDao;
import com.example.model.Class;
import com.example.model.Profession;
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
public class ClassService {

    @Resource
    private ClassDao classDao;



    public PageInfo<Class> getClassList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Class> professionPageList = classDao.getClassPageList();

        return new PageInfo<>(professionPageList);

    }

    public List<Class> getClassList() {
        List<Class> classList = classDao.getClassPageList();
        return classList ;
    }

    public Class getClassById(Integer id) {
        return classDao.getClassById(id);
    }

    public void updateClass(Class clazz) {
        if (clazz.getId() == null || clazz.getId().equals(0)) {
            classDao.insertClass(clazz.getProfessionId(),clazz.getName());
        } else {
            classDao.updateClassById(clazz.getId(), clazz.getProfessionId(),clazz.getName());
        }
    }

    public void deleteClassById(Integer id) {
        classDao.deleteClassById(id);
    }
}
