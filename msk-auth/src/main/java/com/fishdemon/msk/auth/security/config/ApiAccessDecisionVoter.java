package com.fishdemon.msk.auth.security.config;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;

/**
 * @author Anjin.Ma
 * @description ApiAccessDecisionVoter
 * @date 2020/7/2
 */
public class ApiAccessDecisionVoter implements AccessDecisionVoter {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object object, Collection collection) {
        if (null == authentication) {
            return ACCESS_DENIED;
        }

        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
        String method = fi.getRequest().getMethod();
        Collection<? extends GrantedAuthority> authorities= authentication.getAuthorities();

        for(GrantedAuthority authority : authorities) {
            if (!(authority instanceof  ApiGrantedAuthority)) {
                return ACCESS_ABSTAIN;
            }
            ApiGrantedAuthority temp = (ApiGrantedAuthority) authority;
            if (method.equalsIgnoreCase(temp.getMethod()) && antPathMatcher.match(temp.getUrl(), url)) {
                return ACCESS_GRANTED;
            }
        }

        return ACCESS_DENIED;
    }
}
