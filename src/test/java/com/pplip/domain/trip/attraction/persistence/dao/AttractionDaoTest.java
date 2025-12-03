package com.pplip.domain.trip.attraction.persistence.dao;

import com.pplip.domain.trip.attraction.api.response.AttractionResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AttractionDaoTest {

    @Autowired
    AttractionDao dao;

    @Test
    @DisplayName("find one")
    void findOne() {
        // when
        Optional<AttractionResponse.Details> byNo = dao.findByNo(1l);
        // then
        Assertions.assertThat(byNo).isEmpty();
    }
}