package com.fishdemon.msk.auth.security.util;

import cn.hutool.json.JSONUtil;
import com.fishdemon.msk.auth.common.exception.BaseException;
import com.fishdemon.msk.auth.common.model.ApiResult;
import com.fishdemon.msk.auth.security.SecurityUser;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Classname SecurityUtil
 * @Description 安全服务工具类
 * @Author 李号东 lihaodongmail@163.com
 * @Date 2019-05-08 10:12
 * @Version 1.0
 */
@UtilityClass
public class SecurityUtil {

    public void writeJavaScript(ApiResult r, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(JSONUtil.toJsonStr(r));
        printWriter.flush();
    }

    /**
     * 获取Authentication
     */
    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * @Author 李号东
     * @Description 获取用户
     * @Date 11:29 2019-05-10
     **/
    public SecurityUser getUser(){
        try {
            return (SecurityUser) getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new BaseException(HttpStatus.UNAUTHORIZED.value(), "登录状态过期");
        }
    }
}
