package com.example.controller;


import com.example.base.RestListResponse;
import com.example.base.RestResponseBase;
import com.example.base.RestResponsePage;
import com.example.constant.StatusConstant;
import com.example.model.Car;
import com.example.model.Users;
import com.example.service.CarService;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController

@RequestMapping("/admin")
@Slf4j
public class CarController {


    //删除222222222222222222222222222222222
    @Resource
    private UserService userService;

    @Resource
    private CarService carService;

    @GetMapping("/car/list/{status}")
    //page=1&limit=10
    public RestListResponse<Car> CarList(@RequestParam(value = "page") Integer page,
                                         @RequestParam(value = "limit") Integer limit,
                                         @PathVariable(value = "status",required = false) Integer status) {
        if (page == null || page < 0) {
            page = 0;
        }
        if (limit == null || limit < 0) {
            limit = 0;
        }

        log.info("page: {} , limit : {}", page, limit);

        PageInfo<Car> info = carService.getCarPageList(page, limit,status);

        RestListResponse<Car> response = new RestListResponse<>();
        RestResponsePage responsePage = new RestResponsePage();
        responsePage.setTotalCount(info.getSize());

        response.setCode(StatusConstant.Common.SUCCESS);
        response.setMsg(StatusConstant.Common.SUCCESS_MSG);
        response.setData(info.getList());
        response.setPage(responsePage);
        return response;
    }


    public RestResponseBase updateUser(@RequestParam Map<String, Object> params) {

        Users users = new Users();
        users.setId(params.get("id") == null || params.get("id").equals("") ? 0 : Integer.parseInt(params.get("id").toString()));
        users.setUsername((String) params.get("username"));
        users.setPassword((String) params.get("password"));
        users.setName((String) params.get("name"));
        users.setPhone((String) params.get("phone"));
        users.setAddress((String) params.get("address"));

        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (users == null || users.getUsername() == null) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
        }

        userService.updateUserInfoByUsername(users);

        return restResponseBase;
    }



    public RestResponseBase updateUserPassword(@RequestParam Map<String, Object> params) {

        Users users = new Users();
        users.setId(params.get("id") == null || params.get("id").equals("") ? 0 : Integer.parseInt(params.get("id").toString()));
        users.setPassword((String) params.get("password"));
        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (users == null || users.getPassword() == null) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
            return restResponseBase;
        }

        userService.updateUserPassword(users);

        return restResponseBase;
    }



    public RestResponseBase updateUser(@PathVariable("id") Integer id) {


        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (id == null || id.equals("")) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
            return restResponseBase;
        }

        userService.deleteUserById(id);

        return restResponseBase;
    }

}
