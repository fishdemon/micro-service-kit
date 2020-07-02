package com.fishdemon.msk.auth.security.service;

import cn.hutool.cache.impl.LRUCache;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 本地缓存用户登录信息
 * @author Anjin.Ma
 * @description AuthorityCache
 * @date 2020/6/30
 */
@Service
public class AuthorityCache {

    private static final LRUCache<String, List<GrantedAuthority>> authorityCache = new LRUCache<String, List<GrantedAuthority>>(1000);

    public List<GrantedAuthority> get(String userId) {
        return  authorityCache.get(userId);
    }

    public void remove(String userId) {
        authorityCache.remove(userId);
    }

    public List<GrantedAuthority> getAndPut (String userId) {
        if (authorityCache.containsKey(userId)) {
            return authorityCache.get(userId);
        }

        // TODO: get authrity from db
        return null;
    }

}
