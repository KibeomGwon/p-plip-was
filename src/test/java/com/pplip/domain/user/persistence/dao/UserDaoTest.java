package com.pplip.domain.user.persistence.dao;

import com.pplip.domain.user.persistence.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Transactional
class UserDaoTest {

    @Autowired
    UserDao dao;

    @Test
    @DisplayName("find one")
    void findOne() {
        // when
        Optional<User> byId = dao.findById(1L);
        // then
        System.out.println(byId.get().getId());
    }

    @Test
    @DisplayName("insert test")
    void insert() {
        // given
        User user = User.builder().name("user1").birth(LocalDate.of(2000, 2, 11)).build();
        // when
        dao.insert(user);
        // then
    }
}