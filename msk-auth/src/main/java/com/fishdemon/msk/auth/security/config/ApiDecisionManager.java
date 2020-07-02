package com.fishdemon.msk.auth.security.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 通过重写 DecisionManager 来实现URL的权限匹配
 * @author Anjin.Ma
 * @description ApiDecisionManager
 * @date 2020/7/1
 */
@Component
public class ApiDecisionManager implements AccessDecisionManager {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (null == authentication) {
            throw new AccessDeniedException("Access is denied");
        }

        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
        String method = fi.getRequest().getMethod();
        Collection<? extends GrantedAuthority> authorities= authentication.getAuthorities();

        for(GrantedAuthority authority : authorities) {
            if (!(authority instanceof  ApiGrantedAuthority)) {
                return;
            }
            ApiGrantedAuthority temp = (ApiGrantedAuthority) authority;
            if (method.equalsIgnoreCase(temp.getMethod()) && antPathMatcher.match(temp.getUrl(), url)) {
                return;
            }
        }

        throw new AccessDeniedException("Access is denied");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

}
