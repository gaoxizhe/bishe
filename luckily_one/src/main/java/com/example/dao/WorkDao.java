package com.example.dao;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:16
 */

import com.example.model.Work;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName ProFessionDao
 * @Author Mr.Gao
 * @Date 2021/3/23 下午10:16
 * @Description TODO | 
 */
@Repository
public interface WorkDao {
    List<Work> getWorkPageList();

    Work getWorkById(@Param("id") Integer id);

    void insertWork(Work Work);

    void updateWorkById(Work Work);

    void deleteWorkById(@Param("id") Integer id);
}
