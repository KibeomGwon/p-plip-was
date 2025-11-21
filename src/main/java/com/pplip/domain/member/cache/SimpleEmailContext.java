package com.pplip.domain.member.cache;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SimpleEmailContext implements EmailValidator {

    private static final long EXPIRATION_PERIOD = 5 * 60;

    private static ConcurrentHashMap<String, EmailValidationInfo> context = new ConcurrentHashMap<>();

    @Override
    public boolean valid(String email) {
        EmailValidationInfo emailValidationInfo = context.get(email);
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime expiredAt = emailValidationInfo.getPublishedAt().plusSeconds(EXPIRATION_PERIOD);
        return current.isBefore(expiredAt);
    }
}
