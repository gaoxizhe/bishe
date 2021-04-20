package com.fgy.oa.dao;

import com.fgy.oa.domain.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 部门持久层接口
 */
@Repository("departmentDao")
public interface DepartmentDao {

    /**
     * 插入部门信息
     * @param department
     */
    @Insert("insert into department values(#{sn}, #{name}, #{address})")
    void insert(Department department);

    /**
     * 更新部门信息
     * @param department
     */
    @Update("update department set name = #{name}, address = #{address} where sn = #{sn}")
    void update(Department department);

    /**
     * 删除部门信息
     * @param sn
     */
    @Delete("delete from department where sn = #{sn}")
    void delete(String sn);

    /**
     * 根据部门编号查询部门信息
     * @param sn
     * @return
     */
    @Select("select * from department where sn = #{sn}")
    @Results(id = "departmentMap",
    value = {
            @Result(id = true, column = "sn", property = "sn"),
            @Result(column = "name", property = "name"),
            @Result(column = "address", property = "address")
    })
    Department select(String sn);

    /**
     * 查询所有部门信息
     * @return
     */
    @Select("select * from department")
    @ResultMap("departmentMap")
    List<Department> selectAll();
}
