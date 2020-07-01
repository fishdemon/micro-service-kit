package com.fishdemon.msk.auth.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anjin.Ma
 * @description BaseException
 * @date 2020/6/30
 */
@Getter
@Setter
public class BaseException extends RuntimeException {

    private int code = 500;

    public BaseException() {
    }

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}
