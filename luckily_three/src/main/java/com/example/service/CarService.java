package com.example.service;/**
 * @author : Mr.Gao
 * @date :   2021/3/19 下午9:31
 */

import com.example.constant.BaseContextHandler;
import com.example.dao.CarDao;
import com.example.dao.UserDao;
import com.example.model.Car;
import com.example.model.Users;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserService
 * @Author Mr.Gao
 * @Date 2021/3/19 下午9:31
 * @Description TODO | 
 */
@Service
public class CarService {

    @Resource
    private UserDao userDao;

    @Resource
    private CarDao carDao;



    public PageInfo<Users> getUserPageList(Integer page, Integer limit) {

        Integer id = BaseContextHandler.getUser().getId();
        String role = BaseContextHandler.getUser().getRoleName();
        PageHelper.startPage(page, limit);
        List<Users> usersList = userDao.getUserPageByRole(2);

        return new PageInfo<>(usersList);
    }

    public Users getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public void updateUserInfoByUsername(Users users) {
        //新增
        if (users.getId() == null || users.getId().equals(0)) {
            users.setRole(2);
            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            String pass = passwordEncoder.encode(users.getPassword());
            users.setPassword(pass);
            userDao.insertUser(users);
        } else {
            userDao.updateUserInfoById(users);
        }


    }

    public void updateUserPassword(Users users) {

        String password = users.getPassword();
        if (password != null && !password.equals("")) {
            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            String pass = passwordEncoder.encode(password);
            users.setPassword(pass);
            userDao.updateUserPassword(users);
        }

    }

    public void deleteUserById(Integer id) {
        userDao.deleteUserById(id);
    }

    public PageInfo<Car> getCarPageList(Integer page, Integer limit, Integer status) {
        PageHelper.startPage(page, limit);
        List<Car> usersList = carDao.getCarListByStatus(status);

        return new PageInfo<>(usersList);
    }
}
