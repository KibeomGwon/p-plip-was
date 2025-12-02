package com.pplip.domain.board.notice.persistence.dao;

import com.pplip.domain.board.notice.api.response.NoticeResponse;
import com.pplip.global.page.PageRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoticeDaoTest {

    @Autowired
    NoticeDao dao;

    @Test
    @DisplayName("notice board find test")
    void findOne() {
        // when
        Optional<NoticeResponse.Detail> byId = dao.findById(1L);
        // then
        Assertions.assertThat(byId).isEmpty();
    }

    @Test
    @DisplayName("find all test")
    void findAll() {
        // when
        List<NoticeResponse.Summary> all = dao.findAll(new PageRequest(1, 20));
        // then
        Assertions.assertThat(all.size()).isEqualTo(0);
    }
}