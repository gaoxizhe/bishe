package com.example.dao;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:16
 */

import com.example.model.Class;
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
public interface StudentDao {
    List<Class> getClassPageList();

    Class getClassById(@Param("id") Integer id);

    void insertClass(@Param("pId") Integer professionId, @Param("name") String name);

    void updateClassById(@Param("id") Integer clazzId, @Param("pId") Integer id, @Param("name") String name);

    void deleteClassById(@Param("id") Integer id);
}
