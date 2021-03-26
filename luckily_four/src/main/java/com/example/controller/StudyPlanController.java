package com.example.controller;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:12
 */

import com.example.base.RestListResponse;
import com.example.base.RestResponseBase;
import com.example.base.RestResponsePage;
import com.example.constant.StatusConstant;
import com.example.model.Course;
import com.example.model.StudyPlan;
import com.example.service.CourseService;
import com.example.service.StudyPlanService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@Slf4j
public class StudyPlanController {


    @Resource
    private StudyPlanService studyPlanService;



    @GetMapping("/study_plan/list")
    //page=1&limit=10
    public RestListResponse<StudyPlan> StudyPlanList(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {
        if (page == null || page < 0) {
            page = 0;
        }
        if (limit == null || limit < 0) {
            limit = 0;
        }

        log.info("page: {} , limit : {}", page, limit);

        PageInfo<StudyPlan> info = studyPlanService.getStudyPlanList(page, limit);

        RestListResponse<StudyPlan> response = new RestListResponse<>();
        RestResponsePage responsePage = new RestResponsePage();
        responsePage.setTotalCount(info.getSize());

        response.setCode(StatusConstant.Common.SUCCESS);
        response.setMsg(StatusConstant.Common.SUCCESS_MSG);
        response.setData(info.getList());
        response.setPage(responsePage);
        return response;
    }


    @PostMapping("/study_plan")
    public RestResponseBase updateStudyPlan(@RequestParam Map<String, Object> params) {

        StudyPlan studyPlan = new StudyPlan();
        studyPlan.setId(params.get("id") == null || params.get("id").equals("") ? 0 : Integer.parseInt(params.get("id").toString()));
        studyPlan.setCourseId(params.get("courseId") == null || params.get("courseId").equals("") ? 0 : Integer.parseInt(params.get("courseId").toString()));
        studyPlan.setUserId(params.get("userId") == null || params.get("userId").equals("") ? 0 : Integer.parseInt(params.get("userId").toString()));
        studyPlan.setTime((String) params.get("time") );
        studyPlan.setContent((String) params.get("content"));
        studyPlan.setName((String) params.get("name"));


        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);


        studyPlanService.updateStudyPlan(studyPlan);

        return restResponseBase;
    }


    @DeleteMapping("/study_plan/{id}")
    public RestResponseBase updateStudyPlan(@PathVariable("id") Integer id) {


        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (id == null || id.equals("")) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
            return restResponseBase;
        }

        studyPlanService.deleteStudyPlanById(id);
        return restResponseBase;
    }
}
