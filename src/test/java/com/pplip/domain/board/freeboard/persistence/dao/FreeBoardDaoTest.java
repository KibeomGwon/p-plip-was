package com.pplip.domain.board.freeboard.persistence.dao;

import com.pplip.domain.board.freeboard.api.response.FreeBoardResponse;
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
class FreeBoardDaoTest {

    @Autowired
    FreeBoardDao dao;

    @Test
    @DisplayName("search Test")
    void searchOneTest() {
        Optional<FreeBoardResponse.Detail> detail = dao.findById(1L);
        Assertions.assertThat(detail).isEmpty();
    }

    @Test
    @DisplayName("search All test")
    void searchAll() {
        // when
        List<FreeBoardResponse.BoardList> all = dao.findAll(new PageRequest(1, 20));
        // then
        Assertions.assertThat(all.size()).isEqualTo(0);
    }
}