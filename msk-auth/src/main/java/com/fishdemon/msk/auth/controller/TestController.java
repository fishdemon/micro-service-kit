package com.fishdemon.msk.auth.controller;

import com.fishdemon.msk.auth.common.model.ApiResult;
import com.fishdemon.msk.auth.log.OperateLog;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    @OperateLog(descrption = "test")
//    @PreAuthorize("hasAuthority('sys:dict:add')")
    public ApiResult test() {
        return ApiResult.ok("test");
    }

}



