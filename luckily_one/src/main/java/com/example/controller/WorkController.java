package com.example.controller;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:12
 */

import com.example.base.RestListResponse;
import com.example.base.RestResponseBase;
import com.example.base.RestResponsePage;
import com.example.constant.StatusConstant;
import com.example.model.Work;
import com.example.service.WorkService;
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
public class WorkController {

    @Resource
    private WorkService WorkService;

    @GetMapping("/work/list")
    //page=1&limit=10
    public RestListResponse<Work> WorkList(@RequestParam(value = "page") Integer page,
                                           @RequestParam(value = "limit") Integer limit,
                                           @RequestParam(value = "related" ,required = false) String related) {
        if (page == null || page < 0) {
            page = 0;
        }
        if (limit == null || limit < 0) {
            limit = 0;
        }

        log.info("page: {} , limit : {}", page, limit);

        PageInfo<Work> info = WorkService.getWorkList(page, limit,related);

        RestListResponse<Work> response = new RestListResponse<>();
        RestResponsePage responsePage = new RestResponsePage();
        responsePage.setTotalCount(Integer.parseInt(String.valueOf(info.getTotal())));

        response.setCode(StatusConstant.Common.SUCCESS);
        response.setMsg(StatusConstant.Common.SUCCESS_MSG);
        response.setData(info.getList());
        response.setPage(responsePage);
        return response;
    }

    @PostMapping("/work")
    public RestResponseBase updateClass(@RequestParam Map<String, Object> params) {

        Work work = new Work();
        work.setId(params.get("id") == null || params.get("id").equals("") ? 0 : Integer.parseInt(params.get("id").toString()));
        work.setStudent(params.get("student") == null || params.get("student").equals("") ? 0 : Integer.parseInt(params.get("student").toString()));
        work.setEmploymentUnit((String) params.get("employmentUnit"));
        work.setUnitNature((String) params.get("unitNature"));
        work.setWork((String) params.get("work"));
        work.setTime((String) params.get("time"));
        work.setPhone((String) params.get("phone"));
        work.setContacts((String) params.get("contacts"));
        work.setContactUnit((String) params.get("contactUnit"));
        work.setRelated((String) params.get("related"));

        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (work == null || work.getStudent() == null) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
        }

        WorkService.updateWork(work);

        return restResponseBase;
    }

    @DeleteMapping("/work/{id}")
    public RestResponseBase updateUser(@PathVariable("id") Integer id) {

        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (id == null || id.equals("")) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
            return restResponseBase;
        }

        WorkService.deleteWorkById(id);
        return restResponseBase;
    }
}
