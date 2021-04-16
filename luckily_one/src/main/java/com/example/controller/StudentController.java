package com.example.controller;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:12
 */

import com.example.base.RestListResponse;
import com.example.base.RestResponseBase;
import com.example.base.RestResponsePage;
import com.example.constant.StatusConstant;
import com.example.model.Class;
import com.example.model.Student;
import com.example.service.ClassService;
import com.example.service.StudentService;
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
public class StudentController {

    @Resource
    private StudentService studentService;



    @GetMapping("/student/list")
    //page=1&limit=10
    public RestListResponse<Student> studentList(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {
        if (page == null || page < 0) {
            page = 0;
        }
        if (limit == null || limit < 0) {
            limit = 0;
        }

        log.info("page: {} , limit : {}", page, limit);

        PageInfo<Student> info = studentService.getStudentList(page, limit);

        RestListResponse<Student> response = new RestListResponse<>();
        RestResponsePage responsePage = new RestResponsePage();
        responsePage.setTotalCount(Integer.parseInt(String.valueOf(info.getTotal())));

        response.setCode(StatusConstant.Common.SUCCESS);
        response.setMsg(StatusConstant.Common.SUCCESS_MSG);
        response.setData(info.getList());
        response.setPage(responsePage);
        return response;
    }


    @PostMapping("/student")
    public RestResponseBase updateClass(@RequestParam Map<String, Object> params) {

        Student student = new Student();
        student.setId(params.get("id") == null || params.get("id").equals("") ? 0 : Integer.parseInt(params.get("id").toString()));
        student.setClassId(params.get("classId") == null || params.get("classId").equals("") ? 0 : Integer.parseInt(params.get("classId").toString()));
        student.setName((String) params.get("name"));
        student.setPhone((String) params.get("phone"));
        student.setTeacherId(params.get("teacherId") == null || params.get("teacherId").equals("") ? 0 : Integer.parseInt(params.get("teacherId").toString()));
        student.setInstructorId(params.get("instructorId") == null || params.get("instructorId").equals("") ? 0 : Integer.parseInt(params.get("instructorId").toString()));


        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (student == null || student.getName() == null) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
        }

        studentService.updateStudent(student);

        return restResponseBase;
    }


    @DeleteMapping("/student/{id}")
    public RestResponseBase updateUser(@PathVariable("id") Integer id) {


        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (id == null || id.equals("")) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
            return restResponseBase;
        }

        studentService.deleteStudentById(id);
        return restResponseBase;
    }
}
