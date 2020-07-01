package com.fishdemon.msk.auth.service;

import com.fishdemon.msk.auth.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fishdemon.msk.auth.security.SecurityUser;

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

    Set<String> getPermissionsByUserId(int userId);

    Set<String> getRolesByUserId(int userId);

    SecurityUser loadUserByUserName(String username);

}
