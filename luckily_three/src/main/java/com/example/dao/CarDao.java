package com.example.dao;

import com.example.model.Car;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao {
    List<Car> getCarListByStatus(@Param("status") Integer status);
}
