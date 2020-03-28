package com.fishdemon.msk.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // 设置过滤器类型 pre/routing/post/error
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 设置过滤器优先级, 值越小, 优先级越高
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 过滤器是否生效, true 为生效
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();

        String token = request.getHeader("x-auth-token");
        if (token == null) {
            // 不在向后台服务转发
            context.setSendZuulResponse(false);
            // 设置 response status 为 401
            context.setResponseStatusCode(401);
            try {
                response.getWriter().write("no authentication");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
