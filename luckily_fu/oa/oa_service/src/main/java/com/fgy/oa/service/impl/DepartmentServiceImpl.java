package com.fgy.oa.service.impl;

import com.fgy.oa.dao.DepartmentDao;
import com.fgy.oa.domain.Department;
import com.fgy.oa.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门业务层实现类
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Resource(name = "departmentDao")
    private DepartmentDao departmentDao;

    /**
     * 添加部门
     * @param department
     */
    @Override
    public void add(Department department) {
        departmentDao.insert(department);
    }

    /**
     * 编辑部门
     * @param department
     */
    @Override
    public void edit(Department department) {
        departmentDao.update(department);
    }

    /**
     * 删除部门
     * @param sn
     */
    @Override
    public void remove(String sn) {
        departmentDao.delete(sn);
    }

    /**
     * 根据部门编号查询部门
     * @param sn
     * @return
     */
    @Override
    public Department get(String sn) {
        return departmentDao.select(sn);
    }

    /**
     * 查询所有部门
     * @return
     */
    @Override
    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
