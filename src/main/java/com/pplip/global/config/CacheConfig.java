package com.pplip.global.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.pplip.global.cache.utils.CacheType;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

import static com.pplip.domain.auth.jwt.JwtProperties.REFRESH_TOKEN_EXPIRE_TIME;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager(CacheType.REFRESH.getName());

        cacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterWrite(REFRESH_TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS));

        return cacheManager;
    }
}
