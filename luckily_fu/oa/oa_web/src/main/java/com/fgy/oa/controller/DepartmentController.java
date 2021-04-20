package com.fgy.oa.controller;

import com.fgy.oa.domain.Department;
import com.fgy.oa.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门控制层
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Resource(name = "departmentService")
    private DepartmentService departmentService;

    /**
     * 查询所有部门信息
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        List<Department> departments = departmentService.getAll();
        mv.addObject("departments", departments);
        mv.setViewName("department_list");
        return mv;
    }

    /**
     * 跳转到添加部门页面
     * @return
     */
    @RequestMapping("/add")
    public String add() {
        return "department_add";
    }

    /**
     * 添加部门信息
     * @return
     */
    @RequestMapping("/save")
    public String save(Department department) {
        departmentService.add(department);
        return "redirect:/department/findAll";
    }

    /**
     * 跳转到编辑部门页面
     * @param sn
     * @return
     */
    @RequestMapping(path = "/edit/{sn}")
    public ModelAndView edit(@PathVariable("sn") String sn) {
        ModelAndView mv = new ModelAndView();
        Department department = departmentService.get(sn);
        mv.addObject("dept", department);
        mv.setViewName("department_update");
        return mv;
    }

    /**
     * 更新部门信息
     * @param department
     * @return
     */
    @RequestMapping("/update")
    public String update(Department department) {
        departmentService.edit(department);
        return "redirect:/department/findAll";
    }

    /**
     * 删除部门
     * @param sn
     * @return
     */
    @RequestMapping("/remove/{sn}")
    public String remove(@PathVariable("sn") String sn) {
        departmentService.remove(sn);
        return "redirect:/department/findAll";
    }
}
