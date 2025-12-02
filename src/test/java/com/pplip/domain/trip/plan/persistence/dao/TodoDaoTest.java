package com.pplip.domain.trip.plan.persistence.dao;

import com.pplip.domain.trip.plan.api.response.ToDoResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoDaoTest {

    @Autowired
    TodoDao dao;

    @Test
    @DisplayName("find all")
    void findAll() {
        // when
        List<ToDoResponse.Summary> allByUserId = dao.findAllByUserId(1L);
        // then
        assertThat(allByUserId.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("find all by plan")
    void findAllByPlan() {
        // when
        List<ToDoResponse.Summary> allByPlanId = dao.findAllByPlanId(1L);
        // then
        assertThat(allByPlanId.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("find one")
    void findOne() {
        // when
        Optional<ToDoResponse.Detail> byId = dao.findById(1L);
        // then
        assertThat(byId).isEmpty();
    }
}