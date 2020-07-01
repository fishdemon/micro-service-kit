package com.fishdemon.msk.auth.security.config;

import com.fishdemon.msk.auth.security.handler.AppAccessDeniedHandler;
import com.fishdemon.msk.auth.security.jwt.JwtHeadFilter;
import com.fishdemon.msk.auth.security.handler.LoginSuccessHandler;
import com.fishdemon.msk.auth.security.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Anjin.Ma
 * @description SecurityConfig
 * @date 2020/6/30
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AppUserDetailsService appUserDetailsService;
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private AppAccessDeniedHandler appAccessDeniedHandler;
    @Autowired
    private JwtHeadFilter jwtHeadFilter;

    @Bean
    public BCryptPasswordEncoder defaultEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 增加 jwt header filter
                .addFilterAfter(jwtHeadFilter, UsernamePasswordAuthenticationFilter.class)
                // 基于 token ，不需要 session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 过滤请求
                .authorizeRequests()
                .antMatchers("/login/**", "/*.ico").permitAll()
                .anyRequest().authenticated()
                .and()
                // 开启表单登录
                .formLogin()
                // 登录处理的API
                //.loginProcessingUrl("/login")
                // 登录页面
                // .loginPage("/login")
                // 登录成功后的处理
                .successHandler(loginSuccessHandler)
                .and()
                .exceptionHandling()
                // 当已登录, 但权限不足的处理, 抛出AccessDeniedException异常时且当不是匿名用户时调用
                .accessDeniedHandler(appAccessDeniedHandler)
                .and()
                // 开启 basic 认证
                .httpBasic()
                .and()
                // jwt token 不需要 csrf
                .csrf().disable()
                //
                .headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 设置自定义的 user details service
        // 并设置密码的 encoder
        auth.userDetailsService(appUserDetailsService).passwordEncoder(defaultEncoder());
    }

}
