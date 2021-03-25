package com.example.router.admin;

import com.alibaba.fastjson.JSON;
import com.example.base.RestEntityResponse;
import com.example.constant.BaseContextHandler;
import com.example.constant.StatusConstant;
import com.example.model.Class;
import com.example.model.Course;
import com.example.model.Profession;
import com.example.model.Users;
import com.example.service.ClassService;
import com.example.service.CourseService;
import com.example.service.ProfessionService;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @ClassName AdminRouter
 * @Author Mr.Gao
 * @Date 2020/3/4 上午10:07
 * @Description:
 */
@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminRouter {

    @Resource
    private UserService userService;

    @Resource
    private ProfessionService professionService;

    @Resource
    private ClassService classService;

    @Resource
    private CourseService courseService;

    @GetMapping({"/index", "/", "index.html", ""})
    public String index() {
        return "admin/index";
    }

    @GetMapping({"/welcome"})
    public String welcome() {
        return "admin/welcome";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        BaseContextHandler.remove();
        return "admin/login";
    }

    //user-===================
    @GetMapping("/toUserList")
    public String toCategoryList(Model model) {
        return "admin/user_list";
    }

    @GetMapping("/toUserEdit/{id}")
    public String toUserEdit(Model model, @PathVariable("id") Integer id) {
        RestEntityResponse restResponseBase = new RestEntityResponse<>();
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        if (id.equals(0)) {
            restResponseBase.setData(new Users());
        } else {
            Users userById = userService.getUserById(id);
            userById.setPassword("密码无法修改");
            restResponseBase.setData(userById);
        }
//        restResponseBase.setCode(StatusConstant.Common.ERROR);
//        restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
        String o = JSON.toJSONString(restResponseBase);
        System.err.println(o);
        model.addAttribute("data", restResponseBase);
        return "admin/user_edit";

    }

    @GetMapping("/toProfessionEdit/{id}")
    public String toProfessionEdit(Model model, @PathVariable("id") Integer id) {
        RestEntityResponse restResponseBase = new RestEntityResponse<>();
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        if (id.equals(0)) {
            restResponseBase.setData(new Users());
        } else {
            Profession profession = professionService.getProfessionById(id);
            restResponseBase.setData(profession);
        }
        String o = JSON.toJSONString(restResponseBase);
        System.err.println(o);
        model.addAttribute("data", restResponseBase);
        return "admin/profession_edit";

    }

    @GetMapping("/toClassEdit/{id}")
    public String toClassEdit(Model model, @PathVariable("id") Integer id) {
        RestEntityResponse restResponseBase = new RestEntityResponse<>();
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        if (id.equals(0)) {
            restResponseBase.setData(new Users());
        } else {
            Class classById = classService.getClassById(id);
            restResponseBase.setData(classById);
        }
        String o = JSON.toJSONString(restResponseBase);
        System.err.println(o);
        model.addAttribute("data", restResponseBase);
        model.addAttribute("pList", professionService.getProfessionList());
        return "admin/class_edit";

    }
    @GetMapping("/toCourseEdit/{id}")
    public String toCourseEdit(Model model, @PathVariable("id") Integer id) {
        RestEntityResponse restResponseBase = new RestEntityResponse<>();
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        if (id.equals(0)) {
            restResponseBase.setData(new Course());
        } else {
            Course course = courseService.getCourseById(id);
            restResponseBase.setData(course);
        }
        String o = JSON.toJSONString(restResponseBase);
        System.err.println(o);
        model.addAttribute("data", restResponseBase);
        model.addAttribute("pList", professionService.getProfessionList());
        model.addAttribute("cList", classService.getClassList());
        model.addAttribute("uList", userService.getuserListByRole(2));
        return "admin/course_edit";

    }

    @GetMapping("/toUserPassword/{id}")
    public String toUserPassword(Model model, @PathVariable("id") Integer id) {
        RestEntityResponse restResponseBase = new RestEntityResponse<>();
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        Users data = new Users();
        if (id.equals(0)) {
            restResponseBase.setData(data);
        } else {
            data.setId(id);
            restResponseBase.setData(data);
        }
//        restResponseBase.setCode(StatusConstant.Common.ERROR);
//        restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
        String o = JSON.toJSONString(restResponseBase);
        System.err.println(o);
        model.addAttribute("data", restResponseBase);
        return "admin/user_password";
    }

    @GetMapping("/toProfessionList")
    public String toProfessionList() {
        return "admin/profession_list";
    }

    @GetMapping("/toClassList")
    public String toClassList() {
        return "admin/class_list";
    }

    @GetMapping("/toCourseInfo")
    public String toCourseInfo() {
        return "admin/course_list";
    }

    @GetMapping("/toStudyPlan")
    public String toStudyPlan() {
        return "admin/study_plan_list";
    }

}