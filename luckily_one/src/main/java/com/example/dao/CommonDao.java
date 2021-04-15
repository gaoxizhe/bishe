package com.example.dao;

import com.example.model.GraduateDetail;
import com.example.model.Welcome;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Mr.Gao
 * @date :   2021/4/15 下午11:49
 */
@Repository
public interface CommonDao {
    Welcome getWelcomeCount();


}
