package com.pplip.domain.user.persistence.dao;

import com.pplip.domain.user.persistence.entity.Profile;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
class ProfileDaoTest {

    @Autowired
    ProfileDao dao;

    @Test
    @DisplayName("find test")
    void findOne() {
        // when
        Optional<Profile> byUserId = dao.findByUserId(1L);
        // then
        Assertions.assertThat(byUserId).isEmpty();
    }

}