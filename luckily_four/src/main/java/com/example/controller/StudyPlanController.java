package com.example.controller;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:12
 */

import com.example.base.RestListResponse;
import com.example.base.RestResponseBase;
import com.example.base.RestResponsePage;
import com.example.constant.StatusConstant;
import com.example.model.Course;
import com.example.service.CourseService;
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
public class StudyPlanController {


    @Resource
    private CourseService courseService;



    @GetMapping("/study_plan/list")
    //page=1&limit=10
    public RestListResponse<Course> CourseList(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {
        if (page == null || page < 0) {
            page = 0;
        }
        if (limit == null || limit < 0) {
            limit = 0;
        }

        log.info("page: {} , limit : {}", page, limit);

        PageInfo<Course> info = courseService.getCourseList(page, limit);

        RestListResponse<Course> response = new RestListResponse<>();
        RestResponsePage responsePage = new RestResponsePage();
        responsePage.setTotalCount(info.getSize());

        response.setCode(StatusConstant.Common.SUCCESS);
        response.setMsg(StatusConstant.Common.SUCCESS_MSG);
        response.setData(info.getList());
        response.setPage(responsePage);
        return response;
    }


    @PostMapping("/study_plan")
    public RestResponseBase updateCourse(@RequestParam Map<String, Object> params) {

        Course course = new Course();
        course.setId(params.get("id") == null || params.get("id").equals("") ? 0 : Integer.parseInt(params.get("id").toString()));
        course.setProfessionId(params.get("professionId") == null || params.get("professionId").equals("") ? 0 : Integer.parseInt(params.get("professionId").toString()));
        course.setClassId(params.get("classId") == null || params.get("classId").equals("") ? 0 : Integer.parseInt(params.get("classId").toString()));
        course.setUserId(params.get("userId") == null || params.get("userId").equals("") ? 0 : Integer.parseInt(params.get("userId").toString()));

        course.setCourseName((String) params.get("courseName"));
        course.setContent((String) params.get("content"));


        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);


        courseService.updateCourse(course);

        return restResponseBase;
    }


    @DeleteMapping("/study_plan/{id}")
    public RestResponseBase updateCourse(@PathVariable("id") Integer id) {


        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (id == null || id.equals("")) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
            return restResponseBase;
        }

        courseService.deleteCourseById(id);
        return restResponseBase;
    }
}
