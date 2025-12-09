package com.pplip.domain.auth.usecase;

import com.pplip.domain.auth.jwt.Jwt;

public interface AuthService {
	Jwt issueNewTokens(String refreshToken);
}
