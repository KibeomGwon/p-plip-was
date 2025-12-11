package com.pplip.domain.auth.api.controller;

import com.pplip.domain.auth.dto.LoginRequest;
import com.pplip.domain.auth.jwt.Jwt;
import com.pplip.domain.auth.usecase.AuthService;
import com.pplip.global.api.code.SuccessCode;
import com.pplip.global.api.response.CommonResponse;
import com.pplip.global.docs.AuthDocsController;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/auth")
public class AuthController implements AuthDocsController {
	private final AuthService authService;

	@PostMapping("/refresh")
	public CommonResponse<Jwt> refreshAccessToken(@CookieValue("refreshToken") String refreshToken){
		return CommonResponse.success(SuccessCode.CREATED, authService.issueNewTokens(refreshToken));
	}

	@Operation(summary = "로그인", description = "ID/PW를 통해 JWT 토큰을 발급받습니다.")
	@PostMapping("/login")
	public void fakeLoginEndpoint(@RequestBody LoginRequest loginRequest){
	}


}
