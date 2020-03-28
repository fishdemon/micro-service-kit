package com.fishdemon.msk.provider.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class ProviderController {

    @GetMapping
    public String hello() {
        return "hello, i'm provider";
    }

    // 测试 feign 中 path variable 的用法
    @GetMapping("/{id}")
    public String getById(@PathVariable("id") String id) {
        return "hello, you get the provider " + id;
    }

    // 测试 feign 中 request param 的用法
    @GetMapping("/user")
    public String getByName(@RequestParam("name") String name) {
        return "hello, you get the user " + name;
    }

}
