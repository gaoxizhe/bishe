package com.example.controller;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:12
 */

import com.example.base.RestListResponse;
import com.example.base.RestResponseBase;
import com.example.base.RestResponsePage;
import com.example.constant.StatusConstant;
import com.example.model.Course;
import com.example.model.Task;
import com.example.service.CourseService;
import com.example.service.TaskService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName ProfessionController
 * @Author Mr.Gao
 * @Date 2021/3/23 下午10:12
 * @Description TODO | 
 */

@RestController
@RequestMapping("/admin")
@Slf4j
public class TaskController {

    @Resource
    private TaskService taskService;



    @GetMapping("/task/list")
    //page=1&limit=10
    public RestListResponse<Task> TaskList(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {
        if (page == null || page < 0) {
            page = 0;
        }
        if (limit == null || limit < 0) {
            limit = 0;
        }

        log.info("page: {} , limit : {}", page, limit);

        PageInfo<Task> info = taskService.getTaskList(page, limit);

        RestListResponse<Task> response = new RestListResponse<>();
        RestResponsePage responsePage = new RestResponsePage();
        responsePage.setTotalCount(info.getSize());

        response.setCode(StatusConstant.Common.SUCCESS);
        response.setMsg(StatusConstant.Common.SUCCESS_MSG);
        response.setData(info.getList());
        response.setPage(responsePage);
        return response;
    }


    @PostMapping("/task")
    public RestResponseBase updateTask(@RequestParam Map<String, Object> params) {

        Task task = new Task();
        task.setId(params.get("id") == null || params.get("id").equals("") ? 0 : Integer.parseInt(params.get("id").toString()));
        task.setCourseId(params.get("courseId") == null || params.get("courseId").equals("") ? 0 : Integer.parseInt(params.get("courseId").toString()));
        task.setUserId(params.get("userId") == null || params.get("userId").equals("") ? 0 : Integer.parseInt(params.get("userId").toString()));
        task.setContent((String) params.get("content"));
        task.setName((String) params.get("name"));


        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);


        taskService.updateTask(task);

        return restResponseBase;
    }


    @DeleteMapping("/task/{id}")
    public RestResponseBase updateTask(@PathVariable("id") Integer id) {


        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (id == null || id.equals("")) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
            return restResponseBase;
        }

        taskService.deleteTaskById(id);
        return restResponseBase;
    }
}
