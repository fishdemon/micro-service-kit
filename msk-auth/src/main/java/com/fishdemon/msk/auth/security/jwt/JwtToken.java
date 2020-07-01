package com.fishdemon.msk.auth.security.jwt;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author Anjin.Ma
 * @description JwtToken
 * @date 2020/6/30
 */
public class JwtToken extends AbstractAuthenticationToken {

    /**登录用户信息*/
    private  Object principal;
    /**密码*/
    private Object credentials;

    /**
     * 创建一个未认证的授权令牌,
     * 这时传入的principal是用户名
     *
    */
    public JwtToken(Object principal, Object credentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(false);
    }

    /**
     * 创建一个已认证的授权令牌,如注释中说的那样,这个方法应该由AuthenticationProvider来调用
     * 也就是我们写的JwtAuthenticationProvider,有它完成认证后再调用这个方法,
     * 这时传入的 principal为从userService中查出的UserDetails
     * @param principal
     * @param credentials
     * @param authorities
     */
    public JwtToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}
