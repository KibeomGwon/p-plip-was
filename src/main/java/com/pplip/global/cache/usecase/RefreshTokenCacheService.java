package com.pplip.global.cache.usecase;

import com.pplip.global.cache.utils.CacheType;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenCacheService {

    private final Cache cache;

    public RefreshTokenCacheService(CacheManager cache) {
        this.cache = cache.getCache(CacheType.REFRESH.getName());
    }

    public void saveRefreshToken(String refreshToken, Long userId) {
        cache.put(refreshToken, userId);
    }

    public Long getRefreshTokenById(String refreshToken) {
        return cache.get(refreshToken, Long.class);
    }

    public void removeRefreshToken(String refreshToken) {
        cache.evict(refreshToken);
    }

    public boolean validateRefreshToken(String refreshToken) {
        return cache.get(refreshToken) != null;
    }
}
