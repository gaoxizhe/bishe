package com.example.service;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:15
 */

import com.example.dao.ProFessionDao;
import com.example.model.Profession;
import com.example.model.Users;
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
public class ProfessionService {

    @Resource
    private ProFessionDao proFessionDao;



    public PageInfo<Profession> getProfessionList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Profession> professionPageList = proFessionDao.getProfessionPageList();

        return new PageInfo<>(professionPageList);

    }

    public List<Profession> getProfessionList() {
        List<Profession> professionPageList = proFessionDao.getProfessionPageList();
        return professionPageList;
    }

    public Profession getProfessionById(Integer id) {
        return proFessionDao.getProfessionById(id);
    }

    public void updateProfession(Profession profession) {
        if (profession.getId() == null || profession.getId().equals(0)) {
            proFessionDao.insertProfession(profession.getName());
        } else {
            proFessionDao.updateProfessionById(profession.getId(), profession.getName());
        }
    }

    public void deleteProfessionById(Integer id) {
        proFessionDao.deleteProfessionById(id);
    }
}
