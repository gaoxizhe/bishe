package com.fgy.oa.service;

import com.fgy.oa.domain.Department;

import java.util.List;

/**
 * 部门业务层接口
 */
public interface DepartmentService {

    /**
     * 添加部门
     * @param department
     */
    void add(Department department);

    /**
     * 编辑部门
     * @param department
     */
    void edit(Department department);

    /**
     * 删除部门
     * @param sn
     */
    void remove(String sn);

    /**
     * 根据部门编号查询部门
     * @param sn
     * @return
     */
    Department get(String sn);

    /**
     * 查询所有部门
     * @return
     */
    List<Department> getAll();
}
