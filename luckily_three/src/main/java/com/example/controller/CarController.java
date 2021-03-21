package com.example.controller;

import com.example.base.RestListResponse;
import com.example.base.RestResponseBase;
import com.example.base.RestResponsePage;
import com.example.constant.BaseContextHandler;
import com.example.constant.StatusConstant;
import com.example.model.Car;
import com.example.model.StopCar;
import com.example.model.Users;
import com.example.service.CarService;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
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
                                         @PathVariable(value = "status", required = false) Integer status) {
        if (page == null || page < 0) {
            page = 0;
        }
        if (limit == null || limit < 0) {
            limit = 0;
        }

        log.info("page: {} , limit : {}", page, limit);

        PageInfo<Car> info = carService.getCarPageList(page, limit, status);

        RestListResponse<Car> response = new RestListResponse<>();
        RestResponsePage responsePage = new RestResponsePage();
        responsePage.setTotalCount(info.getSize());

        response.setCode(StatusConstant.Common.SUCCESS);
        response.setMsg(StatusConstant.Common.SUCCESS_MSG);
        response.setData(info.getList());
        response.setPage(responsePage);
        return response;
    }

    @PostMapping("car")
    public RestResponseBase updateUser(@RequestParam Map<String, Object> params) {

        Car car = new Car();
        car.setId(params.get("id") == null || params.get("id").equals("") ? 0 : Integer.parseInt(params.get("id").toString()));
        car.setCode((String) params.get("code"));
        car.setPrice(Integer.parseInt(String.valueOf(params.get("price"))));
        car.setRemarks((String) params.get("remarks"));

        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (car == null || car.getId() == null || car.getId().equals("")) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
        }

        carService.updateCar(car);

        return restResponseBase;
    }

    @PostMapping("/car/status/{id}/{status}")
    public RestResponseBase updateUser(@PathVariable("id") Integer id,
                                       @PathVariable("status") Integer status) {

        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (id == null || id.equals("")) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
            return restResponseBase;
        }

        carService.updateStatus(id, status);

        return restResponseBase;
    }

    @GetMapping("/stopCar/list/{id}")
    //page=1&limit=10
    public RestListResponse<StopCar> stopCarList(@RequestParam(value = "page") Integer page,
                                                 @RequestParam(value = "limit") Integer limit,
                                                 @PathVariable("id") Integer id) {
        if (page == null || page < 0) {
            page = 0;
        }
        if (limit == null || limit < 0) {
            limit = 0;
        }

        log.info("page: {} , limit : {}", page, limit);

        PageInfo<StopCar> info = carService.getStopCarByPsId(page, limit, id);

        RestListResponse<StopCar> response = new RestListResponse<>();
        RestResponsePage responsePage = new RestResponsePage();
        responsePage.setTotalCount(info.getSize());

        response.setCode(StatusConstant.Common.SUCCESS);
        response.setMsg(StatusConstant.Common.SUCCESS_MSG);
        response.setData(info.getList());
        response.setPage(responsePage);
        return response;
    }

    @GetMapping("/myCar/list")
    //page=1&limit=10
    public RestListResponse<Car> myCarList(@RequestParam(value = "page") Integer page,
                                           @RequestParam(value = "limit") Integer limit) {
        if (page == null || page < 0) {
            page = 0;
        }
        if (limit == null || limit < 0) {
            limit = 0;
        }

        log.info("page: {} , limit : {}", page, limit);

        PageInfo<Car> info = carService.getMyCarPageList(page, limit);

        RestListResponse<Car> response = new RestListResponse<>();
        RestResponsePage responsePage = new RestResponsePage();
        responsePage.setTotalCount(info.getSize());

        response.setCode(StatusConstant.Common.SUCCESS);
        response.setMsg(StatusConstant.Common.SUCCESS_MSG);
        response.setData(info.getList());
        response.setPage(responsePage);
        return response;
    }

    @PostMapping("/user/myCarAdd")
    public RestResponseBase myCarAdd(@RequestParam("numberPlate") String numberPlate) {
        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        Integer userId = BaseContextHandler.getUser().getId();
        if (StringUtil.isEmpty(numberPlate)) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
            return restResponseBase;
        }
        carService.addMyCar(userId, numberPlate);

        return restResponseBase;
    }

    @GetMapping("/user/stopMyCar")
    public RestResponseBase stopMyCar(@RequestParam("numberPlate") String numberPlate,
                                      @RequestParam("id") Integer ps_id) {
        RestResponseBase restResponseBase = new RestResponseBase();
        restResponseBase.setMsg(StatusConstant.Common.SUCCESS_MSG);
        restResponseBase.setCode(StatusConstant.Common.SUCCESS);

        if (StringUtil.isEmpty(numberPlate)) {
            restResponseBase.setMsg(StatusConstant.Common.PARAM_IS_EMPTY);
            restResponseBase.setCode(StatusConstant.Common.ERROR);
            return restResponseBase;
        }
        carService.stopMyCar(numberPlate, ps_id);

        return restResponseBase;
    }
}
