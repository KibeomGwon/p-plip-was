package com.pplip.domain.auth.utils;

import com.pplip.domain.auth.persistence.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityUtils {

	public static boolean isAnonymous() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication == null || authentication.getPrincipal() instanceof String;
	}

	public static Account getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (isAnonymous()) {
			return null;
		}
		return (Account) authentication.getPrincipal();
	}

}
