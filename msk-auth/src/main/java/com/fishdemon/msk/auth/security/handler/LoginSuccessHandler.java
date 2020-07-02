package com.fishdemon.msk.auth.security.handler;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fishdemon.msk.auth.common.model.ApiResult;
import com.fishdemon.msk.auth.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 重写用户名密码验证成功后的handler, 直接返回 jwt token
 * @author Anjin.Ma
 * @description LoginSuccessHandler
 * @date 2020/6/30
 */
@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Value("${auth.expiration-time:86400000}")
    private Integer expirationTime;
    @Autowired
    private RsaSigner signer;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        SecurityUser user = (SecurityUser) authentication.getPrincipal();

        // 构建 jwt token 中的资料
        SecurityUser tokenUser = new SecurityUser();
        tokenUser.setUserId(user.getUserId());
        tokenUser.setUsername(user.getUsername());
        tokenUser.setExpiration(new Date(new Date().getTime() + expirationTime));
        tokenUser.setAuthorities(user.getAuthorities());
        String userJsonStr = JSONUtil.toJsonStr(tokenUser);
        String token = JwtHelper.encode(userJsonStr, signer).getEncoded();
        //签发token
        response.getWriter().write(objectMapper.writeValueAsString(ApiResult.ok(token)));
    }
}
