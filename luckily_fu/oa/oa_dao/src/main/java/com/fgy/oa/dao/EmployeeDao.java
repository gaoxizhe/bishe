package com.fgy.oa.dao;

import com.fgy.oa.domain.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 员工持久层接口
 */
@Repository("employeeDao")
public interface EmployeeDao {

    /**
     * 新增员工
     * @param employee
     */
    @Insert("insert into employee values(#{sn}, #{password}, #{name}, #{department_sn}, #{post})")
    void insert(Employee employee);

    /**
     * 更新员工信息
     * @param employee
     */
    @Update("update employee set password = #{password}, name = #{name}, department_sn = #{department_sn}, post = #{post} where sn = #{sn}")
    void update(Employee employee);

    /**
     * 删除员工
     * @param sn
     */
    @Delete("delete from employee where sn = #{sn}")
    void delete(String sn);

    /**
     * 根据员工编号查询员工
     * @param sn
     * @return
     */
    @Select("select * from employee where sn = #{sn}")
    Employee select(String sn);

    /**
     * 查询所有员工
     * @return
     */
    @Select("select * from employee")
    List<Employee> selectAll();

    /**
     * 根据部门编号和职位查询员工
     * @param dsn
     * @param post
     * @return
     */
    List<Employee> selectByDepartmentAndPost(@Param("dsn") String dsn, @Param("post") String post);
}
