package com.fishdemon.msk.auth.common.exception;

import com.fishdemon.msk.auth.common.model.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.security.auth.login.AccountExpiredException;

/**
 * @author Anjin.Ma
 * @description ExceptionHandler
 * @date 2020/6/30
 */
@Slf4j
@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResult handleException(Exception e) {
        return ApiResult.error(500, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(NoHandlerFoundException.class)
    public ApiResult handlerNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        return ApiResult.error(404, "路径不存在，请检查路径是否正确");
    }

    @ResponseBody
    @ExceptionHandler(DuplicateKeyException.class)
    public ApiResult handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        return ApiResult.error(300, "数据库中已存在该记录");
    }

    @ResponseBody
    @ExceptionHandler(AccessDeniedException.class)
    public ApiResult handleAuthorizationException(AccessDeniedException e) {
        log.error(e.getMessage());
        return ApiResult.error(403, "没有权限，请联系管理员授权");
    }

    @ResponseBody
    @ExceptionHandler(AccountExpiredException.class)
    public ApiResult handleAccountExpiredException(AccountExpiredException e) {
        log.error(e.getMessage(), e);
        return ApiResult.error(401, "登录已过期，请重新登录");
    }

    @ResponseBody
    @ExceptionHandler(UsernameNotFoundException.class)
    public ApiResult handleUsernameNotFoundException(UsernameNotFoundException e) {
        log.error(e.getMessage(), e);
        return ApiResult.error(401, e.getMessage());
    }

}
