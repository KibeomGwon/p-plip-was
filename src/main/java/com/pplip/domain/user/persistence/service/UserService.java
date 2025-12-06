package com.pplip.domain.user.persistence.service;

import com.pplip.domain.user.api.request.UserRequest;
import com.pplip.domain.user.api.response.UserResponse;

public interface UserService {


	UserResponse.DupCheck nicknameDupCheck(String nickname);

	Void join(UserRequest.Join join);
}
