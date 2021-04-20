package com.fgy.oa.service;

import com.fgy.oa.domain.Employee;

/**
 * 全局业务层接口
 */
public interface GlobalService {

    /**
     * 用户登录
     * @param sn
     * @param password
     * @return
     */
    Employee login(String sn, String password);

    /**
     * 用户修改密码
     * @param employee
     */
    void changePassword(Employee employee);
}
