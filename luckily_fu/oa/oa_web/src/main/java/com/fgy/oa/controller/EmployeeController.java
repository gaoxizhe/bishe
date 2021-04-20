package com.fgy.oa.controller;

import com.fgy.oa.domain.Department;
import com.fgy.oa.domain.Employee;
import com.fgy.oa.global.Constant;
import com.fgy.oa.service.DepartmentService;
import com.fgy.oa.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工控制层
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Resource(name = "employeeService")
    private EmployeeService employeeService;
    @Resource(name = "departmentService")
    private DepartmentService departmentService;

    /**
     * 查询所有员工信息
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        List<Employee> employees = employeeService.getAll();

        mv.addObject("employees", employees);
        mv.setViewName("employee_list");
        return mv;
    }

    /**
     * 跳转到添加员工页面
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView();
        List<String> posts = Constant.getPosts();
        List<Department> departments = departmentService.getAll();
        mv.addObject("posts", posts);
        mv.addObject("departments", departments);
        mv.setViewName("employee_add");
        return mv;
    }

    /**
     * 添加员工信息
     * @return
     */
    @RequestMapping("/save")
    public String save(Employee employee) {
        employeeService.add(employee);
        return "redirect:/employee/findAll";
    }

    /**
     * 跳转到编辑员工页面
     * @param sn
     * @return
     */
    @RequestMapping(path = "/edit/{sn}")
    public ModelAndView edit(@PathVariable("sn") String sn) {
        ModelAndView mv = new ModelAndView();
        Employee employee = employeeService.get(sn);
        List<String> posts = Constant.getPosts();
        List<Department> departments = departmentService.getAll();
        mv.addObject("employee", employee);
        mv.addObject("posts", posts);
        mv.addObject("departments", departments);
        mv.setViewName("employee_update");
        return mv;
    }

    /**
     * 更新员工信息
     * @param employee
     * @return
     */
    @RequestMapping("/update")
    public String update(Employee employee) {
        employeeService.edit(employee);
        return "redirect:/employee/findAll";
    }

    /**
     * 删除员工
     * @param sn
     * @return
     */
    @RequestMapping("/remove/{sn}")
    public String remove(@PathVariable("sn") String sn) {
        employeeService.remove(sn);
        return "redirect:/employee/findAll";
    }
}
