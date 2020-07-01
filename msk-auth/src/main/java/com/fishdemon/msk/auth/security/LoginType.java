package com.fishdemon.msk.auth.security;


import lombok.Getter;

/**
 * @Description 登录类型 现在有用户名 短信 社交
 * @author Anjin.Ma
 * @Date 2020-06-30 13:50
 * @Version 1.0
 */
@Getter
public enum LoginType {
    normal, sms, social;
}
