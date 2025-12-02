package com.pplip.domain.trip.plan.persistence.dao;

import com.pplip.domain.trip.plan.api.response.PlanResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlanDaoTest {

    @Autowired
    PlanDao dao;

    @Test
    @DisplayName("find all")
    void findAll() {
        // when
        List<PlanResponse.Summary> all = dao.findAll(1L);
        // then
        Assertions.assertThat(all.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("find one")
    void findOne() {
        // when
        Optional<PlanResponse.Detail> byId = dao.findById(1L);
        // then
        Assertions.assertThat(byId).isEmpty();
    }
}