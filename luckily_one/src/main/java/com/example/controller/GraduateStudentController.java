package com.example.controller;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:12
 */

import com.example.base.RestListResponse;
import com.example.base.RestResponseBase;
import com.example.base.RestResponsePage;
import com.example.constant.StatusConstant;
import com.example.model.GraduateStudent;
import com.example.service.GraduateStudentService;
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

public class GraduateStudentController {

    @Resource
    private GraduateStudentService GraduateStudentService;


    @GetMapping("/graduate_student/list")
    //page=1&limit=10
    public RestListResponse<GraduateStudent> GraduateStudentList(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {
        if (page == null || page < 0) {
            page = 0;
        }
        if (limit == null || limit < 0) {
            limit = 0;
        }

        log.info("page: {} , limit : {}", page, limit);

        PageInfo<GraduateStudent> info = GraduateStudentService.getGraduateStudentList(page, limit);

        RestListResponse<GraduateStudent> response = new RestListResponse<>();
        RestResponsePage responsePage = new RestResponsePage();
        responsePage.setTotalCount(Integer.parseInt(String.valueOf(info.getTotal())));

        response.setCode(StatusConstant.Common.SUCCESS);
        response.setMsg(StatusConstant.Common.SUCCESS_MSG);
        response.setData(info.getList());
        response.setPage(responsePage);
        return response;
    }


    @PostMapping("/graduate_student")
    public RestResponseBase updateGraduateStudent(@RequestParam Map<String, Object> params) {

        GraduateStudent GraduateStudent = new GraduateStudent();

        GraduateStudent.setId(params.get("id") == null || params.get("id").equals("") ? 0 : Integer.parseInt(params.get("id").toString()));
        GraduateStudent.setName((String) params.get("name"));
        GraduateStudent.setSchool((String) params.get("school"));
        GraduateStudent.setMajor((String) params.get("major"));
        GraduateStudent.setDegree((String) params.get("degree"));
        GraduateStudent.setAdmissionCategory((String) params.get("admissionCategory"));
        GraduateStudent.setStudentType((String) params.get("studentType"));


        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (GraduateStudent == null || GraduateStudent.getName() == null) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
        }

        GraduateStudentService.updateGraduateStudent(GraduateStudent);

        return restResponseBase;
    }


    @DeleteMapping("/graduate_student/{id}")
    public RestResponseBase updateGraduateStudent(@PathVariable("id") Integer id) {


        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (id == null || id.equals("")) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
            return restResponseBase;
        }

        GraduateStudentService.deleteGraduateStudentById(id);
        return restResponseBase;
    }
}
