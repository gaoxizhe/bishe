package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author gao
 */
@SpringBootApplication
@MapperScan("com.example.dao")
@ComponentScan(basePackages = "com.example.*")
public class StudentsApplication {


    public static void main(String[] args) {
        SpringApplication.run(StudentsApplication.class, args);
    }

}
