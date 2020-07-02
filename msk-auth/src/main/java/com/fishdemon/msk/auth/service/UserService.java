package com.fishdemon.msk.auth.service;

import com.fishdemon.msk.auth.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fishdemon.msk.auth.security.SecurityUser;
import com.fishdemon.msk.auth.security.config.ApiGrantedAuthority;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Anjin.Ma
 * @since 2020-06-29
 */
public interface UserService extends IService<User> {

    List<ApiGrantedAuthority> getPermissionsByUserId(int userId);

    List<String> getRolesByUserId(int userId);

    SecurityUser loadUserByUserName(String username);

}
