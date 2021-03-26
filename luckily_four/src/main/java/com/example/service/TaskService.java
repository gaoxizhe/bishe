package com.example.service;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:15
 */

import com.alibaba.fastjson.JSON;
import com.example.dao.CourseDao;
import com.example.dao.TaskDao;
import com.example.model.Course;
import com.example.model.Task;
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
public class TaskService {

    @Resource
    private TaskDao taskDao;

    public PageInfo<Task> getTaskList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Task> taskPageList = taskDao.getTaskPageList();

        return new PageInfo<>(taskPageList);

    }

    public List<Task> getTaskList() {
        List<Task> tasks = taskDao.getTaskPageList();
        return tasks ;
    }

    public Task getTaskById(Integer id) {
        return taskDao.getTaskById(id);
    }

    public void updateTask(Task task) {
        if (task.getId() == null || task.getId().equals(0)) {
            log.info("insertTask:{}", JSON.toJSONString(task));
            taskDao.insertTask(task);
        } else {
            log.info("updateTaskById:{}", JSON.toJSONString(task));
            taskDao.updateTaskById(task);
        }
    }

    public void deleteTaskById(Integer id) {
        taskDao.deleteTaskById(id);
    }
}
