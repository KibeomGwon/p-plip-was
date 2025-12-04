package com.pplip.domain.auth.utils;

import com.pplip.domain.auth.persistence.entity.Account;
import com.pplip.domain.user.persistence.dao.UserDao;
import com.pplip.domain.user.persistence.entity.User;
import com.pplip.global.api.code.ErrorCode;
import com.pplip.global.exception.BusinessLogicException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityUtils {

	private final UserDao userDao;

	public User getLoginUser(UserDetails principal) {
		Long userId = ((Account) principal).getUserId();
		return userDao.findById(userId).orElseThrow(() -> new BusinessLogicException(ErrorCode.USER_NOT_FOUND_ERROR, "인증되지 않은 사용자입니다."));
	}

}
