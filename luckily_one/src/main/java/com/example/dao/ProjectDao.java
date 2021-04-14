package com.example.dao;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:16
 */

import com.example.model.Project;
import com.example.model.Student;
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
public interface ProjectDao {
    List<Project> getProjectPageList();

    Project getProjectById(@Param("id") Integer id);

    void insertProject(Project student);

    void updateProjectById(Project student);

    void deleteProjectById(@Param("id") Integer id);
}
