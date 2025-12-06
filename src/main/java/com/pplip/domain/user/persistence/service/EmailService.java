package com.pplip.domain.user.persistence.service;

import com.pplip.domain.user.api.request.UserRequest;
import com.pplip.domain.user.api.response.UserResponse;
import jakarta.mail.MessagingException;

public interface EmailService {

    void sendEmail(UserRequest.Email email) throws MessagingException;

    UserResponse.EmailCheck validate(UserRequest.EmailCheck emailCheck);
}
