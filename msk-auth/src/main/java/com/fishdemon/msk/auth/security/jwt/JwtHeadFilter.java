package com.fishdemon.msk.auth.security.jwt;

import cn.hutool.json.JSONUtil;
import com.fishdemon.msk.auth.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author Anjin.Ma
 * @date 2020-6-30
 */
@Component
public class JwtHeadFilter extends OncePerRequestFilter {
    public static final String TOKEN_HEADER_KEY = "Authorization";
    public static final String TOKEN_HEAD = "Bearer ";
    @Autowired
    private RsaVerifier verifier;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(TOKEN_HEADER_KEY);
        if (token == null || token.isEmpty() || !token.startsWith(TOKEN_HEAD)){
            filterChain.doFilter(request,response);
            return;
        }

        SecurityUser user;
        try {
            token = token.substring(TOKEN_HEAD.length());
            Jwt jwt = JwtHelper.decodeAndVerify(token, verifier);
            String claims = jwt.getClaims();
            user = JSONUtil.toBean(claims, SecurityUser.class);
            //todo: 可以在这里添加检查用户是否过期,冻结...
        }catch (Exception e){
            //这里也可以filterChain.doFilter(request,response)然后return,那最后就会调用
            //.exceptionHandling().authenticationEntryPoint,也就是本列中的"需要登陆"
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("token 失效");
            return;
        }

        JwtToken jwtToken = new JwtToken(user, "", user.getAuthorities());
        jwtToken.setDetails(new WebAuthenticationDetails(request));
        SecurityContextHolder.getContext().setAuthentication(jwtToken);
        filterChain.doFilter(request,response);
    }

}
