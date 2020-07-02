package com.fishdemon.msk.auth.controller;

import com.fishdemon.msk.auth.common.model.ApiResult;
import com.fishdemon.msk.auth.model.dto.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anjin.Ma
 * @description LoginController
 * @date 2020/7/2
 */
@RestController
public class LoginController {

    @PostMapping("/register")
    public ApiResult register(@RequestBody UserDTO userDTO) {
        return ApiResult.ok();
    }


}
