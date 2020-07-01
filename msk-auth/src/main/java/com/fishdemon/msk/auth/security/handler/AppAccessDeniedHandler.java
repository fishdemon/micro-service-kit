package com.fishdemon.msk.auth.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fishdemon.msk.auth.common.model.ApiResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Anjin.Ma
 * @description AppAccessDeniedHandler
 * @date 2020/7/1
 */
@Component
public class AppAccessDeniedHandler implements AccessDeniedHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        ApiResult result = ApiResult.error(403, "没有权限");
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }

}
