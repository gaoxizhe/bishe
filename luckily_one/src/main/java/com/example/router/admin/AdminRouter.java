package com.example.router.admin;

import com.example.constant.BaseContextHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @ClassName AdminRouter
 * @Author Mr.Gao
 * @Date 2020/3/4 上午10:07
 * @Description:
 */
@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminRouter {



    @GetMapping({"/index", "/", "index.html", ""})
    public String index() {
        return "admin/index";
    }

    @GetMapping({"/welcome"})
    public String welcome() {
        return "admin/welcome";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        BaseContextHandler.remove();
        return "admin/login";
    }
}