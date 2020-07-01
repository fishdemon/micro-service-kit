package com.fishdemon.msk.auth.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

/**
 * @author Anjin.Ma
 * @description ApiApiResultesult
 * @date 2020/6/29
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ApiResult{

    private int code = 200;
    private String msg;
    private Object data;

    public static ApiResult ok() {
        ApiResult r = new ApiResult();
        r.setMsg("操作成功");
        return r;
    }

    public static ApiResult ok(Object data) {
        ApiResult r = new ApiResult();
        r.setMsg("操作成功");
        r.setData(data);
        return r;
    }

    public static ApiResult error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    public static ApiResult error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static ApiResult error(int code, String msg) {
        ApiResult r = new ApiResult();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

}
