package com.example.service;/**
 * @author : Mr.Gao
 * @date :   2021/3/19 下午9:31
 */

import com.example.constant.BaseContextHandler;
import com.example.dao.CarDao;
import com.example.dao.UserDao;
import com.example.model.Car;
import com.example.model.StopCar;
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










    public PageInfo<Car> getCarPageList(Integer page, Integer limit, Integer status) {
        PageHelper.startPage(page, limit);
        List<Car> usersList = carDao.getCarListByStatus(status);

        return new PageInfo<>(usersList);
    }

    public Car getCarById(Integer id) {
        return carDao.selectCarById(id);
    }

    public void updateCar(Car car) {
        if (car.getId() == 0) {
            carDao.insertCar(car);
        } else {
            carDao.updateCar(car);
        }
    }

    public void updateStatus(Integer id, Integer status) {
        carDao.updateCarStatusById(id, status);
    }

    public PageInfo<StopCar> getStopCarByPsId(Integer page, Integer limit, Integer id) {
        PageHelper.startPage(page, limit);
        List<StopCar> stopCarList = carDao.getStopCarByPsId(id);

        return new PageInfo<>(stopCarList);
    }
}
