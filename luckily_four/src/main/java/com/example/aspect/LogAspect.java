package com.example.aspect;
/*
 *  @author : Mr.Gao
 *  @date :   2020/3/30 下午6:24
 */

import com.alibaba.fastjson.JSON;
import com.example.constant.BaseContextHandler;
import com.example.constant.UserInfo;
import com.example.dao.UserDao;
import com.example.model.RequestModel;
import com.example.model.Users;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * @ClassName LogAspect
 * @Author Mr.Gao
 * @Date 2020/3/30 下午6:24
 * @Description
 */

@Component
@Slf4j
@Aspect
public class LogAspect {

    @Resource
    private UserDao userDao;

    // && !execution(* com.example.controller.UserController.Register(..) )
    @Pointcut("execution(* com.example.controller.*.*(..) ) ")
    public void log() {
    }

    @Pointcut("execution(* com.example.router.admin.*.*(..))")
//    @Pointcut("execution(* com.* Service+.*(..)) and !execution(* Object.*(..)) ")
    public void routerLog() {
    }

    @Before("routerLog()")
    public void doRouterBefore(JoinPoint joinPoint) {

        if (BaseContextHandler.getUser() == null) {
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            Users userInfoByUserName = userDao.getUserInfoByUserName(name);
            if (userInfoByUserName != null) {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(userInfoByUserName.getId());
                userInfo.setUsername(userInfoByUserName.getUsername());
                userInfo.setRoleName(userInfoByUserName.getRoleName());
                userInfo.setRoleDescribe(userInfoByUserName.getRoleDescribe());
                BaseContextHandler.setUser(userInfo);
            }
        }

        RequestModel requestModel = getData(joinPoint);
        log.info("request : {}", requestModel.toString());
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {

        if (BaseContextHandler.getUser() == null) {
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            Users userInfoByUserName = userDao.getUserInfoByUserName(name);
            if (userInfoByUserName != null) {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(userInfoByUserName.getId());
                userInfo.setUsername(userInfoByUserName.getUsername());
                userInfo.setRoleName(userInfoByUserName.getRoleName());
                userInfo.setRoleDescribe(userInfoByUserName.getRoleDescribe());
                BaseContextHandler.setUser(userInfo);
            }
        }

        RequestModel requestModel = getData(joinPoint);
        log.info("request : {}", requestModel.toString());
    }

    private RequestModel getData(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();
        String url = request.getRequestURL().toString();
        String addr = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        return new RequestModel(url, addr, classMethod, args, BaseContextHandler.getUser() == null ? "": BaseContextHandler.getUser().getUsername());
    }

    @AfterReturning(returning = "o", pointcut = "log()")
    public void doAfterReturning(Object o) {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();
        String url = request.getRequestURL().toString();
        String s = request.getRequestURI().toString();

        log.info("result == == >: url: {} ,data:{}", url, JSON.toJSONString(o));
    }

}
