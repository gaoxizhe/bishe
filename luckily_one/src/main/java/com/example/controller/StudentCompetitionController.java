package com.example.controller;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:12
 */

import com.example.base.RestListResponse;
import com.example.base.RestResponseBase;
import com.example.base.RestResponsePage;
import com.example.constant.StatusConstant;
import com.example.model.StudentCompetition;
import com.example.service.StudentCompetitionService;
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
public class StudentCompetitionController {

    @Resource
    private StudentCompetitionService StudentCompetitionService;


    @GetMapping("/student_competition/list")
    //page=1&limit=10
    public RestListResponse<StudentCompetition> StudentCompetitionList(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {
        if (page == null || page < 0) {
            page = 0;
        }
        if (limit == null || limit < 0) {
            limit = 0;
        }

        log.info("page: {} , limit : {}", page, limit);

        PageInfo<StudentCompetition> info = StudentCompetitionService.getStudentCompetitionList(page, limit);

        RestListResponse<StudentCompetition> response = new RestListResponse<>();
        RestResponsePage responsePage = new RestResponsePage();
        responsePage.setTotalCount(Integer.parseInt(String.valueOf(info.getTotal())));

        response.setCode(StatusConstant.Common.SUCCESS);
        response.setMsg(StatusConstant.Common.SUCCESS_MSG);
        response.setData(info.getList());
        response.setPage(responsePage);
        return response;
    }


    @PostMapping("/student_competition")
    public RestResponseBase updateStudentCompetition(@RequestParam Map<String, Object> params) {

        StudentCompetition StudentCompetition = new StudentCompetition();

        StudentCompetition.setId(params.get("id") == null || params.get("id").equals("") ? 0 : Integer.parseInt(params.get("id").toString()));
        StudentCompetition.setHost((String) params.get("host"));
        StudentCompetition.setTeam((String) params.get("team"));
        StudentCompetition.setTeacher((String) params.get("teacher"));
        StudentCompetition.setCompetitionName((String) params.get("competitionName"));
        StudentCompetition.setProjectId(params.get("projectId") == null || params.get("projectId").equals("") ? 0 : Integer.parseInt(params.get("projectId").toString()));
        StudentCompetition.setDate((String) params.get("date"));
        StudentCompetition.setAwards((String) params.get("awards"));
        StudentCompetition.setWorkload((String) params.get("workload"));

        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (StudentCompetition == null || StudentCompetition.getProjectName() == null) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
        }

        StudentCompetitionService.updateStudentCompetition(StudentCompetition);

        return restResponseBase;
    }


    @DeleteMapping("/student_competition/{id}")
    public RestResponseBase updateStudentCompetition(@PathVariable("id") Integer id) {


        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (id == null || id.equals("")) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
            return restResponseBase;
        }

        StudentCompetitionService.deleteStudentCompetitionById(id);
        return restResponseBase;
    }
}
