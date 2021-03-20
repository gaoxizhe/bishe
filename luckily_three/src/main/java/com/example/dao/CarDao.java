package com.example.dao;

import com.example.model.Car;
import com.example.model.StopCar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao {
    List<Car> getCarListByStatus(@Param("status") Integer status);

    Car selectCarById(@Param("id") Integer id);

    void insertCar(Car car);

    void updateCar(Car car);

    void updateCarStatusById(@Param("id") Integer id,@Param("status") Integer status);

    List<StopCar> getStopCarByPsId(@Param("id") Integer id);
}
