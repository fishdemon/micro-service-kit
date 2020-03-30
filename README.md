# micro-service-kit

![star](https://github.com/fishdemon/micro-service-kit "star")

此项目是基于 SpringBoot + SpringCloud 相关组件搭建的微服务脚手架，具体采用了 Eureka + Zuul + Cloud Config + Spring boot Admin + Feign + Ribbon + zipkin 等spring 全家桶组件。

## 介绍

写这个项目的初衷一方面是为了巩固工作中的实践经验，另一方面也是为了给后面的实际项目提供一个快速脚手架。

项目中的内容已经经过本人严格测试，大家可以把项目拿下来直接用，也可以基于此脚手架快速的进行扩展，不需要重复造轮子了。

## 核心依赖

| 依赖 | 版本 |
| --- | --- |
| Spring Boot | 2.1.5.RELEASE |
| Spring Cloud | Greenwich.SR1 |
| Spring Security OAuth2 | 2.3.4.RELEASE |
| tk.mybatis | 4.1.5 |
| vue-admin-template | 4.1.0 |
| Swagger2 | 2.9.2 |

## 软件架构
软件架构说明


## 模块说明

```
sct-app -- 前端工程[8100]
sct-api 
├── sct-admin -- 系统管理模块
    ├── sct-admin-api -- 系统管理的公共api模块
    ├── sct-admin-biz -- 系统管理的业务实现模块 [4100]
├── sct-auth -- 授权模块 [4000]
├── sct-common -- 系统公共类模块
├── sct-config -- 配置中心 [8888]
├── sct-eureka -- Eureka服务注册与发现 [8761]
├── sct-gateway -- Zuul网关 [9999]
├── sct-monitor -- Spring Boot Admin监控 [3000]
├── sct-zipkin -- Zipkin链路监控 [3001]

```

## 安装使用

1.  xxxx
2.  xxxx
3.  xxxx


## 捐赠
&#160;&#160;&#160;&#160;**如果感觉对您有帮助，请作者喝杯咖啡吧，请注明您的名字或者昵称，方便作者感谢o(*￣︶￣*)o**

| 微信 | 支付宝 |
| :---: | :---: |
| ![](./examples/images/weixin.png) | ![](./examples/images/alipay.jpeg) |
