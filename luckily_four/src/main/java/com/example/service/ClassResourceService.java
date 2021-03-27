package com.example.service;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:15
 */

import com.alibaba.fastjson.JSON;
import com.example.dao.ClassResourceDao;
import com.example.dao.CourseDao;
import com.example.model.ClassResource;
import com.example.model.Course;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ClassResourceService {

    @Resource
    private ClassResourceDao classResourceDao;


    public PageInfo<ClassResource> getClassResourceList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<ClassResource> classResources = classResourceDao.getClassResourcePageList();

        return new PageInfo<>(classResources);

    }

    public List<ClassResource> getClassResourceList() {
        List<ClassResource> classResources = classResourceDao.getClassResourcePageList();
        return classResources ;
    }

    public ClassResource getClassResourceById(Integer id) {
        return classResourceDao.getClassResourceById(id);
    }

    public void updateClassResource(ClassResource classResource) {
        if (classResource.getId() == null || classResource.getId().equals(0)) {
            log.info("insertClassResource:{}", JSON.toJSONString(classResource));
            classResourceDao.insertClassResource(classResource);
        } else {
            log.info("updateClassResourceById:{}", JSON.toJSONString(classResource));
            classResourceDao.updateClassResourceById(classResource);
        }
    }

    public void deleteClassResourceById(Integer id) {
        classResourceDao.deleteClassResourceById(id);
    }
}
