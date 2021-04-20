package com.fgy.oa.service.impl;

import com.fgy.oa.dao.DepartmentDao;
import com.fgy.oa.dao.EmployeeDao;
import com.fgy.oa.domain.Department;
import com.fgy.oa.domain.Employee;
import com.fgy.oa.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工业务层实现类
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Resource(name = "employeeDao")
    private EmployeeDao employeeDao;
    @Resource(name = "departmentDao")
    private DepartmentDao departmentDao;

    /**
     * 添加员工
     * @param employee
     */
    @Override
    public void add(Employee employee) {
        employee.setPassword("000000"); // 默认密码
        employeeDao.insert(employee);
    }

    /**
     * 编辑员工信息
     * @param employee
     */
    @Override
    public void edit(Employee employee) {
        employeeDao.update(employee);
    }

    /**
     * 删除员工
     * @param sn
     */
    @Override
    public void remove(String sn) {
        employeeDao.delete(sn);
    }

    /**
     * 根据员工编号查询员工
     * @param sn
     * @return
     */
    @Override
    public Employee get(String sn) {
        return employeeDao.select(sn);
    }

    /**
     * 查询所有员工
     * @return
     */
    @Override
    public List<Employee> getAll() {
        List<Employee> employees = employeeDao.selectAll();
        for (Employee employee : employees) {
            String sn = employee.getDepartment_sn();
            Department department = departmentDao.select(sn);
            employee.setDepartment(department);
        }
        return employees;
    }
}
