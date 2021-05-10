package com.example.service;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:15
 */

import com.example.dao.WorkDao;
import com.example.model.Work;
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
public class WorkService {

    @Resource
    private WorkDao WorkDao;



    public PageInfo<Work> getWorkList(Integer page, Integer limit, String related) {
        PageHelper.startPage(page, limit);
        List<Work> pageList = WorkDao.getWorkPageListBySearch(related);

        return new PageInfo<>(pageList);

    }

    public List<Work> getWorkList() {
        List<Work> Works = WorkDao.getWorkPageList();
        return Works ;
    }

    public Work getWorkById(Integer id) {
        return WorkDao.getWorkById(id);
    }

    public void updateWork(Work Work) {
        if (Work.getId() == null || Work.getId().equals(0)) {
            WorkDao.insertWork(Work);
        } else {
            WorkDao.updateWorkById(Work);
        }
    }

    public void deleteWorkById(Integer id) {
        WorkDao.deleteWorkById(id);
    }
}
