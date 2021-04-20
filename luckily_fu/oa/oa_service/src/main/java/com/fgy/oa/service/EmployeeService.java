package com.fgy.oa.service;

import com.fgy.oa.domain.Employee;

import java.util.List;

/**
 * 员工业务层接口
 */
public interface EmployeeService {

    /**
     * 添加员工
     * @param employee
     */
    void add(Employee employee);

    /**
     * 编辑员工信息
     * @param employee
     */
    void edit(Employee employee);

    /**
     * 删除员工
     * @param sn
     */
    void remove(String sn);

    /**
     * 根据员工编号查询员工
     * @param sn
     * @return
     */
    Employee get(String sn);

    /**
     * 查询所有员工
     * @return
     */
    List<Employee> getAll();
}
