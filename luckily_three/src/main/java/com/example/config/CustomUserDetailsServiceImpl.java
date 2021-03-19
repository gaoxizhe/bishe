package com.example.config;

import com.example.dao.UserDao;
import com.example.model.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName CustomUserDetailsService
 * @Description
 */
@Configuration
@Slf4j
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    /**
     * 根据用户名获取用户 - 用户的角色、权限等信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        try {
            Users userInfoByUserName = userDao.getUserInfoByUserName(username);
            if (userInfoByUserName == null) {
                throw new InternalAuthenticationServiceException(
                        "用户不存在！");
            }
            log.info("userInfoByUserName : {}", userInfoByUserName);
            userDetails = new User(username, userInfoByUserName.getPassword(), true, true, true, true, getAuthorities(userInfoByUserName.getRoleName()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return userDetails;
    }

    /**
     * 获取用户的角色权限,为了降低实验的难度，这里去掉了根据用户名获取角色的SPRING_SECURITY_LAST_EXCEPTION步骤     * @param    * @return
     */
    private Collection<GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        //添加权限必须前缀：ROLE_
        authList.add(new SimpleGrantedAuthority("ROLE_" + role));
        return authList;
    } //添加权限必须前缀：ROLE_ //添加权限必须前缀：ROLE_
}
