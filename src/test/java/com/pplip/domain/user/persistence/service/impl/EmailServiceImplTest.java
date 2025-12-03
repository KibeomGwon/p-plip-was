package com.pplip.domain.user.persistence.service.impl;

import com.pplip.domain.user.api.request.UserRequest;
import com.pplip.domain.user.cache.EmailValidator;
import com.pplip.domain.user.persistence.service.EmailService;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailServiceImplTest {

    @Autowired
    EmailService emailService;
    @Autowired
    EmailValidator validator;

//    @Test
    @DisplayName("email send")
    void emailSend() {
        // given
        String email = "xtcc02332@naver.com";
        UserRequest.Email user = UserRequest.Email.builder().email(email).build();
        // when
        try {
            emailService.sendEmail(user);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        // then
    }
}