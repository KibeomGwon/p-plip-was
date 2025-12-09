package com.pplip.domain.auth.usecase.impl;

import com.pplip.domain.auth.jwt.Jwt;
import com.pplip.domain.auth.jwt.JwtUtil;
import com.pplip.domain.auth.usecase.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

	private final JwtUtil jwtUtil;

	@Override
	public Jwt issueNewTokens(String refreshToken) {

		return null;
	}
}
