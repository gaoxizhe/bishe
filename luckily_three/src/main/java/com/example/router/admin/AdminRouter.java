package com.example.router.admin;

import com.alibaba.fastjson.JSON;
import com.example.base.RestEntityResponse;
import com.example.constant.BaseContextHandler;
import com.example.constant.StatusConstant;
import com.example.model.Car;
import com.example.model.StopCar;
import com.example.model.Users;
import com.example.service.CarService;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private UserService userService;

    @Resource
    private CarService carService;

    @GetMapping({"/index", "/", "index.html", ""})
    public String index() {
        return "admin/index";
    }

    @GetMapping({"/welcome"})
    public String welcome() {
        return "admin/welcome";
    }

    //user-===================
    @GetMapping("/toUser")
    public String toCategoryList(Model model) {
        return "admin/user_list";
    }

    @GetMapping("/toUserEdit/{id}")
    public String toUserEdit(Model model, @PathVariable("id") Integer id) {
        RestEntityResponse restResponseBase = new RestEntityResponse<>();
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        if (id.equals(0)) {
            restResponseBase.setData(new Users());
        } else {
            Users userById = userService.getUserById(id);
            userById.setPassword("密码无法修改");
            restResponseBase.setData(userById);
        }
//        restResponseBase.setCode(StatusConstant.Common.ERROR);
//        restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
        String o = JSON.toJSONString(restResponseBase);
        System.err.println(o);
        model.addAttribute("data", restResponseBase);
        return "admin/user_edit";

    }

    @GetMapping("/toUserPassword/{id}")
    public String toUserPassword(Model model, @PathVariable("id") Integer id) {
        RestEntityResponse restResponseBase = new RestEntityResponse<>();
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        Users data = new Users();
        if (id.equals(0)) {
            restResponseBase.setData(data);
        } else {
            data.setId(id);
            restResponseBase.setData(data);
        }
//        restResponseBase.setCode(StatusConstant.Common.ERROR);
//        restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
        String o = JSON.toJSONString(restResponseBase);
        System.err.println(o);
        model.addAttribute("data", restResponseBase);
        return "admin/user_password";

    }

    @GetMapping("/toLogin")
    public String toLogin() {
        BaseContextHandler.remove();
        return "admin/login";
    }

    //user-===================
    @GetMapping("/toCar")
    public String toCar(Model model) {
        return "admin/car_list";
    }

    @GetMapping("/toCarEdit/{id}")
    public String toCarEdit(Model model, @PathVariable("id") Integer id) {
        RestEntityResponse restResponseBase = new RestEntityResponse<>();
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        if (id.equals(0)) {
            restResponseBase.setData(new Car());
        } else {
            Car carById = carService.getCarById(id);
            restResponseBase.setData(carById);
        }
//        restResponseBase.setCode(StatusConstant.Common.ERROR);
//        restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
        String o = JSON.toJSONString(restResponseBase);
        System.err.println(o);
        model.addAttribute("data", restResponseBase);
        return "admin/car_edit";

    }


    @GetMapping("/toStopCar/{id}")
    public String toStopCar(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("id", id);
        return "admin/stop_car";

    }

}