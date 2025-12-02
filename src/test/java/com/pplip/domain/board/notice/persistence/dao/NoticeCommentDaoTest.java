package com.pplip.domain.board.notice.persistence.dao;

import com.pplip.domain.board.notice.api.response.NoticeCommentResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoticeCommentDaoTest {

    @Autowired
    NoticeCommentDao dao;

    @Test
    @DisplayName("find all test")
    void findAll() {
        // when
        List<NoticeCommentResponse.Summary> all = dao.findAll(1L);
        // then
        Assertions.assertThat(all.size()).isEqualTo(0);
    }
}