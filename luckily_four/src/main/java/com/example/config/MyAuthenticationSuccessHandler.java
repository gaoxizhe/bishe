package com.example.config;

import com.example.constant.BaseContextHandler;
import com.example.constant.UserInfo;
import com.example.dao.UserDao;
import com.example.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gao
 */
@Component("MyAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Resource
    private UserDao userDao;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails p = (UserDetails) principal;

        logger.info("登录成功 : " + p.getUsername());
        Users userInfoByUserName = userDao.getUserInfoByUserName(p.getUsername());
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userInfoByUserName.getId());
        userInfo.setUsername(userInfoByUserName.getUsername());
        userInfo.setRoleName(userInfoByUserName.getRoleName());
        userInfo.setRoleDescribe(userInfoByUserName.getRoleDescribe());
        BaseContextHandler.setUser(userInfo);
        response.sendRedirect("/admin/");
    }
}