package com.example.controller;
/*
 *  @author : Mr.Gao
 *  @date :   2020/3/20 下午1:07
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Author Mr.Gao
 * @Date 2020/3/20 下午1:07
 * @Description
 */
@RestController

public class TestController {

    @GetMapping("/admin/a")
    public String toaaa() {
        return "admin";
    }

    @GetMapping("/guest/a")
    public String guest() {
        return "guest";
    }
}

