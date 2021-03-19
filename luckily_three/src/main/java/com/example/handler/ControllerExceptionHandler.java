package com.example.handler;
/*
 *  @author : Mr.Gao
 *  @date :   2020/3/28 下午6:23
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ControllerExceptionHandler
 * @Author Mr.Gao
 * @Date 2020/3/28 下午6:23
 * @Description
 */
@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e) {

        ///第一个参数 打印异常的地址，第二个是打印异常的信息
        log.error("request URL : {}, Exception: {}",request.getRequestURL(),e);
        ModelAndView mv=new ModelAndView();

        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);
        mv.setViewName("error/error");
        return mv;

    }

}
