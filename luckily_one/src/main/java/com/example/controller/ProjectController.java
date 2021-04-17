package com.example.controller;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:12
 */

import com.example.base.RestListResponse;
import com.example.base.RestResponseBase;
import com.example.base.RestResponsePage;
import com.example.constant.StatusConstant;
import com.example.model.Project;
import com.example.model.Student;
import com.example.service.ProjectService;
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
public class ProjectController {

    @Resource
    private ProjectService projectService;



    @GetMapping("/project/list")
    //page=1&limit=10
    public RestListResponse<Project> projectList(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {
        if (page == null || page < 0) {
            page = 0;
        }
        if (limit == null || limit < 0) {
            limit = 0;
        }

        log.info("page: {} , limit : {}", page, limit);

        PageInfo<Project> info = projectService.getProjectList(page, limit);

        RestListResponse<Project> response = new RestListResponse<>();
        RestResponsePage responsePage = new RestResponsePage();
        responsePage.setTotalCount(Integer.parseInt(String.valueOf(info.getTotal())));

        response.setCode(StatusConstant.Common.SUCCESS);
        response.setMsg(StatusConstant.Common.SUCCESS_MSG);
        response.setData(info.getList());
        response.setPage(responsePage);
        return response;
    }


    @PostMapping("/project")
    public RestResponseBase updateProject(@RequestParam Map<String, Object> params) {

        Project project = new Project();

        project.setId(params.get("id") == null || params.get("id").equals("") ? 0 : Integer.parseInt(params.get("id").toString()));
        project.setApplicant((String) params.get("applicant"));
        project.setInstructor((String) params.get("instructor"));
        project.setName((String) params.get("name"));
        project.setMember((String) params.get("member"));
        project.setApprovalStatus(params.get("approvalStatus") == null || params.get("approvalStatus").equals("") ? 0 : Integer.parseInt(params.get("approvalStatus").toString()));
        project.setYear((String) params.get("year"));
        project.setCompletion(params.get("completion") == null || params.get("completion").equals("") ? 0 : Integer.parseInt(params.get("completion").toString()));
        project.setFunding((String) params.get("funding"));
        project.setWorkload((String) params.get("workload"));

        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (project == null || project.getName() == null) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
        }

        projectService.updateProject(project);

        return restResponseBase;
    }


    @DeleteMapping("/project/{id}")
    public RestResponseBase updateProject(@PathVariable("id") Integer id) {


        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (id == null || id.equals("")) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
            return restResponseBase;
        }

        projectService.deleteProjectById(id);
        return restResponseBase;
    }
}
