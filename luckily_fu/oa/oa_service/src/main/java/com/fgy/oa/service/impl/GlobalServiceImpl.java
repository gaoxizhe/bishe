package com.fgy.oa.service.impl;

import com.fgy.oa.dao.DepartmentDao;
import com.fgy.oa.dao.EmployeeDao;
import com.fgy.oa.domain.Department;
import com.fgy.oa.domain.Employee;
import com.fgy.oa.service.GlobalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 全局业务层实现类
 */
@Service("globalService")
public class GlobalServiceImpl implements GlobalService {

    @Resource(name = "employeeDao")
    private EmployeeDao employeeDao;
    @Resource(name = "departmentDao")
    private DepartmentDao departmentDao;

    /**
     * 用户登录
     * @param sn
     * @param password
     * @return
     */
    @Override
    public Employee login(String sn, String password) {
        Employee employee = employeeDao.select(sn);
        if (employee != null && employee.getPassword().equals(password)) {
            String department_sn = employee.getDepartment_sn();
            Department department = departmentDao.select(department_sn);
            employee.setDepartment(department);
            return employee;
        }
        return null;
    }

    /**
     * 用户修改密码
     * @param employee
     */
    @Override
    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
