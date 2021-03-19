package com.example.router;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName AdminRouter
 * @Author Mr.Gao
 * @Date 2020/3/4 上午10:07
 * @Description:
 */
@Controller
@Slf4j
public class CommonRouter {

    @GetMapping("/admin/toRegister")
    public String toRegister(Model model) {
        log.info("register");
        return "admin/register";
    }



}
