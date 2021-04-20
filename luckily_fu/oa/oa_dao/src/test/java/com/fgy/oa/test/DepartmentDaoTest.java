package com.fgy.oa.test;

import com.fgy.oa.dao.DepartmentDao;
import com.fgy.oa.domain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-dao.xml")
public class DepartmentDaoTest {

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 测试插入部门信息
     */
    @Test
    public void testInsert() {
        Department department = new Department();
        department.setSn("10004");
        department.setName("人事部");
        department.setAddress("广东");
        departmentDao.insert(department);
    }

    /**
     * 测试更新部门信息
     */
    @Test
    public void testUpdate() {
        Department department = departmentDao.select("10004");
        department.setAddress("广东广州");
        departmentDao.update(department);
    }

    /**
     * 测试删除部门信息
     */
    @Test
    public void testDelete() {
        departmentDao.delete("10004");
    }

    /**
     * 测试根据部门编号查询部门信息
     */
    @Test
    public void testSelect() {
        Department department = departmentDao.select("10003");
        System.out.println(department);
    }

    /**
     * 测试查询所有部门信息
     */
    @Test
    public void testSelectAll() {
        List<Department> departments = departmentDao.selectAll();
        for (Department department : departments) {
            System.out.println(department);
        }
    }
}
