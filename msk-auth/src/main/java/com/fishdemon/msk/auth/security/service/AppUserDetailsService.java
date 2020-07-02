package com.fishdemon.msk.auth.security.service;

import cn.hutool.json.JSONUtil;
import com.fishdemon.msk.auth.security.SecurityUser;
import com.fishdemon.msk.auth.security.config.ApiGrantedAuthority;
import com.fishdemon.msk.auth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Anjin.Ma
 * @description AppUserDetailsService
 * @date 2020/6/30
 */
@Slf4j
@Service
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUser user = userService.loadUserByUserName(username);
        if (null == user) {
            log.info("登录用户：" + username + " 不存在.");
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }

        List<ApiGrantedAuthority> authorities = getAuthorities(user.getUserId());
        user.setAuthorities(authorities);

        log.debug(JSONUtil.toJsonStr(user));
        return user;
    }

    private List<ApiGrantedAuthority>  getAuthorities(int userId) {
        // 获取用户的所有权限
        List<ApiGrantedAuthority> permissions = userService.getPermissionsByUserId(userId);
        // 获取用户的所有角色
//        List<String> roles = userService.getRolesByUserId(userId);
        // 集合所有的权限及集合
//        Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(permissions.toArray(new String[0]));
        return permissions;
    }

}
