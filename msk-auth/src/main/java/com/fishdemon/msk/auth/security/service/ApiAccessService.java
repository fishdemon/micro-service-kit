package com.fishdemon.msk.auth.security.service;

import com.fishdemon.msk.auth.security.SecurityUser;
import com.fishdemon.msk.auth.security.config.ApiGrantedAuthority;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author Anjin.Ma
 * @description ApiAccessService
 * @date 2020/7/1
 */
@Slf4j
@Service("apiAccessService")
public class ApiAccessService {
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        if (null == authentication) {
            return false;
        }

        Object principal = authentication.getPrincipal();
        boolean hasPermission = false;

        if (principal instanceof SecurityUser) {

            if (((SecurityUser) principal).getUsername().equals("admin")) {
                hasPermission = true;
            } else {
                String url = request.getRequestURI();
                String method = request.getMethod();
                Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

                for(GrantedAuthority item : authorities) {
                    ApiGrantedAuthority authority = (ApiGrantedAuthority) item;
                    if (method.equalsIgnoreCase(authority.getMethod()) && antPathMatcher.match(authority.getUrl(), url)) {
                        hasPermission = true;
                    }
                }
            }
        }

        return hasPermission;
    }

}
