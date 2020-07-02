package com.fishdemon.msk.auth.security.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import java.util.Objects;

/**
 * @author Anjin.Ma
 * @description ApiAuthority
 * @date 2020/7/1
 */
public class ApiGrantedAuthority implements GrantedAuthority {

    private String method;

    private String url;

    public ApiGrantedAuthority(String method, String url) {
        Assert.hasText(method, "A granted authority textual [method] representation is required");
        Assert.hasText(url, "A granted authority textual [url] representation is required");
        this.method = method;
        this.url = url;
    }

    @Override
    public String getAuthority() {
        return "/" + method + url;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiGrantedAuthority that = (ApiGrantedAuthority) o;
        return Objects.equals(method, that.method) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, url);
    }
}
