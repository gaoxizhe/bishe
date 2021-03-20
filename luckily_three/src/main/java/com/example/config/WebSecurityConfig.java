package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {

    //认证成功处理类
    @Resource
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;


    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            public void configure(HttpSecurity httpSecurity) throws Exception {
                httpSecurity.csrf().disable()

                        .rememberMe().userDetailsService(new CustomUserDetailsServiceImpl()).tokenValiditySeconds(3600).tokenRepository(persistentTokenRepository()).and()
                        .headers().frameOptions().disable().and().
                        formLogin()
                        .loginPage("/admin/toLogin").loginProcessingUrl("/admin/login")
                            .successHandler(myAuthenticationSuccessHandler).failureUrl("/admin/toLogin?error=true")
                        .permitAll().and()
                        .logout().logoutUrl("/admin/logout").logoutSuccessUrl("/admin/toLogin").clearAuthentication(true).permitAll().and().
                        authorizeRequests()
                        //配置无需拦截的访问请求
                        .antMatchers("/","/admin/toRegister","/admin/user/register").permitAll().
                        //配置权限访问请求
                        antMatchers("/admin/**").hasAnyRole("admin","guest","user").
                        antMatchers("/guest/**").hasAnyRole("guest","user")
                        .anyRequest().permitAll()
                ;

            }

//            @Override
//            public void configure(WebSecurity web) throws Exception {
//                //解决静态资源被拦截的问题
//                web.ignoring().antMatchers("/admin/toRegister");
//            }
        };
    }

    @Resource
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
//        jdbcTokenRepository.setCreateTableOnStartup(true); //是否创建表，第一次会帮助我们创建
        return jdbcTokenRepository;
    }

    // ...






}

