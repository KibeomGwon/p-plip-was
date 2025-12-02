package com.pplip.domain.auth.persistence.dao;

import com.pplip.domain.auth.persistence.entity.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountDaoTest {

    @Autowired
    AccountDao dao;

    @Test
    @DisplayName("find account test")
    void find() {
        // when
        Optional<Account> byEmail = dao.findByEmail("email@email.com");
        // then
        Assertions.assertThat(byEmail).isEmpty();
    }
}