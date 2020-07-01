package com.fishdemon.msk.auth.service.impl;

import com.fishdemon.msk.auth.entity.User;
import com.fishdemon.msk.auth.mapper.UserMapper;
import com.fishdemon.msk.auth.security.SecurityUser;
import com.fishdemon.msk.auth.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Anjin.Ma
 * @since 2020-06-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Set<String> getPermissionsByUserId(int userId) {
        switch (userId) {
            case 1 :
                Set<String> permissions = new HashSet<>(Arrays.asList("","",""));
                return permissions;
            default:
                return new HashSet<>();
        }
    }

    @Override
    public Set<String> getRolesByUserId(int userId) {
        switch (userId) {
            case 1 :
                Set<String> roles = new HashSet<>(Arrays.asList("admin"));
                return roles;
            default:
                return new HashSet<>();
        }
    }

    @Override
    public SecurityUser loadUserByUserName(String username) {
        SecurityUser user = new SecurityUser();
        switch (username) {
            case "admin" :
                user.setUserId(1);
                user.setUsername(username);
                user.setPassword(passwordEncoder.encode("123456"));
                return user;
            default:
                return null;
        }
    }
}
