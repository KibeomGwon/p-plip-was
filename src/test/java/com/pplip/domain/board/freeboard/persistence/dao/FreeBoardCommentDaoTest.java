package com.pplip.domain.board.freeboard.persistence.dao;

import com.pplip.domain.board.freeboard.api.response.FreeBoardCommentResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FreeBoardCommentDaoTest {

    @Autowired
    FreeBoardCommentDao dao;

    @Test
    @DisplayName("free board comment search")
    void commentSearchAll() {
        // when
        List<FreeBoardCommentResponse.Retrieve> all = dao.findAll(1L);
        // then
        Assertions.assertThat(all.size()).isEqualTo(0);
    }

}