package com.pplip.domain.auth.usecase.impl;

import com.pplip.domain.auth.jwt.Jwt;
import com.pplip.domain.auth.jwt.JwtUtil;
import com.pplip.domain.auth.persistence.entity.Account;
import com.pplip.domain.auth.usecase.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

	private final JwtUtil jwtUtil;

	@Override
	public Jwt issueNewTokens(String refreshToken) {
		Account account = jwtUtil.resolveRefreshToken(refreshToken);
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(account.getUserId(), null, account.getAuthorities());
		return jwtUtil.generate(authToken);
	}
}
