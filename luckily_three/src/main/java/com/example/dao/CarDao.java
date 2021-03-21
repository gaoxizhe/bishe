package com.example.dao;

import com.example.model.Car;
import com.example.model.MyCar;
import com.example.model.StopCar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CarDao {
    List<Car> getCarListByStatus(@Param("status") Integer status);

    Car selectCarById(@Param("id") Integer id);

    void insertCar(Car car);

    void updateCar(Car car);

    void updateCarStatusById(@Param("id") Integer id,@Param("status") Integer status);

    List<StopCar> getStopCarByPsId(@Param("id") Integer id);

    List<Car> getMyCarPageList(@Param("id") Integer id);

    void insertMyCar(@Param("userId") Integer userId,@Param("numberPlate") String numberPlate);

    void insertMyCarBox(@Param("psId") Integer id,@Param("userId") Integer userId,@Param("status") int i);

    void updateMyCarBox(@Param("psId") Integer id,@Param("userId") Integer userId,@Param("status") int i);

    void deleteMyCarBox(@Param("psId") Integer id,@Param("userId") Integer userId);

    List<MyCar> selectMyCarList(@Param("userId") Integer id);

    void insertStopCar(@Param("car_id") String numberPlate, @Param("ps_id") Integer ps_id, @Param("user_id") Integer user_id, @Param("time") Timestamp timestamp);
}
