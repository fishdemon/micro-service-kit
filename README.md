# micro-service-kit

 <p align="center">
  <a href="https://github.com/fishdemon/micro-service-kit" target="_blank">
    <img src="https://img.shields.io/badge/MicroServiceKit-微服务脚手架-green.svg" alt="Build Status">
  </a>
  <img src="https://img.shields.io/badge/Spring%20Boot-2.2.5.RELEASE-yellowgreen.svg" alt="Downloads">
  <img src="https://img.shields.io/badge/Spring%20Cloud-Hoxton.SR3-blue.svg" alt="Coverage Status">
 </p>

此项目是基于 SpringBoot + SpringCloud 相关组件搭建的微服务脚手架，具体采用了 Eureka + Zuul + Cloud Config + Spring boot Admin + Feign + Ribbon + zipkin 等spring 全家桶组件。

- `master 分支` : 这是一个最简单的微服务脚手架，不包含鉴权与任何实现，仅仅演示平台的服务。

- `oauth分支` : 加入了 oauth2 + SSO，实现了微服务的统一鉴权方案，若有需要的小伙伴可以下载下来参考。

以上是个人结合实际项目总结的经验，本着学习交流的态度，若有大牛觉得不太对，请帮忙随时指正，谢谢！！

**如果此项目对大家有帮助，欢迎右上角star支持小弟哦**

## 介绍

写这个项目的初衷一方面是为了巩固工作中的实践经验，另一方面也是为了给后面的实际项目提供一个快速脚手架。

项目中的内容已经经过本人严格测试，大家可以把项目拿下来直接用，也可以基于此脚手架快速的进行扩展，不需要重复造轮子了。

## 核心依赖

| 依赖 | 版本 |
| --- | --- |
| Spring Boot | 2.2.5.RELEASE |
| Spring Cloud | Hoxton.SR3 |
| Spring Boot Admin  |  |
| Open Feign  |  |
| Netflix Hystrix  |  |
| Netflix Eureka |  |
| Netflix Zuul |  |
| Swagger2 | 2.9.2 |

## 软件架构
![微服务架构图解](https://github.com/fishdemon/micro-service-kit/tree/master/doc/img/msk-architecture.jpg)


## 模块说明

```
micro-service-kit -- 工程
├── msk-auth -- 授权模块 （在 oauth 分支中有具体实现）
├── msk-config -- 配置中心
├── msk-eureka -- Eureka服务注册与发现 
├── msk-gateway -- Zuul网关 
├── msk-boot-admin -- Spring Boot Admin监控 
├── msk-zipkin -- Zipkin链路监控 
├── msk-provider -- 生产者服务
├── msk-consumer -- 消费者服务
```

## 安装使用

1. 用 git 工具克隆项目

```shell
git clone git@github.com:fishdemon/micro-service-kit.git
```

2. 修改本地`hosts`文件，添加如下内容（别说这个不知道，是在不知道可以上网查）

```
127.0.0.1 msk-eureka
```

3. 请按照如下顺序依次启动服务模块

```
1. msk-eureka -- 服务注册中心
2. msk-boot-admin -- Spring Boot Admin监控
3. msk-config -- 服务配置中心
4. msk-gateway -- Zuul网关
5. msk-auth -- 授权模块
6. msk-provider -- 服务提供者
7. msk-consumer -- 服务消费者
```

4. 查看管理页面

- Eureka 管理页面

```
http://localhost:8761/
```

![Eureka 管理页面](https://github.com/fishdemon/micro-service-kit/tree/master/doc/img/eureka-manage.jpg)

- Spring boot Admin 监控页面

```
http://localhost:8766/admin/wallboard
```

![Spring boot admin 管理页面](https://github.com/fishdemon/micro-service-kit/tree/master/doc/img/boot-admin-manage.jpg)

## 联系

QQ： 324734127

邮箱： 324734127@qq.com

CSDN 博客： [https://blog.csdn.net/maihilton](https://blog.csdn.net/maihilton)

## 捐赠

如果你觉得这个项目帮助到了你，你可以送我一些鼓励么。。


