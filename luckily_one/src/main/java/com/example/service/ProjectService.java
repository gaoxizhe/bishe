package com.example.service;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:15
 */

import com.example.dao.ProjectDao;
import com.example.model.Project;
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
public class ProjectService {

    @Resource
    private ProjectDao projectDao;



    public PageInfo<Project> getProjectList(Integer page, Integer limit,Integer year,String level) {
        PageHelper.startPage(page, limit);
        List<Project> pageList = projectDao.getProjectPageListBySearch(year,level);
        return new PageInfo<>(pageList);

    }

    public List<Project> getProjectList() {
        List<Project> projects = projectDao.getProjectPageList();
        return projects ;
    }

    public Project getProjectById(Integer id) {
        return projectDao.getProjectById(id);
    }

    public void updateProject(Project project) {
        if (project.getId() == null || project.getId().equals(0)) {
            projectDao.insertProject(project);
        } else {
            projectDao.updateProjectById(project);
        }
    }

    public void deleteProjectById(Integer id) {
        projectDao.deleteProjectById(id);
    }
}
