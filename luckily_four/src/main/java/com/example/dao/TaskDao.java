package com.example.dao;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:16
 */

import com.example.model.Course;
import com.example.model.Task;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @CourseName ProFessionDao
 * @Author Mr.Gao
 * @Date 2021/3/23 下午10:16
 * @Description TODO | 
 */
@Repository
public interface TaskDao {
    List<Task> getTaskPageList();

    Task getTaskById(@Param("id") Integer id);

    void insertTask(Task task);

    void updateTaskById(Task task);

    void deleteTaskById(@Param("id") Integer id);
}
